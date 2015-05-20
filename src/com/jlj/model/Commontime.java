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
	private Sigordinarytime sigordinarytime;
	private Sigsuntime sigsuntime;
	private Sigspecialtime sigspecialtime;
	private Integer hour;
	private Integer minute;
	private Integer seconds;
	private Integer workingway;
	private Integer workingprogram;
	private Integer lstime;
	private Integer hdtime;
	private Integer qchdtime;
	private Solution solution;

	// Constructors

	/** default constructor */
	public Commontime() {
	}

	/** full constructor */
	public Commontime(Sigordinarytime sigordinarytime, Sigsuntime sigsuntime,
			Sigspecialtime sigspecialtime, Integer hour, Integer minute,
			Integer seconds, Integer workingway, Integer workingprogram,
			Integer lstime, Integer hdtime, Integer qchdtime,
			Solution solution) {
		this.sigordinarytime = sigordinarytime;
		this.sigsuntime = sigsuntime;
		this.sigspecialtime = sigspecialtime;
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.workingway = workingway;
		this.workingprogram = workingprogram;
		this.lstime = lstime;
		this.hdtime = hdtime;
		this.qchdtime = qchdtime;
		this.solution = solution;
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
	@JoinColumn(name = "ordinaryid")
	public Sigordinarytime getSigordinarytime() {
		return this.sigordinarytime;
	}

	public void setSigordinarytime(Sigordinarytime sigordinarytime) {
		this.sigordinarytime = sigordinarytime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sunid")
	public Sigsuntime getSigsuntime() {
		return this.sigsuntime;
	}

	public void setSigsuntime(Sigsuntime sigsuntime) {
		this.sigsuntime = sigsuntime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialid")
	public Sigspecialtime getSigspecialtime() {
		return this.sigspecialtime;
	}

	public void setSigspecialtime(Sigspecialtime sigspecialtime) {
		this.sigspecialtime = sigspecialtime;
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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commontime")
	public Solution getSolution() {
		return this.solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

}