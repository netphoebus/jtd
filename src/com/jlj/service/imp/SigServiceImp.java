package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISigDao;
import com.jlj.model.Sig;
import com.jlj.service.ISigService;


@Component("signalService")
public class SigServiceImp implements ISigService {
	
	private ISigDao signalDao;

	public ISigDao getSignalDao() {
		return signalDao;
	}
	@Resource
	public void setSignalDao(ISigDao signalDao) {
		this.signalDao = signalDao;
	}
	public void save(Sig signal) {
		// TODO Auto-generated method stub
		signalDao.save(signal);
	}
	public List<Sig> list() {
		// TODO Auto-generated method stub
		return signalDao.list();
	}


}
