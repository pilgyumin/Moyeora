package com.retrofitvo;

public class Result {
	private String message;

	public Result(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Login [message=" + message + "]";
	}
	
	
}
