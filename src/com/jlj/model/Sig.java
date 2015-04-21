package com.jlj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sig entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sig", catalog = "jtd")
public class Sig implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userarea userarea;
	private String name;
	private String address;
	private String lat;
	private String lng;
	private String ip;
	private List<Devlog> devlogs = new ArrayList<Devlog>(0);

	// Constructors

	/** default constructor */
	public Sig() {
	}

	/** full constructor */
	public Sig(Userarea userarea, String name, String address, String lat,
			String lng, String ip, List<Devlog> devlogs) {
		this.userarea = userarea;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.ip = ip;
		this.devlogs = devlogs;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uaid")
	public Userarea getUserarea() {
		return this.userarea;
	}

	public void setUserarea(Userarea userarea) {
		this.userarea = userarea;
	}

	@Column(name = "name", length = 50)
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

	@Column(name = "lat", length = 30)
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Column(name = "lng", length = 30)
	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Column(name = "ip", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public List<Devlog> getDevlogs() {
		return this.devlogs;
	}

	public void setDevlogs(List<Devlog> devlogs) {
		this.devlogs = devlogs;
	}

}