package com.jlj.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jlj.dao.ISignalDao;
import com.jlj.model.Signal;


@Component("signalDao")
public class SignalDaoImp implements ISignalDao {
	
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Signal signal) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(signal);
	}

	public List<Signal> list() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Signal.class);
	}
	
	
	

}
