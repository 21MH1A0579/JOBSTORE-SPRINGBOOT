package com.example.demo.Models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdata")
public class UserData {
	
	@Id
	@GeneratedValue(generator = "custom-id-generator")
	@GenericGenerator(
	    name = "custom-id-generator",
	    strategy = "com.example.demo.IdGenerators.UserIdGenerator")
	private String id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String email;
	@Column
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserData(String id, String name, String password, String role, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
