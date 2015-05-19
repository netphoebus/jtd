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
 * Solution entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "solution", schema = "dbo", catalog = "jtd")
public class Solution implements java.io.Serializable {

	// Fields

	private Integer id;
	private Signpublicparam signpublicparam;
	private Commontime commontime;
	private String soluname;
	private Integer orderid;
	private List<Phase> phases = new ArrayList<Phase>(0);

	// Constructors

	/** default constructor */
	public Solution() {
	}

	/** full constructor */
	public Solution(Signpublicparam signpublicparam, Commontime commontime,
			String soluname, Integer orderid, List<Phase> phases) {
		this.signpublicparam = signpublicparam;
		this.commontime = commontime;
		this.soluname = soluname;
		this.orderid = orderid;
		this.phases = phases;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commonid")
	public Commontime getCommontime() {
		return this.commontime;
	}

	public void setCommontime(Commontime commontime) {
		this.commontime = commontime;
	}

	@Column(name = "soluname", length = 30)
	public String getSoluname() {
		return this.soluname;
	}

	public void setSoluname(String soluname) {
		this.soluname = soluname;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "solution")
	public List<Phase> getPhases() {
		return this.phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

}