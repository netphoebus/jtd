package com.jlj.service;

import java.util.List;

import com.jlj.model.Sigsuntime;

public interface ISigsuntimeService {

	//添加对象
	public abstract void add(Sigsuntime sigsuntime) throws Exception;

	//删除对象
	public abstract void delete(Sigsuntime sigsuntime);

	//删除某个id的对象
	public abstract void deleteById(int id);

	//修改对象
	public abstract void update(Sigsuntime sigsuntime);

	//获取所有对象
	public abstract List<Sigsuntime> getSigsuntimes();

	//加载一个id的对象
	public abstract Sigsuntime loadById(int id);

	//后台管理-页数获取
	public abstract int getPageCount(int con, String convalue, int size);

	//后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue);

	//后台管理-获取符合条件的记录
	public abstract List<Sigsuntime> queryList(int con, String convalue,
			int page, int size);

	public abstract Sigsuntime loadByMkid(long mkid);

	public abstract void updateWeekBysigsunid(String valueOf, Integer id);

	public abstract void updateByOrderid(String week, int orderid, Integer publicid);

}