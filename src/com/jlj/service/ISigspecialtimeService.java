package com.jlj.service;

import java.util.List;

import com.jlj.model.Sigspecialtime;

public interface ISigspecialtimeService {

	//添加对象
	public abstract void add(Sigspecialtime sigspecialtime) throws Exception;

	//删除对象
	public abstract void delete(Sigspecialtime sigspecialtime);

	//删除某个id的对象
	public abstract void deleteById(int id);

	//修改对象
	public abstract void update(Sigspecialtime sigspecialtime);

	//获取所有对象
	public abstract List<Sigspecialtime> getSigspecialtimes();

	//加载一个id的对象
	public abstract Sigspecialtime loadById(int id);

	//后台管理-页数获取
	public abstract int getPageCount(int con, String convalue, int size);

	//后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue);

	//后台管理-获取符合条件的记录
	public abstract List<Sigspecialtime> queryList(int con, String convalue,
			int page, int size);

	public abstract Sigspecialtime loadByMkid(long mkid);

}