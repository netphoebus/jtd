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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Sig entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sig", schema = "dbo", catalog = "jtd")
public class Sig implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userarea userarea;
	private String name;
	private String address;
	private String lat;
	private String lng;
	private String ip;
	private Long mkid;
	private Signpublicparam signpublicparam;
	private Sigsystime sigsystime;
	private List<Devlog> devlogs = new ArrayList<Devlog>();
	

	// Constructors

	/** default constructor */
	public Sig() {
	}

	/** full constructor */
	public Sig(Userarea userarea, String name, String address, String lat,
			String lng, String ip, Long mkid,
			Signpublicparam signpublicparam, List<Devlog> devlogs,
			Sigsystime sigsystime) {
		this.userarea = userarea;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.ip = ip;
		this.mkid = mkid;
		this.signpublicparam = signpublicparam;
		this.devlogs = devlogs;
		this.sigsystime = sigsystime;
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

	@Column(name = "mkid")
	public Long getMkid() {
		return this.mkid;
	}

	public void setMkid(Long mkid) {
		this.mkid = mkid;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public List<Devlog> getDevlogs() {
		return this.devlogs;
	}

	public void setDevlogs(List<Devlog> devlogs) {
		this.devlogs = devlogs;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Signpublicparam getSignpublicparam() {
		return signpublicparam;
	}

	public void setSignpublicparam(Signpublicparam signpublicparam) {
		this.signpublicparam = signpublicparam;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Sigsystime getSigsystime() {
		return sigsystime;
	}

	public void setSigsystime(Sigsystime sigsystime) {
		this.sigsystime = sigsystime;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
//	public Set<Signpublicparam> getSignpublicparams() {
//		return this.signpublicparams;
//	}
//
//	public void setSignpublicparams(Set<Signpublicparam> signpublicparams) {
//		this.signpublicparams = signpublicparams;
//	}
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
//	public Set<Sigsystime> getSigsystimes() {
//		return this.sigsystimes;
//	}
//
//	public void setSigsystimes(Set<Sigsystime> sigsystimes) {
//		this.sigsystimes = sigsystimes;
//	}

	
}