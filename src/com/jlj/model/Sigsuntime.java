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
 * Sigsuntime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sigsuntime", schema = "dbo", catalog = "jtd")
public class Sigsuntime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Signpublicparam signpublicparam;
	private String week;
	private Integer orderid;
	private Set<Commontime> commontimes = new HashSet<Commontime>(0);

	// Constructors

	/** default constructor */
	public Sigsuntime() {
	}

	/** full constructor */
	public Sigsuntime(Signpublicparam signpublicparam, String week,
			Integer orderid, Set<Commontime> commontimes) {
		this.signpublicparam = signpublicparam;
		this.week = week;
		this.orderid = orderid;
		this.commontimes = commontimes;
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
	@JoinColumn(name = "publicid")
	public Signpublicparam getSignpublicparam() {
		return this.signpublicparam;
	}

	public void setSignpublicparam(Signpublicparam signpublicparam) {
		this.signpublicparam = signpublicparam;
	}

	@Column(name = "week", length = 10)
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sigsuntime")
	public Set<Commontime> getCommontimes() {
		return this.commontimes;
	}

	public void setCommontimes(Set<Commontime> commontimes) {
		this.commontimes = commontimes;
	}

}