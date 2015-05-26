package com.jlj.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Commontime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commontime", schema = "dbo", catalog = "jtd")
public class Commontime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sig sig;
	private Integer hour;
	private Integer minute;
	private Integer seconds;
	private Integer workingway;
	private Integer workingprogram;
	private Integer lstime;
	private Integer hdtime;
	private Integer qchdtime;
	private Integer orderid;
	private Integer timetype;

	// Constructors

	/** default constructor */
	public Commontime() {
	}

	/** full constructor */
	public Commontime(Sig sig, Integer hour, Integer minute,
			Integer seconds, Integer workingway, Integer workingprogram,
			Integer lstime, Integer hdtime, Integer qchdtime,Integer orderid,Integer timetype) {
		this.sig = sig;
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.workingway = workingway;
		this.workingprogram = workingprogram;
		this.lstime = lstime;
		this.hdtime = hdtime;
		this.qchdtime = qchdtime;
		this.orderid = orderid;
		this.timetype = timetype;
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
	@JoinColumn(name = "signid")
	public Sig getSig() {
		return this.sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	

	@Column(name = "hour")
	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	@Column(name = "minute")
	public Integer getMinute() {
		return this.minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	@Column(name = "seconds")
	public Integer getSeconds() {
		return this.seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	@Column(name = "workingway")
	public Integer getWorkingway() {
		return this.workingway;
	}

	public void setWorkingway(Integer workingway) {
		this.workingway = workingway;
	}

	@Column(name = "workingprogram")
	public Integer getWorkingprogram() {
		return this.workingprogram;
	}

	public void setWorkingprogram(Integer workingprogram) {
		this.workingprogram = workingprogram;
	}

	@Column(name = "lstime")
	public Integer getLstime() {
		return this.lstime;
	}

	public void setLstime(Integer lstime) {
		this.lstime = lstime;
	}

	@Column(name = "hdtime")
	public Integer getHdtime() {
		return this.hdtime;
	}

	public void setHdtime(Integer hdtime) {
		this.hdtime = hdtime;
	}

	@Column(name = "qchdtime")
	public Integer getQchdtime() {
		return this.qchdtime;
	}

	public void setQchdtime(Integer qchdtime) {
		this.qchdtime = qchdtime;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@Column(name = "timetype")
	public Integer getTimetype() {
		return timetype;
	}

	public void setTimetype(Integer timetype) {
		this.timetype = timetype;
	}

	

}