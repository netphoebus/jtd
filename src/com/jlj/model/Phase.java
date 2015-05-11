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
	private Sig sig;
	private String phasename;
	private Set<Step> steps = new HashSet<Step>(0);

	// Constructors

	/** default constructor */
	public Phase() {
	}

	/** full constructor */
	public Phase(Sig sig, String phasename, Set<Step> steps) {
		this.sig = sig;
		this.phasename = phasename;
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
	@JoinColumn(name = "signid")
	public Sig getSig() {
		return this.sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	@Column(name = "phasename", length = 30)
	public String getPhasename() {
		return this.phasename;
	}

	public void setPhasename(String phasename) {
		this.phasename = phasename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phase")
	public Set<Step> getSteps() {
		return this.steps;
	}

	public void setSteps(Set<Step> steps) {
		this.steps = steps;
	}

}