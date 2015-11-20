package pl.spring.demo.entity;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class PersonalData implements Serializable {

	@Column(nullable = false, length = 50)
private String name;
	
	@Column(nullable = false, length = 50)
private String surname;
	
	private static final long serialVersionUID = 2893395147965706648L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}



}
