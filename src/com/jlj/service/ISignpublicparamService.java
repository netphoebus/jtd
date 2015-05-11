package com.jlj.service;

import java.util.List;

import com.jlj.model.Signpublicparam;

public interface ISignpublicparamService {

	//添加对象
	public abstract void add(Signpublicparam signpublicparam) throws Exception;

	//删除对象
	public abstract void delete(Signpublicparam signpublicparam);

	//删除某个id的对象
	public abstract void deleteById(int id);

	//修改对象
	public abstract void update(Signpublicparam signpublicparam);

	//获取所有对象
	public abstract List<Signpublicparam> getSignpublicparams();

	//加载一个id的对象
	public abstract Signpublicparam loadById(int id);

	//后台管理-页数获取
	public abstract int getPageCount(int con, String convalue, int size);

	//后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue);

	//后台管理-获取符合条件的记录
	public abstract List<Signpublicparam> queryList(int con, String convalue,
			int page, int size);

	public abstract Signpublicparam loadByMkid(long mkid);

}