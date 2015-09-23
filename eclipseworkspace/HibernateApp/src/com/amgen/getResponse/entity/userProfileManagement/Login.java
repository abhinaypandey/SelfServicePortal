package com.amgen.getResponse.entity.userProfileManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_Login")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="AUTO")
	@SequenceGenerator(name="AUTO", sequenceName="AUTO", allocationSize=1)
	@Column(name = "ID")
	private int id;
	
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	
	
}
