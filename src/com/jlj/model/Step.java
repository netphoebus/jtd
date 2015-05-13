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
 * Step entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "step", schema = "dbo", catalog = "jtd")
public class Step implements java.io.Serializable {

	// Fields

	private Integer id;
	private Phase phase;
	private String stepname;
	private Integer second;
	private Integer orderid;
	private Set<Road> roads = new HashSet<Road>(0);

	// Constructors

	/** default constructor */
	public Step() {
	}

	/** full constructor */
	public Step(Phase phase, String stepname, Integer second, Integer orderid,
			Set<Road> roads) {
		this.phase = phase;
		this.stepname = stepname;
		this.second = second;
		this.orderid = orderid;
		this.roads = roads;
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
	@JoinColumn(name = "phaseid")
	public Phase getPhase() {
		return this.phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	@Column(name = "stepname", length = 30)
	public String getStepname() {
		return this.stepname;
	}

	public void setStepname(String stepname) {
		this.stepname = stepname;
	}

	@Column(name = "second")
	public Integer getSecond() {
		return this.second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "step")
	public Set<Road> getRoads() {
		return this.roads;
	}

	public void setRoads(Set<Road> roads) {
		this.roads = roads;
	}

}