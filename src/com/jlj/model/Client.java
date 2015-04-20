package com.jlj.model;

import java.util.HashSet;
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
 * Client entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "client", catalog = "s2sh")
public class Client implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Integer limits;
	private Set<House> houses = new HashSet<House>(0);
	private Set<Car> cars = new HashSet<Car>(0);

	// Constructors

	/** default constructor */
	public Client() {
	}

	/** full constructor */
	public Client(String username, String password, Integer limits,
			Set<House> houses, Set<Car> cars) {
		this.username = username;
		this.password = password;
		this.limits = limits;
		this.houses = houses;
		this.cars = cars;
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

	@Column(name = "username", length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "limits")
	public Integer getLimits() {
		return this.limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}