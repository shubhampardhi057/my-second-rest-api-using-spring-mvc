package com.prowings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Student {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	int roll;
	
	@Column
	String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn
	@Autowired
	List<Subjects> subjects;
	

	public Student() {
		super();
	}
	
	
	public Student(int id, int roll, String name, List<Subjects> subjects) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.subjects = subjects;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	
	

}
