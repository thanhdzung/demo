package com.sysmex.hr.model;

public class Employee {
	private int id;
	private String name;
	private String company;
	private String replica;

	public Employee() {
	};

	public Employee(int id, String name, String company, String replica) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.replica = replica;
	}

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getReplica() {
		return replica;
	}

	public void setReplica(String replica) {
		this.replica = replica;
	}

}
