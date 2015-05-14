package com.jlj.service;

import java.util.List;

import com.jlj.model.Phase;

public interface IPhaseService {

	//添加对象
	public abstract void add(Phase phase) throws Exception;

	//删除对象
	public abstract void delete(Phase phase);

	//删除某个id的对象
	public abstract void deleteById(int id);

	//修改对象
	public abstract void update(Phase phase);

	//获取所有对象
	public abstract List<Phase> getPhases();

	//加载一个id的对象
	public abstract Phase loadById(int id);

	//后台管理-页数获取
	public abstract int getPageCount(int con, String convalue, int size);

	//后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue);

	//后台管理-获取符合条件的记录
	public abstract List<Phase> queryList(int con, String convalue, int page,
			int size);

	public abstract Phase loadByMkid(long mkid);

	public abstract List<Phase> loadBySoId(int soid);

}