package com.naveen.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="names")
public class Name implements Serializable {

	private static final long serialVersionUID = 2048009549150843794L;
	@Id
	@GeneratedValue
	int num;
	String firstName;
	String LastName;
	String middleName;
	
	
	public int getNumber() {
		return num;
	}

	public void setNumber(int number) {
		this.num = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
    	
	public Name() {
		super();
	}

	public Name(int number, String firstName, String lastName, String middleName) {
		super();
		this.num = number;
		this.firstName = firstName;
		LastName = lastName;
		this.middleName = middleName;
	}

}
