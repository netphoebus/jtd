package com.jlj.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import sun.misc.Signal;

import com.jlj.dao.ISigDao;
import com.jlj.model.Sig;


@Component("sigDao")
public class SigDaoImp implements ISigDao {
	
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Sig signal) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(signal);
	}

	public List<Sig> list() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Signal.class);
	}
	
	
	

}
