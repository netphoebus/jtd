package com.jlj.dao;

import java.util.List;

import com.jlj.model.Sig;

public interface ISigDao {

	void save(Sig signal);

	List<Sig> list();

	

}
