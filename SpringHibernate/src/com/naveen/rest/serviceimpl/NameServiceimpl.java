package com.naveen.rest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naveen.rest.dao.NameDAO;
import com.naveen.rest.model.Name;
import com.naveen.rest.service.NameService;

//this acts as service 
@Service("nameservice")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor= Exception.class)
public class NameServiceimpl implements NameService {

	//here the reference name should be same as the name given in the @repository annotation in dao implementation class
	@Autowired
	NameDAO nameDao;
	
	@Override
	public int save(Name name) {
	return	nameDao.save(name);		
	}

	@Override
	public String delete(int id) {
		return nameDao.delete(id);		
	}

	@Override
	public Name searchSpecific(int id) {
		return nameDao.searchSpecific(id);		
	}

	@Override
	public List displayAll() {
		return nameDao.displayAll();
	}

}
