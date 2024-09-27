package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "cse_students")
@Entity
public class StudentEntity {
	
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String branch;
	@Column
	private String college;
	@Column
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", branch=" + branch + ", college=" + college + ", city="
				+ city + "]";
	}
}
