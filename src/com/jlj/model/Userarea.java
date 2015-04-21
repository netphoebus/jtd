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
 * Userarea entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userarea", catalog = "jtd")
public class Userarea implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String uareaname;
	private String lat;
	private String lng;
	private Integer size;
	private Set<Sig> sigs = new HashSet<Sig>(0);

	// Constructors

	/** default constructor */
	public Userarea() {
	}

	/** full constructor */
	public Userarea(User user, String uareaname, String lat, String lng,
			Integer size, Set<Sig> sigs) {
		this.user = user;
		this.uareaname = uareaname;
		this.lat = lat;
		this.lng = lng;
		this.size = size;
		this.sigs = sigs;
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
	@JoinColumn(name = "uid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "uareaname", length = 30)
	public String getUareaname() {
		return this.uareaname;
	}

	public void setUareaname(String uareaname) {
		this.uareaname = uareaname;
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

	@Column(name = "size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userarea")
	public Set<Sig> getSigs() {
		return this.sigs;
	}

	public void setSigs(Set<Sig> sigs) {
		this.sigs = sigs;
	}

}