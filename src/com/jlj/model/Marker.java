package com.jlj.model;

public class Marker {

	private long id;
	private String name;
	private String address;
	private String lng;
	private String lat;
	private String ip;
	

	public String toString()
	{
		return "id:"+this.id+"  "+"name:"+this.name+"  "+"address:"+this.address+"  "+"ip:"+this.ip+"  "+"lng:"+this.lng+"  "+"lat:"+this.lat+"  ";
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
