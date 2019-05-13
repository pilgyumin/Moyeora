package com.vo;

public class Location {
	double lag;
	double lng;
	int carmap;
	
	public Location() {
	}
	
	public Location(double lag, double lng, int carmap) {
		this.lag = lag;
		this.lng = lng;
		this.carmap = carmap;
	}

	public double getLag() {
		return lag;
	}

	public void setLag(double lag) {
		this.lag = lag;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public int getCarmap() {
		return carmap;
	}

	public void setCarmap(int carmap) {
		this.carmap = carmap;
	}

	@Override
	public String toString() {
		return "Location [lag=" + lag + ", lng=" + lng + ", carmap=" + carmap + "]";
	}

}
