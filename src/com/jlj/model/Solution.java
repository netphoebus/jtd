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
 * Solution entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "solution", schema = "dbo", catalog = "jtd")
public class Solution implements java.io.Serializable {

	// Fields

	private Integer id;
	private Commontime commontime;
	private String soluname;
	private Set<Phase> phases = new HashSet<Phase>(0);

	// Constructors

	/** default constructor */
	public Solution() {
	}

	/** full constructor */
	public Solution(Commontime commontime, String soluname, Set<Phase> phases) {
		this.commontime = commontime;
		this.soluname = soluname;
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
	@JoinColumn(name = "commontimeid")
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "solution")
	public Set<Phase> getPhases() {
		return this.phases;
	}

	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}

}