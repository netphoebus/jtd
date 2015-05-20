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
 * Sigordinarytime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sigordinarytime", schema = "dbo", catalog = "jtd")
public class Sigordinarytime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Commontime commontime;
	private Integer orderid;

	// Constructors

	/** default constructor */
	public Sigordinarytime() {
	}

	/** full constructor */
	public Sigordinarytime(Commontime commontime, Integer orderid) {
		this.commontime = commontime;
		this.orderid = orderid;
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
	@JoinColumn(name = "commonid")
	public Commontime getCommontime() {
		return this.commontime;
	}

	public void setCommontime(Commontime commontime) {
		this.commontime = commontime;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}