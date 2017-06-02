package com.naveen.rest.dao;

import java.util.List;

import com.naveen.rest.model.Name;

public interface NameDAO {

	//for saving a record
	public int save(Name name);
	//for deleting a record
	public String delete(int id);
	//for searching a specific  record
	public Name searchSpecific(int id);
	//for  searching all records
	public List displayAll();
}
