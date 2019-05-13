package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.CrudBiz;
import com.frame.CrudDao;
import com.vo.Admin;
import com.vo.Car;
import com.vo.Cust;
import com.vo.Order;
import com.vo.Updatevo;

@Controller
public class WebController {

	@Resource(name = "custbiz")
	CrudBiz<String, Integer, Double, Cust, Updatevo> biz;

	@Resource(name = "carbiz")
	CrudBiz<String, Integer, Double, Car, Updatevo> biz2;

	@Resource(name = "adminbiz")
	CrudBiz<String, Integer, Double, Admin, Updatevo> biz4;

	@Resource(name = "orderbiz")
	CrudBiz<String, Integer, Double, Order, Updatevo> biz5;

	@RequestMapping("/wmain.myr")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;

		mv.setViewName("wmain");
		try {
			list = biz.getall();
			mv.addObject("wcenter", "wcenter");
			mv.addObject("clist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/wlogin.myr")
	public ModelAndView wlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("wmain");
		mv.addObject("wcenter", "wlogin");
		return mv;
	}

	@RequestMapping("/wlogout.myr")
	public ModelAndView wlogout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("login_admin");
		mv.setViewName("wmain");
		mv.addObject("wcenter", "wlogin");
		System.out.println("dd");
		return mv;
	}

	@RequestMapping("/wloginimpl.myr")
	public ModelAndView wloginimpl(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;
		Admin admin;
		mv.setViewName("wmain");
		try {
			admin = biz4.getString("admin");
			if (request.getParameter("id").equals(admin.getAid())
					&& request.getParameter("password").equals(admin.getApwd())) {
				session.setAttribute("login_admin", admin);
				list = biz.getall();
				mv.addObject("wcenter", "wcenter");
				mv.addObject("clist", list);
			} else {
				mv.addObject("wcenter", "wlogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("wcenter", "wlogin");
		}
		return mv;
	}

	@RequestMapping("/wcartable.myr")
	public ModelAndView wcartable(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Car> list = null;

		mv.setViewName("wmain");
		try {
			list = biz2.getall();
			mv.addObject("wcenter", "wcartable");
			mv.addObject("carlist", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/wcusttable.myr")
	public ModelAndView wcusttable(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;

		mv.setViewName("wmain");
		try {
			list = biz.getall();
			mv.addObject("wcenter", "wcusttable");
			mv.addObject("clist", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;

	}

	@RequestMapping("/wcustst.myr")
	public ModelAndView wcsutst(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String cust_id = request.getParameter("cust_id");
		ArrayList<Order> olist = null;
		Cust cust = null;

		mv.setViewName("wmain");
		try {
			cust = biz.getString(cust_id);
			olist = biz5.getArString(cust_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("wcenter", "wcustst");
		mv.addObject("cust", cust);
		mv.addObject("olist", olist);
		return mv;

	}

	@RequestMapping("/wcharts.myr")
	public ModelAndView wcharts() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;
		ArrayList<Cust> mlist = null;
		ArrayList<Cust> flist = null;
		ArrayList<Order> olist = null;
		int febcost = 0;
		int jancost = 0;
		int deccost = 0;
		int novcost = 0;
		try {
			list = biz.getall();
			olist = biz5.getall();
			double all = list.size();
			mlist = biz.getArString("남자");
			double mall = mlist.size();
			flist = biz.getArString("여자");
			double fall = flist.size();
			double mportion = mall / all * 100;
			double fportion = fall / all * 100;
			int mpor = (int) mportion;
			int fpor = (int) fportion;
			for (int i = 0; i < olist.size(); i++) {
				System.out.println(olist.get(i).getStime());
				System.out.println(olist.get(i).getOdate().toString());
				System.out.println(olist.get(i).getOdate().toString().substring(4, 7));
				if (olist.get(i).getOdate().toString().substring(4, 7).equals("Feb")) {
					febcost += olist.get(i).getTotalprice();
				}
				;
				if (olist.get(i).getOdate().toString().substring(4, 7).equals("Jan")) {
					jancost += olist.get(i).getTotalprice();
				}
				;
				if (olist.get(i).getOdate().toString().substring(4, 7).equals("Dec")) {
					deccost += olist.get(i).getTotalprice();
				}
				;
				if (olist.get(i).getOdate().toString().substring(4, 7).equals("Nov")) {
					novcost += olist.get(i).getTotalprice();
				}
				;
				System.out.println(febcost + "," + jancost + "," + deccost + "," + novcost);

			}
			int ref = 0; // 냉장고
			int mic = 0; // 전자레인지
			int gas = 0; // 가스레인지
			int des = 0; // 책상
			int mas = 0; // 안마의
			int pri = 0; // 프린터
			int com = 0; // 컴퓨터
			int tel = 0; // TV
			int cha = 0; // 의자
			for (int i = 0; i < olist.size(); i++) {

				String moption1 = olist.get(i).getMoption1();
				String moption2 = olist.get(i).getMoption2();
				String moption3 = olist.get(i).getMoption3();
				String moption4 = olist.get(i).getMoption4();
				System.out.println(moption1 + ", " + moption2 + ", " + moption3 + ", " + moption4);
				switch (moption1) {
				case "냉장고":
					ref += 1;
					break;
				case "전자레인지":
					mic += 1;
					break;
				case "가스레인지":
					gas += 1;
					break;
				case "책상":
					des += 1;
					break;
				case "안마의자":
					mas += 1;
					break;
				case "프린터":
					pri += 1;
					break;
				case "컴퓨터":
					com += 1;
					break;
				case "TV":
					tel += 1;
					break;
				case "의자":
					cha += 1;
					break;
				}
				switch (moption2) {
				case "냉장고":
					ref += 1;
					break;
				case "전자레인지":
					mic += 1;
					break;
				case "가스레인지":
					gas += 1;
					break;
				case "책상":
					des += 1;
					break;
				case "안마의자":
					mas += 1;
					break;
				case "프린터":
					pri += 1;
					break;
				case "컴퓨터":
					com += 1;
					break;
				case "TV":
					tel += 1;
					break;
				case "의자":
					cha += 1;
					break;
				}
				switch (moption3) {
				case "냉장고":
					ref += 1;
					break;
				case "전자레인지":
					mic += 1;
					break;
				case "가스레인지":
					gas += 1;
					break;
				case "책상":
					des += 1;
					break;
				case "안마의자":
					mas += 1;
					break;
				case "프린터":
					pri += 1;
					break;
				case "컴퓨터":
					com += 1;
					break;
				case "TV":
					tel += 1;
					break;
				case "의자":
					cha += 1;
					break;
				}
				switch (moption4) {
				case "냉장고":
					ref += 1;
					break;
				case "전자레인지":
					mic += 1;
					break;
				case "가스레인지":
					gas += 1;
					break;
				case "책상":
					des += 1;
					break;
				case "안마의자":
					mas += 1;
					break;
				case "프린터":
					pri += 1;
					break;
				case "컴퓨터":
					com += 1;
					break;
				case "TV":
					tel += 1;
					break;
				case "의자":
					cha += 1;
					break;
				}
				System.out.println(ref + ", " + mic + ", " + gas);
			}

			mv.setViewName("wmain");
			mv.addObject("wcenter", "wcharts");
			mv.addObject("mportion", mpor);
			mv.addObject("fportion", fpor);
			mv.addObject("feb", febcost);
			mv.addObject("jan", jancost);
			mv.addObject("dec", deccost);
			mv.addObject("nov", novcost);
			mv.addObject("ref", ref);
			mv.addObject("mic", mic);
			mv.addObject("gas", gas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/wordertable.myr")
	public ModelAndView wordertable() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Order> list = null;

		mv.setViewName("wmain");
		try {
			list = biz5.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("wcenter", "wordertable");
		mv.addObject("olist", list);
		return mv;

	}

	@RequestMapping("/worderst.myr")
	public ModelAndView worderst(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int oid = Integer.parseInt(request.getParameter("oid"));
		Order order = null;

		mv.setViewName("wmain");
		try {
			order = biz5.getInt(oid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("wcenter", "worderst");
		mv.addObject("olist", order);
		return mv;

	}

	@RequestMapping("/wmap.myr")
	public ModelAndView wmap(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int cid = Integer.parseInt(request.getParameter("cid"));
		Car stcar = null;

		mv.setViewName("wmap");
		mv.addObject("wcenter", "wlocation");

		try {
			stcar = biz2.getInt(cid);
			String lat = stcar.getGpsx();
			String lng = stcar.getGpsy();
			lat = "3" + lat.substring(0, 1) + "." + lat.substring(1);
			lng = "12" + lng.substring(0, 1) + "." + lng.substring(1);
			double dlat = Double.parseDouble(lat);
			double dlng = Double.parseDouble(lng);
			mv.addObject("carst", stcar);
			mv.addObject("lat", dlat);
			mv.addObject("lng", dlng);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/carlocation.myr")
	   public ModelAndView carlocation(HttpServletRequest request) {
	      ModelAndView mv = new ModelAndView();
	      String id = request.getParameter("id");
	      mv.setViewName("map");
	      try {
	         ArrayList<Order> ar = biz5.getArString(id);
	         Order order = null;
	         for (int i = 0; i < ar.size(); i++) {
	            if (!ar.get(i).getOstatus().equals("운행완료")) {
	               order = ar.get(i);
	            }
	         }
	         int cid = order.getCid();
	         System.out.println(cid + " ------");
	         double slng = order.getSlng();
	         double slag = order.getSlag();
	         double elng = order.getElng();
	         double elag = order.getElag();
	      
	            System.out.println(slng + " " + slag);
	            System.out.println(elng + " " + elag);
	           Car car = biz2.getInt(cid);
	            String lat =car.getGpsx();
	            String lng = car.getGpsy();
	            lat="3"+lat.substring(0,1)+"."+lat.substring(1);
	            lng="12"+lng.substring(0, 1)+"."+lng.substring(1);
	            double dlat= Double.parseDouble(lat);
	            double dlng= Double.parseDouble(lng);

	            System.out.println(dlng + " " + dlat);
	            mv.addObject("slng", slng);
	            mv.addObject("slag", slag);
	         mv.addObject("elng", elng);
	         mv.addObject("elag", elag);
	         mv.addObject("gpsx", dlng);
	         mv.addObject("gpsy", dlat);
	         mv.addObject("cid", cid);
	      } catch (Exception e) {}

	      return mv;
	   }
	   
	   @RequestMapping("/currentlocation.myr")
	   public ModelAndView currentlocation(HttpServletRequest request) {
	      ModelAndView mv = new ModelAndView();
	      String id = request.getParameter("id");
	      mv.setViewName("location");
	      try {
	         ArrayList<Order> ar = biz5.getArString(id);
	         Order order = null;
	         for (int i = 0; i < ar.size(); i++) {
	            if (!ar.get(i).getOstatus().equals("운행완료")) {
	               order = ar.get(i);
	            }
	         }
	         int cid = order.getCid();
	         double slng = order.getSlng();
	         double slag = order.getSlag();
	         double elng = order.getElng();
	         double elag = order.getElag();
	      
	            System.out.println(slng + " " + slag);
	            System.out.println(elng + " " + elag);
	           Car car = biz2.getInt(cid);
	            String lat =car.getGpsx();
	            String lng = car.getGpsy();
	            lat="3"+lat.substring(0,1)+"."+lat.substring(1);
	            lng="12"+lng.substring(0, 1)+"."+lng.substring(1);
	            double dlat= Double.parseDouble(lat);
	            double dlng= Double.parseDouble(lng);

	            System.out.println(dlng + " " + dlat);
	            mv.addObject("slng", slng);
	            mv.addObject("slag", slag);
	         mv.addObject("elng", elng);
	         mv.addObject("elag", elag);
	         mv.addObject("gpsx", dlng);
	         mv.addObject("gpsy", dlat);
	         mv.addObject("cid", cid);
	      } catch (Exception e) {}

	      return mv;
	   }

	@RequestMapping("/wcarst.myr")
	public ModelAndView wcarst(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int cid = Integer.parseInt(request.getParameter("cid"));
		ArrayList<Car> list = null;
		mv.setViewName("wmain");
		mv.addObject("wcenter", "wcartable");
		mv.addObject("w404", "wlocation");
		try {
			ArrayList<Order> ar = biz5.getArInt(cid);
			Order order = null;
			list = biz2.getall();
			for (int i = 0; i < ar.size(); i++) {
				if (!ar.get(i).getOstatus().equals("운행완료")) {
					order = ar.get(i);
					break;
				}
			}
			double slng = order.getSlng();
			double slag = order.getSlag();
			double elng = order.getElng();
			double elag = order.getElag();
			System.out.println(slng + " " + slag);
			System.out.println(elng + " " + elag);
			Car car = biz2.getInt(cid);
			String lat = car.getGpsx();
			String lng = car.getGpsy();
			lat = "3" + lat.substring(0, 1) + "." + lat.substring(1);
			lng = "12" + lng.substring(0, 1) + "." + lng.substring(1);
			double dlat = Double.parseDouble(lat);
			double dlng = Double.parseDouble(lng);
			System.out.println(dlng + " " + dlat);
			mv.addObject("slng", slng);
			mv.addObject("slag", slag);
			mv.addObject("carst", car);
			mv.addObject("carlist", list);
			mv.addObject("elng", elng);
			mv.addObject("elag", elag);
			mv.addObject("gpsx", dlng);
			mv.addObject("gpsy", dlat);
			mv.addObject("cid", cid);
		} catch (Exception e) {
		}

		return mv;
	}
	/*
	 * ModelAndView mv = new ModelAndView(); int cid =
	 * Integer.parseInt(request.getParameter("cid")); Car stcar; ArrayList<Car> list
	 * = null;
	 * 
	 * mv.setViewName("wmain");
	 * 
	 * try { list = biz2.getall(); stcar = biz2.getInt(cid); String lat =
	 * stcar.getGpsx(); String lng = stcar.getGpsy(); lat = "3" + lat.substring(0,
	 * 1) + "." + lat.substring(1); lng = "12" + lng.substring(0, 1) + "." +
	 * lng.substring(1); double dlat = Double.parseDouble(lat); double dlng =
	 * Double.parseDouble(lng); mv.addObject("wcenter", "wcartable");
	 * mv.addObject("w404", "wcarst"); mv.addObject("carlist", list);
	 * mv.addObject("carst", stcar); mv.addObject("lat", dlat); mv.addObject("lng",
	 * dlng); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return mv; }
	 */
}
