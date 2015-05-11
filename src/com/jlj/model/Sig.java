package com.jlj.model;

import java.util.HashSet;
import java.util.Set;
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
	private Set<Commontime> commontimes = new HashSet<Commontime>(0);
	private Set<Phase> phases = new HashSet<Phase>(0);
	private Set<Signpublicparam> signpublicparams = new HashSet<Signpublicparam>(
			0);
	private Set<Devlog> devlogs = new HashSet<Devlog>(0);
	private Set<Sigsystime> sigsystimes = new HashSet<Sigsystime>(0);

	// Constructors

	/** default constructor */
	public Sig() {
	}

	/** full constructor */
	public Sig(Userarea userarea, String name, String address, String lat,
			String lng, String ip, Long mkid, Set<Commontime> commontimes,
			Set<Phase> phases, Set<Signpublicparam> signpublicparams,
			Set<Devlog> devlogs, Set<Sigsystime> sigsystimes) {
		this.userarea = userarea;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.ip = ip;
		this.mkid = mkid;
		this.commontimes = commontimes;
		this.phases = phases;
		this.signpublicparams = signpublicparams;
		this.devlogs = devlogs;
		this.sigsystimes = sigsystimes;
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
	public Set<Commontime> getCommontimes() {
		return this.commontimes;
	}

	public void setCommontimes(Set<Commontime> commontimes) {
		this.commontimes = commontimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Set<Phase> getPhases() {
		return this.phases;
	}

	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Set<Signpublicparam> getSignpublicparams() {
		return this.signpublicparams;
	}

	public void setSignpublicparams(Set<Signpublicparam> signpublicparams) {
		this.signpublicparams = signpublicparams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Set<Devlog> getDevlogs() {
		return this.devlogs;
	}

	public void setDevlogs(Set<Devlog> devlogs) {
		this.devlogs = devlogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sig")
	public Set<Sigsystime> getSigsystimes() {
		return this.sigsystimes;
	}

	public void setSigsystimes(Set<Sigsystime> sigsystimes) {
		this.sigsystimes = sigsystimes;
	}

}