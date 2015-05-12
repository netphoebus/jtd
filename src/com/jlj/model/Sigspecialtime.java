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
 * Sigspecialtime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sigspecialtime", schema = "dbo", catalog = "jtd")
public class Sigspecialtime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Signpublicparam signpublicparam;
	private Integer specialmonth;
	private Integer specialday;
	private Set<Commontime> commontimes = new HashSet<Commontime>(0);

	// Constructors

	/** default constructor */
	public Sigspecialtime() {
	}

	/** full constructor */
	public Sigspecialtime(Signpublicparam signpublicparam,
			Integer specialmonth, Integer specialday,
			Set<Commontime> commontimes) {
		this.signpublicparam = signpublicparam;
		this.specialmonth = specialmonth;
		this.specialday = specialday;
		this.commontimes = commontimes;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sigspecialtime")
	public Set<Commontime> getCommontimes() {
		return this.commontimes;
	}

	public void setCommontimes(Set<Commontime> commontimes) {
		this.commontimes = commontimes;
	}

}