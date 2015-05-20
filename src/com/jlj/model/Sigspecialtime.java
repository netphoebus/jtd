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
 * Sigspecialtime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sigspecialtime", schema = "dbo", catalog = "jtd")
public class Sigspecialtime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Commontime commontime;
	private Integer specialmonth;
	private Integer specialday;
	private Integer orderid;

	// Constructors

	/** default constructor */
	public Sigspecialtime() {
	}

	/** full constructor */
	public Sigspecialtime(Commontime commontime, Integer specialmonth,
			Integer specialday, Integer orderid) {
		this.commontime = commontime;
		this.specialmonth = specialmonth;
		this.specialday = specialday;
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

	@Column(name = "specialmonth")
	public Integer getSpecialmonth() {
		return this.specialmonth;
	}

	public void setSpecialmonth(Integer specialmonth) {
		this.specialmonth = specialmonth;
	}

	@Column(name = "specialday")
	public Integer getSpecialday() {
		return this.specialday;
	}

	public void setSpecialday(Integer specialday) {
		this.specialday = specialday;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}