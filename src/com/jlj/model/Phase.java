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
 * Phase entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "phase", schema = "dbo", catalog = "jtd")
public class Phase implements java.io.Serializable {

	// Fields

	private Integer id;
	private Solution solution;
	private String phasename;
	private Integer orderid;
	private Set<Step> steps = new HashSet<Step>(0);

	// Constructors

	/** default constructor */
	public Phase() {
	}

	/** full constructor */
	public Phase(Solution solution, String phasename, Integer orderid,
			Set<Step> steps) {
		this.solution = solution;
		this.phasename = phasename;
		this.orderid = orderid;
		this.steps = steps;
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
	@JoinColumn(name = "soluid")
	public Solution getSolution() {
		return this.solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	@Column(name = "phasename", length = 30)
	public String getPhasename() {
		return this.phasename;
	}

	public void setPhasename(String phasename) {
		this.phasename = phasename;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phase")
	public Set<Step> getSteps() {
		return this.steps;
	}

	public void setSteps(Set<Step> steps) {
		this.steps = steps;
	}

}