package com.jlj.dao;

import java.util.List;

import com.jlj.model.Marker;
import com.jlj.model.Signal;

public interface ISignalDao {

	void save(Signal signal);

	List<Signal> list();

	

}
