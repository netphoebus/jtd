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
 * House entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house", catalog = "s2sh")
public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private Client client;
	private String houseaddr;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(Client client, String houseaddr) {
		this.client = client;
		this.houseaddr = houseaddr;
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

	@Column(name = "houseaddr")
	public String getHouseaddr() {
		return this.houseaddr;
	}

	public void setHouseaddr(String houseaddr) {
		this.houseaddr = houseaddr;
	}

}