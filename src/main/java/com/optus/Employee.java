package com.optus;

import java.util.*;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	
	public Employee(){}
	public Employee(int id,String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	 public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}
