package com.lx.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSession {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
//		return  sessionFactory.openSession();
		return  sessionFactory.getCurrentSession();
	}
}
