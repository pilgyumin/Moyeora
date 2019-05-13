package com.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.frame.CrudBiz;
import com.retrofitvo.Result;
import com.vo.Car;
import com.vo.Cust;
import com.vo.Location;
import com.vo.Module;
import com.vo.Order;
import com.vo.Updatevo;

@RestController
public class MobileController {
	Server server;

	public MobileController() {
		try {
			server = new Server();
			new Thread(server).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("mc----------------------------------");
	}

	@Resource(name = "custbiz")
	CrudBiz<String, Integer, Double, Cust, Cust> custbiz;

	@Resource(name = "orderbiz")
	CrudBiz<String, Integer, Double, Order, Updatevo> orderbiz;

	@Resource(name = "carbiz")
	CrudBiz<String, Integer, Double, Car, Updatevo> carbiz;
	
	@Resource(name = "modulebiz")
	CrudBiz<String, Integer, Double, Module, Updatevo> modulebiz;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login.myr")
	@ResponseBody
	public Result login(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("login in");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		System.out.println(id);
		System.out.println(pw);

		Result login = null;
		Cust cust = null;
		try {
			cust = custbiz.getString(id);
			if (cust.getCust_pw().equals(pw)) {
				System.out.println("login success");
				login = new Result("success");

				return login;
			} else {
				System.out.println("pwfail");
				login = new Result("pwfail");
				return login;
			}
		} catch (NullPointerException e) {
			System.out.println("idfail");
			login = new Result("idfail");
			return login;
		} catch (Exception e) {
			System.out.println("exception");
			login = new Result("exception");
			return login;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/idcheck.myr")
	@ResponseBody
	public Result idcheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("idcheck in");
		Cust cust = null;
		Result result = null;
		String id = request.getParameter("id");

		try {
			cust = custbiz.getString(id);
			if (cust.getCust_id().equals(id)) {
				System.out.println("already");
				result = new Result("already");
				return result;
			}
		} catch (NullPointerException e) {
			System.out.println("able");
			result = new Result("able");
			return result;
		} catch (Exception e) {
			System.out.println("exception");
			result = new Result("exception");
			return result;
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register.myr")
	@ResponseBody
	public Result register(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register in");
		Cust cust = null;
		Result result = null;
		String cust_id = request.getParameter("id");
		String cust_pw = request.getParameter("pw");
		String cust_name = request.getParameter("name");
		String cust_birthdate = request.getParameter("birthdate");
		String cust_email = request.getParameter("email");
		String cust_sex = request.getParameter("sex");
		int cust_phone = Integer.parseInt(request.getParameter("phone"));
		String cust_address = request.getParameter("address");
		String cust_fav1 = request.getParameter("fav1");
		String cust_fav2 = request.getParameter("fav2");
		String cust_fav3 = request.getParameter("fav3");
		String cust_favcar = request.getParameter("favcar");

		cust = new Cust(cust_id, cust_pw, cust_name, cust_birthdate, cust_email, cust_phone, cust_address, cust_sex,
				cust_fav1, cust_fav2, cust_fav3, cust_favcar);

		System.out.println(cust);
		try {
			custbiz.register(cust);

			System.out.println("complete");
			result = new Result("complete");
		} catch (Exception e) {
			System.out.println("error");
			result = new Result("error");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/mydelete.myr")
	@ResponseBody
	public Result mydelete(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("mydelete");
		String id = request.getParameter("id");
		Result result = null;
		try {
			custbiz.removeString(id);
			System.out.println("delete success");
			result = new Result("complete");
		} catch (NullPointerException e) {
			System.out.println("fail");
			result = new Result("error");
			return result;
		} catch (Exception e) {
			System.out.println("exception");
			result = new Result("error");
			return null;
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/passwordchange.myr", method = RequestMethod.POST)
	public Result passwordchange(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		try {
			System.out.println("pwchange");
			Cust cust = custbiz.getString(id);
			cust.setCust_pw(pwd);
			custbiz.modify(cust);
		} catch (Exception e) {
			System.out.println(e);
			return new Result("error");
		}
		return new Result("complete");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dooropen.myr")
	public void Dooropen(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("Door Open!");

		String ip = request.getRemoteAddr();
		System.out.println(ip + " -> request");
		ArrayList<Order> ar = null;
		Order order = null;
		try {
			ar = orderbiz.getArString(id);
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}

			int cid = order.getCid();
			Car car = carbiz.getInt(cid);
			car.setDoor("open");
			carbiz.modify(car);
			HashMap<String, String> apptoip = server.getApptoip();
			apptoip.put(ip,car.getCarip());
			server.setApptoip(apptoip);
			server.sendMsg(ip+"/000"+ cid + "00040000000000000001");
			System.out.println(server.getApptoip().size());
			
			System.out.println("Door open command complete!!");
		} catch (Exception e) {
			System.out.println("Door open error!");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/opencheck.myr")
	public Result opencheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("opencheck!!");
		ArrayList<Order> ar = null;
		Order order = null;
		Car car = null;
		Result result = null;
		try {
			ar = orderbiz.getArString(id);
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}
			int cid = order.getCid();
			car = carbiz.getInt(cid);
			if(car.getDoor().equals("close")) {
				result = new Result("close");
			}
			else {
				result = new Result("open");
			}
		} catch (NullPointerException e) {
			System.out.println("Null");
			return new Result("error");
		} catch (Exception e) {
			System.out.println("exception");
			return new Result("error");
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/doorlock.myr")
	public void Doorlock(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("Door lock!");

		String ip = request.getRemoteAddr();
		System.out.println(ip + " -> request");
		ArrayList<Order> ar = null;
		Order order = null;
		try {
			ar = orderbiz.getArString(id);
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}

			int cid = order.getCid();
			Car car = carbiz.getInt(cid);
			car.setDoor("close");
			carbiz.modify(car);
			String message = ip+"/000"+ cid + "00040000000000000000";
			server.sendMsg(message);
			
			System.out.println("Door lock command complete!!");
		} catch (Exception e) {
			System.out.println("Door lock error!");
		}
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/extend.myr")
	public Result extend(HttpServletRequest request) {
		System.out.println("car extend!!!!");
		String id = request.getParameter("id");
		String time = request.getParameter("time");
		ArrayList<Order> ar = null;
		Order order = null;
		Car car = null;
		Result result = null;
		try {
			ar = orderbiz.getArString(id);
			System.out.println("car extend arsize : "+ar.size());
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					System.out.println("car extennd get : "+ i);
					break;
				}
			}
			order.setEtime(time);
			orderbiz.modify(order);
			result = new Result("complete"); 
		} catch (NullPointerException e) {
			System.out.println("Null");
			result = new Result("null");
		} catch (Exception e) {
			System.out.println("exception");
			result = new Result("error");
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/carreturn.myr")
	public Result carreturn(HttpServletRequest request) {
		String id = request.getParameter("id");
		ArrayList<Order> ar = null;
		Order order = null;
		Result result = null;
		try {
			ar = orderbiz.getArString(id);
			System.out.println("car return arsize : "+ar.size());
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					System.out.println("car return get : "+i);
					break;
				}
			}
			System.out.println(order);
			order.setOstatus("운행완료");
			order.setInsert("운행중");
			System.out.println(order);
			int cid = order.getCid();
			Car car = carbiz.getInt(cid);
			int mid = order.getMid();
			Module module = modulebiz.getInt(mid);
			module.setMstatus("미사용중");
			car.setCstatus("미사용중");
			boolean[] b = server.getcarmapping();
			b[car.getCid()] = false;
			modulebiz.modify(module);
			carbiz.modify(car);
			orderbiz.modify(order);
			result = new Result("complete"); 
		} catch (NullPointerException e) {
			System.out.println(e);
			result = new Result("null");
		} catch (Exception e) {
			System.out.println(e);
			result = new Result("error");
		}
		return result;
	}

	
	

	@RequestMapping(method = RequestMethod.POST, value = "/getcustom.myr")
	@ResponseBody
	public Cust Getcustom(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		Cust cust = null;
		try {
			cust = custbiz.getString(id);
			System.out.println("getcustom success!!");

		} catch (NullPointerException e) {
			System.out.println("null!!!");
			return null;
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
		return cust;
	}
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/customize.myr")
	public Result customize(HttpServletRequest request) {

		String light = request.getParameter("light");
		String temp = request.getParameter("temp");
		String seat = request.getParameter("seat");
		String car = request.getParameter("car");
		String cust_id = request.getParameter("id");

		Result result = new Result("complete");
		Cust cust = new Cust(cust_id, light, temp, seat, car);

		try {
			custbiz.modifyColumn(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("customize" + cust_id);

		return result;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/myinfo.myr")
	@ResponseBody
	public Cust myinfo(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("myinfo");
		String id = request.getParameter("id");
		Cust cust = null;
		try {
			cust = custbiz.getString(id);
			System.out.println("my info success");
			System.out.println(cust);
		} catch (NullPointerException e) {
			System.out.println("fail");
			return null;
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
		return cust;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reregister.myr")
	@ResponseBody
	public Result reregister(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("reregister in");
		String ip = request.getRemoteAddr();
		Order order = null;
		Result result = null;

		String mtype = request.getParameter("mtype");
		String moption1 = request.getParameter("moption1");
		String moption2 = request.getParameter("moption2");
		String moption3 = request.getParameter("moption3");
		String moption4 = request.getParameter("moption4");
		int totalprice = Integer.parseInt(request.getParameter("totalprice"));
		Double slng = Double.parseDouble(request.getParameter("slag"));
		Double slag = Double.parseDouble(request.getParameter("slng"));
		Double elng = Double.parseDouble(request.getParameter("elag"));
		Double elag = Double.parseDouble(request.getParameter("elng"));
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String ostatus = request.getParameter("ostatus");
		String cust_id = request.getParameter("cust_id");


		try {
			ArrayList<Car> carAr = carbiz.getArString("미사용중");
			if(carAr.size() == 0) {
				return new Result("예약가능차량없음");
			}
			Cust cust = custbiz.getString(cust_id);			
			Car car = carAr.get(0);
			car.setLight(cust.getCtmlgt());
			car.setHtemp(cust.getCtmtep());
			car.setSeat(cust.getCtmseat());
			car.setCstatus("사용중");
			
			ArrayList<Module> moduleAr = modulebiz.getArString("미사용중");
			Module module = moduleAr.get(0);
			module.setMoption1(moption1);
			module.setMoption2(moption2);
			module.setMoption3(moption3);
			module.setMoption4(moption4);
			module.setMtype(mtype);
			module.setMstatus("사용중");
			
			order = new Order(mtype,moption1,moption2,moption3,moption4,totalprice,slng,slag,elng,elag,stime,etime,ostatus,car.getCid(),cust_id,module.getMid());
			orderbiz.register(order);
			
			HashMap<String, String> apptoip = server.getApptoip();
			apptoip.put(ip,car.getCarip());
			server.setApptoip(apptoip);
			
			System.out.println(server.getApptoip().size());
			carbiz.modify(car);
			modulebiz.modify(module);
			System.out.println("complete");
			result = new Result("complete");
		} catch (Exception e) {
			System.out.println("error");
			result = new Result("error");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reservationConfirm.myr")
	@ResponseBody
	public Result reservationConfirm(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("reservation confirm");
		String id = request.getParameter("id");
		ArrayList<Order> ar = null;
		Order order = null;
		Result result = null;
		try {
			ar = orderbiz.getArString(id);
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}
			System.out.println(order);
			if(order == null) {
				System.out.println("null");
				result = new Result("null");
			}
			else {
				System.out.println("reservation confirm success!!");
				result = new Result("complete");
			}
			
		} catch (NullPointerException e) {
			System.out.println("null");
			return new Result("null");
		} catch (Exception e) {
			System.out.println("exception");
			return new Result("error");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/reservationCheck.myr")
	@ResponseBody
	public Order reservationCheck(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("reservation check");
		String id = request.getParameter("id");
		ArrayList<Order> ar = null;
		Order order = null;
		try {
			ar = orderbiz.getArString(id);
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}
			System.out.println("reservation check success!!");
			System.out.println(order);
		} catch (NullPointerException e) {
			System.out.println("null");
			return null;
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
		return order;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reservationcancel.myr", method = RequestMethod.POST)
	public Result reservationcancel(HttpServletRequest request) {
		String id = request.getParameter("id");
		try {
			System.out.println("reservationcancel");
			orderbiz.removeString(id);
			System.out.println("cancel complete");
		} catch (Exception e) {
			return new Result("error");
		}
		return new Result("complete");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/carreceive.myr")
	@ResponseBody
	public Result carreceive(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("carreceive");
		try {
			ArrayList<Order> ar = orderbiz.getArString(id);
			Order order = null;
			for (int i = 0; i < ar.size(); i++) {
				if (ar.get(i).getOstatus().equals("예약완료")) {
					order = ar.get(i);
				}
			}
			order.setOstatus("운행중");
			order.setInsert("예약완료");
			orderbiz.modify(order);
			System.out.println("carreceive complete!!!");
		}
		catch (NullPointerException e) {
			System.out.println(e);
			return new Result("null");	
		} 
		catch (Exception e) {
			System.out.println(e);
			return new Result("error");	
		}
		return new Result("complete");	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/checkreceive.myr")
	@ResponseBody
	public Result checkreceive(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("checkreceive");
		Result result = null;
		try {
			ArrayList<Order> ar = orderbiz.getArString(id);
			Order order = null;
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}
			if(order.getOstatus().equals("예약완료")) {
				result = new Result("reservation");
			}
			else if(order.getOstatus().equals("운행중")) {
				result = new Result("driving");
			}
			System.out.println("check receive complete!!!");
		}
		catch (NullPointerException e) {
			System.out.println(e);
			return new Result("null");	
		} 
		catch (Exception e) {
			System.out.println(e);
			return new Result("error");	
		}
		System.out.println("resulr : " + result.toString());
		return result;	
	}

	

	@ResponseBody
	@RequestMapping(value = "/idlocation.myr", method = RequestMethod.POST)
	public Location idlocation(HttpServletRequest request) {
		String id = request.getParameter("cid");
		Location location = null;
		try {
			System.out.println("idlocation");
			int cid = Integer.parseInt(id);
			Car car = carbiz.getInt(cid);
			System.out.println(car);
			String lat = car.getGpsx();
			String lng = car.getGpsy();
			lat = "3" + lat.substring(0, 1) + "." + lat.substring(1);
			lng = "12" + lng.substring(0, 1) + "." + lng.substring(1);
			int carmap = car.getCarmap();
			double dlat = Double.parseDouble(lat);
			double dlng = Double.parseDouble(lng);
			location = new Location(dlat, dlng, carmap);
			System.out.println(dlat + " " + dlng + " " + carmap);

		} catch (Exception e) {
		}

		return location;
	}
	
	

	
	
	@RequestMapping(method = RequestMethod.POST, value = "/mapoff.myr")
	@ResponseBody
	public Result mapoff(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String cmap = request.getParameter("carmap");
		System.out.println("mapoff");
		System.out.println(id + " " + cmap);
		try {
			ArrayList<Order> ar = orderbiz.getArString(id);
			Order order = null;
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
				}
			}
			int cid = order.getCid();
			Car car = carbiz.getInt(cid);
			System.out.println("---------------" + car);
			car.setCarmap(Integer.parseInt(cmap));
			carbiz.modify(car);
			System.out.println("-------------------------" + car);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

	
	
	public class Server implements Runnable {

		private ServerSocket serverSocket;
		private int port = 9999;
		private boolean flag = true;
		private Socket socket;
		private final int carnum = 3;
		
		private boolean[] carmapping;
		private HashMap<String, String> apptoip;
		private HashMap<String, DataOutputStream> apptocar;
		private ArrayList<DataOutputStream> list;

		String client;

		public Server() throws IOException {
			System.out.println("server generator");
			list = new ArrayList<>();
			apptoip = new HashMap<String,String>();
			apptocar = new HashMap<String, DataOutputStream>();
			serverSocket = new ServerSocket(port);
			carmapping = new boolean[carnum + 1];
			carmapping[0] = true;
		}
		
		public HashMap<String,String> getApptoip(){
			return apptoip;
		}
		
		public void setApptoip(HashMap<String,String> ati) {
			this.apptoip = ati;
		}

		public HashMap<String, DataOutputStream> getApptocar(){
			return apptocar;
		}
		
		public void setApptocar(HashMap<String, DataOutputStream> hm) {
			this.apptocar = hm;
		}
		
		public boolean[] getcarmapping() {
			return this.carmapping;
		}
		
		public void setcarmapping(boolean[] carmapping) {
			this.carmapping = carmapping;
		}


		@Override
		public void run() {
			while (flag) {
				System.out.println("Ready Server ...");
				Socket socket;
				try {
					socket = serverSocket.accept();
					client = socket.getInetAddress().getHostAddress();
					new Receiver(socket, client).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(client);
			}
		}

		public void sendMsg(String msg) {

			Sender sender = new Sender();
			sender.setMsg(msg);
			sender.start();
		}

		class Receiver extends Thread {

			InputStream is;
			DataInputStream dis;
			String client;

			// For Sender..
			OutputStream os;
			DataOutputStream dos;

			public Receiver(Socket socket, String client) throws Exception {
				this.client = client;
				is = socket.getInputStream();
				dis = new DataInputStream(is);

				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				apptocar.put(client, dos);
				list.add(dos);
				int cid = 0;
				for(int i = 0; i < carmapping.length; i++) {
					if(!carmapping[i]) {
						cid = i;
						break;
					}
				}
				System.out.println("carid : " + cid + ", ip : " + client);
				Car car = carbiz.getInt(cid);
				car.setCarip(client);
				carbiz.modify(car);
				System.out.println("Connected Cnt:" + list.size());
			}

			@Override
			public void run() {
				while (dis != null) {
					try {
						String msg = dis.readUTF();
						System.out.println("cartoin "+client + ":" + msg);
						int id = Integer.parseInt(msg.substring(0, 4));
						Car car = carbiz.getInt(id);
						
						int category = Integer.parseInt(msg.substring(4, 8));
						
						switch(category) {
						case 1:
							int data = Integer.parseInt(msg.substring(8));
							car.setRpm(String.valueOf(data));
							break;
						case 2:
							int data2 = Integer.parseInt(msg.substring(8));
							car.setSpeed(String.valueOf(data2));
							break;
						case 3:
							int data3 = Integer.parseInt(msg.substring(8));
							car.setPtemp(String.valueOf(data3));
							break;
						case 4:
							int data4 = Integer.parseInt(msg.substring(8));
							if(data4 == 2 || data4 == 0) {
								car.setDoor("close");
							}
							else if(data4 == 3 || data4 == 1) {
								car.setDoor("open");
							}
							break;
						case 5:
							int data5 = Integer.parseInt(msg.substring(8));
							car.setLight(String.valueOf(data5));
							break;
						case 6:
							int data6 = Integer.parseInt(msg.substring(8));
							car.setBattery(String.valueOf(data6));
							break;
						case 7:
							int data7 = Integer.parseInt(msg.substring(8));
							car.setSeat(String.valueOf(data7));
							break;
						case 8:
							String lat = msg.substring(8, 16);
				            String lng =  msg.substring(16, 24);
//				            lat="3"+lat.substring(0,1)+"."+lat.substring(1);
//				            lng="12"+lng.substring(0, 1)+"."+lng.substring(1);
				            car.setGpsx(lat);
				            car.setGpsy(lng);
							break;
						}
						carbiz.modify(car);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("exception!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						break;
					}
				} // end while

				try {
					list.remove(dos);
					System.out.println("Connected Cnt2:" + list.size());
					Thread.sleep(100);
					if (dis != null) {
						dis.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		class Sender extends Thread {

			String msg;

			public void setMsg(String msg) {
				this.msg = msg;
			}

			@Override
			public void run() {
				String[] s = msg.split("/");
				String carip = apptoip.get(s[0]);
				System.out.println(carip + " " + s[1]);
				DataOutputStream out = apptocar.get(carip);
				if (out != null) {
					try {
						out.writeUTF(s[1]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
