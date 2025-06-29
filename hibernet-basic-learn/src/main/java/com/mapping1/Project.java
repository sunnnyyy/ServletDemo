package com.mapping1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(mappedBy = "projects")
	private List<Employe> employe;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int id, String name, List<Employe> employe) {
		super();
		this.id = id;
		this.name = name;
		this.employe = employe;
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

	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}

}
