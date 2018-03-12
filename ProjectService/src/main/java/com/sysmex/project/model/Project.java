package com.sysmex.project.model;

public class Project {
	private int id;
	private String Name;
	private String replica;
	
	public Project() {};
	
	public Project (int id, String name, String replica) {
		this.id = id;
		this.Name = name;
		this.replica = replica;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getReplica() {
		return replica;
	}
	public void setReplica(String replica) {
		this.replica = replica;
	}
	
	
}
