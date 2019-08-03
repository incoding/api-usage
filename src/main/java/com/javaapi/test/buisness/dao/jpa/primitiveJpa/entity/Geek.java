package com.javaapi.test.buisness.dao.jpa.primitiveJpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_GEEK")
@Access(AccessType.PROPERTY)
public class Geek extends Person {
	private String favouriteProgrammingLanguage;
	private List<Project> projects = new ArrayList<Project>();

	@Column(name = "FAV_PROG_LANG")
	public String getFavouriteProgrammingLanguage() {
			return favouriteProgrammingLanguage;
	}

	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
	}

	@ManyToMany(mappedBy="geeks")
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
