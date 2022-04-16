package com.tafa.GameShop.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	private int phone;

	private String email;

	private String password;

	private String address;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;

	private String gamelist;

	private String wishlist;

	private String cart;

	public User() {

	}

	public User(String name, int phone, String email, String password, String address,
			Collection<Role> roles, String gamelist, String wishlist) {
		super();

		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.roles = roles;
		this.gamelist = gamelist;
		this.wishlist = wishlist;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public List<Long> getGamelist() {
		List<Long> lstVals = new ArrayList<Long>();
		Long val = 0L;
		if (this.gamelist == null || this.gamelist.isBlank() || this.gamelist.isEmpty()) {
			return lstVals;
		}
		for (String field : this.gamelist.split(",")) {
			try {
				val = Long.parseLong(field);
			}
			// If the String contains other thing that digits and commas
			catch (NumberFormatException e) {
			}
			lstVals.add(val);
		}

		return lstVals;
	}

	public void setGamelist(List<Long> vals) {
		String newVals = "";
		for (Long i : vals) {
			if (newVals == "") {
				newVals += Long.toString(i);
			} else {
				newVals = newVals + "," + Long.toString(i);
			}
		}
		this.gamelist = newVals;
	}

	public List<Long> getWishlist() {
		List<Long> lstVals = new ArrayList<Long>();
		Long val = 0L;
		if (this.wishlist == null || this.wishlist.isBlank() || this.wishlist.isEmpty()) {
			return lstVals;
		}
		for (String field : this.wishlist.split(",")) {
			try {
				val = Long.parseLong(field);
			}
			// If the String contains other thing that digits and commas
			catch (NumberFormatException e) {
			}
			lstVals.add(val);
		}

		return lstVals;
	}

	public void setWishlist(List<Long> vals) {
		String newVals = "";
		for (Long i : vals) {
			if (newVals == "") {
				newVals += Long.toString(i);
			} else {
				newVals = newVals + "," + Long.toString(i);
			}
		}
		this.wishlist = newVals;
	}

	public List<Long> getCart() {
		List<Long> lstVals = new ArrayList<Long>();
		Long val = 0L;
		if (this.cart == null || this.cart.isBlank() || this.cart.isEmpty()) {
			return lstVals;
		}
		for (String field : this.cart.split(",")) {
			try {
				val = Long.parseLong(field);
			}
			// If the String contains other thing that digits and commas
			catch (NumberFormatException e) {
			}
			lstVals.add(val);
		}

		return lstVals;
	}

	public void setCart(List<Long> vals) {
		String newVals = "";
		for (Long i : vals) {
			if (newVals == "") {
				newVals += Long.toString(i);
			} else {
				newVals = newVals + "," + Long.toString(i);
			}
		}
		this.cart = newVals;
	}
}
