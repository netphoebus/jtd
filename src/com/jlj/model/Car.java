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
 * Car entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car", catalog = "s2sh")
public class Car implements java.io.Serializable {

	// Fields

	private Integer id;
	private Client client;
	private String carname;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** full constructor */
	public Car(Client client, String carname) {
		this.client = client;
		this.carname = carname;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "carname", length = 50)
	public String getCarname() {
		return this.carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

}