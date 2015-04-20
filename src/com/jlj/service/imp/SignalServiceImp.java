package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISignalDao;
import com.jlj.model.Marker;
import com.jlj.model.Signal;
import com.jlj.service.ISignalService;


@Component("signalService")
public class SignalServiceImp implements ISignalService {
	
	private ISignalDao signalDao;

	public ISignalDao getSignalDao() {
		return signalDao;
	}
	@Resource
	public void setSignalDao(ISignalDao signalDao) {
		this.signalDao = signalDao;
	}
	public void save(Signal signal) {
		// TODO Auto-generated method stub
		signalDao.save(signal);
	}
	public List<Signal> list() {
		// TODO Auto-generated method stub
		return signalDao.list();
	}


}
