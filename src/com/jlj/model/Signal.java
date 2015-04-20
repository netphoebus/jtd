package com.jlj.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Signal entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "signal", catalog = "jtd")
public class Signal implements java.io.Serializable {

	// Fields

	private Integer id;
	private List<Marker> markers = new ArrayList<Marker>();

	// Constructors

	/** default constructor */
	public Signal() {
	}

	/** full constructor */
	public Signal(List<Marker> markers) {
		this.markers = markers;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "signal")
	public List<Marker> getMarkers() {
		return this.markers;
	}

	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

}