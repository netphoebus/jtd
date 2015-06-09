package com.jlj.vo;

public class SigStatus {
	private String name;
	private String status;
	public SigStatus(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
