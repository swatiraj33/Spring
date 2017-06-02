package com.naveen.rest.daoimpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.naveen.rest.dao.NameDAO;
import com.naveen.rest.model.Name;
@Repository("nameDao")
public class Namedaoimpl  implements NameDAO{

	//this get the instance created by the spring from IOC, the same id name should be used as declared in the spring.xml
	@Autowired
	private SessionFactory sessionFactory;
	
	Session session;
	
	Transaction trans;
	
	//create a session based on this
	public Session creatSession(){
		return sessionFactory.openSession();
	}

	@Override
	public int save(Name name) {
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
		session.save(name);
		//get that number
		int number = name.getNumber();		
		trans.commit();
		session.close();
		return number;
	}


	@Override
	public String delete(int id) {
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
		Object o = (Name)session.load(Name.class, id);		
		session.delete(o);
		trans.commit();	
		session.close();
		return "Employee deleted";
		
	}

	@Override
	public Name searchSpecific(int id) {
		
		session = creatSession();
		Criteria cc = session.createCriteria(Name.class);
		Criterion criterion = Restrictions.eq("num", id);
		cc.add(criterion);
		Object o = cc.uniqueResult();
		//lets try using criteria
		//Object o = session.get(Name.class, id);
		//= session.load(Name.class, id);
		Name name = (Name)o;
		return name; 
	}

	@Override
	public List<Name> displayAll() {		
		return (List<Name>)creatSession().createCriteria(Name.class).list();
	}

}
