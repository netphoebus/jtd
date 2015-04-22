package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISigDao;
import com.jlj.model.Sig;
import com.jlj.service.ISigService;


@Component("sigService")
public class SigServiceImp implements ISigService  {
	private ISigDao sigDao;
	public ISigDao getSigDao() {
		return sigDao;
	}
	@Resource
	public void setSigDao(ISigDao sigDao) {
		this.sigDao = sigDao;
	}
	//添加对象
	public void add(Sig sig) throws Exception {
		sigDao.save(sig);
	}
	//删除对象
	public void delete(Sig sig) {
		sigDao.delete(sig);
	}
	//删除某个id的对象
	public void deleteById(int id) {
		sigDao.deleteById(id);
	}
	//修改对象
	public void update(Sig sig) {
		sigDao.update(sig);
	}
	//获取所有对象
	public List<Sig> getSigs() {
		return sigDao.getSigs();
	}
	//加载一个id的对象
	public Sig loadById(int id) {
		return sigDao.loadById(id);
	}
	//后台管理-页数获取
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Sig mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return sigDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	public List<Sig> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Sig mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return sigDao.pageList(queryString,p,page,size);
	}
	
}
