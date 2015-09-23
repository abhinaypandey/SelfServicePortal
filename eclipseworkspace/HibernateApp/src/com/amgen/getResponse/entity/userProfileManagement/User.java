package com.amgen.getResponse.entity.userProfileManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.amgen.getResponse.entity.campaign.Campaign;


@Entity
@Table(name="user")

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_AUTO")
	@SequenceGenerator(name="USER_AUTO", sequenceName="USER_AUTO", allocationSize=1)
	@Column(name = "USER_ID")
	private int id;

	@Column(name="First_Name")
	private String firstName;

	@Column(name="Last_Name")
	private String lastName;

	@Column(name="EMAIL")
	private String email;

	@Column(name="PHONE")
	private int phone;

	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Fax")
	private int fax;

//
//	@OneToMany(mappedBy= "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Collection<Campaign> campaign = new ArrayList<Campaign>();


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, String email,
			int phone, String userName, String password, String address,
			int fax) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.fax = fax;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	
	public void store() {
		// TODO Auto-generated method stub

	}


}
