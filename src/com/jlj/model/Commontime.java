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
 * Commontime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commontime", schema = "dbo", catalog = "jtd")
public class Commontime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Signpublicparam signpublicparam;
	private Integer hour;
	private Integer minute;
	private Integer seconds;
	private Integer workingway;
	private Integer workingprogram;
	private Integer lstime;
	private Integer hdtime;
	private Integer qchdtime;
	private Integer timetype;
	private List<Sigspecialtime> sigspecialtimes = new ArrayList<Sigspecialtime>();
	private List<Sigordinarytime> sigordinarytimes = new ArrayList<Sigordinarytime>();
	private List<Sigsuntime> sigsuntimes = new ArrayList<Sigsuntime>();

	// Constructors

	/** default constructor */
	public Commontime() {
	}

	/** full constructor */
	public Commontime(Signpublicparam signpublicparam, Integer hour,
			Integer minute, Integer seconds, Integer workingway,
			Integer workingprogram, Integer lstime, Integer hdtime,
			Integer qchdtime, Integer timetype,
			List<Sigspecialtime> sigspecialtimes,
			List<Sigordinarytime> sigordinarytimes, List<Sigsuntime> sigsuntimes) {
		this.signpublicparam = signpublicparam;
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.workingway = workingway;
		this.workingprogram = workingprogram;
		this.lstime = lstime;
		this.hdtime = hdtime;
		this.qchdtime = qchdtime;
		this.timetype = timetype;
		this.sigspecialtimes = sigspecialtimes;
		this.sigordinarytimes = sigordinarytimes;
		this.sigsuntimes = sigsuntimes;
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

	@Column(name = "timetype")
	public Integer getTimetype() {
		return this.timetype;
	}

	public void setTimetype(Integer timetype) {
		this.timetype = timetype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commontime")
	public List<Sigspecialtime> getSigspecialtimes() {
		return this.sigspecialtimes;
	}

	public void setSigspecialtimes(List<Sigspecialtime> sigspecialtimes) {
		this.sigspecialtimes = sigspecialtimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commontime")
	public List<Sigordinarytime> getSigordinarytimes() {
		return this.sigordinarytimes;
	}

	public void setSigordinarytimes(List<Sigordinarytime> sigordinarytimes) {
		this.sigordinarytimes = sigordinarytimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commontime")
	public List<Sigsuntime> getSigsuntimes() {
		return this.sigsuntimes;
	}

	public void setSigsuntimes(List<Sigsuntime> sigsuntimes) {
		this.sigsuntimes = sigsuntimes;
	}

}