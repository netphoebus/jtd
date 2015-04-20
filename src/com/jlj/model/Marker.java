package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Marker entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "marker", catalog = "jtd")
public class Marker implements java.io.Serializable {

	// Fields

	private Long id;
	private Signal signal;
	private String name;
	private String address;
	private String lat;
	private String lng;
	private String ip;

	// Constructors

	/** default constructor */
	public Marker() {
	}

	/** full constructor */
	public Marker(Signal signal, String name, String address, String lat,
			String lng, String ip) {
		this.signal = signal;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.ip = ip;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sid")
	public Signal getSignal() {
		return this.signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "lat", length = 50)
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name = "lng", length = 50)
	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Column(name = "ip", length = 30)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}