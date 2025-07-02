package com.mapping1;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

//	@ManyToMany(fetch = FetchType.EAGER)
	@ManyToMany //by default it is lazy loading
	@JoinTable(name = "emp_project", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "proj_id") })
	private List<Project> projects;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(int id, String name, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.projects = projects;
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

	public List<Project> getProject() {
		return projects;
	}

	public void setProject(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + "]";
	}
	

	
}
