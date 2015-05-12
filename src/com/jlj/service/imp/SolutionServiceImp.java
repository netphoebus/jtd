package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISolutionDao;
import com.jlj.model.Solution;


@Component("solutionService")
public class SolutionServiceImp  {
	private ISolutionDao solutionDao;
	public ISolutionDao getSolutionDao() {
		return solutionDao;
	}
	@Resource
	public void setSolutionDao(ISolutionDao solutionDao) {
		this.solutionDao = solutionDao;
	}
	//添加对象
	public void add(Solution solution) throws Exception {
		solutionDao.save(solution);
	}
	//删除对象
	public void delete(Solution solution) {
		solutionDao.delete(solution);
	}
	//删除某个id的对象
	public void deleteById(int id) {
		solutionDao.deleteById(id);
	}
	//修改对象
	public void update(Solution solution) {
		solutionDao.update(solution);
	}
	//获取所有对象
	public List<Solution> getSolutions() {
		return solutionDao.getSolutions();
	}
	//加载一个id的对象
	public Solution loadById(int id) {
		return solutionDao.loadById(id);
	}
	//后台管理-页数获取
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Solution mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return solutionDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	public List<Solution> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Solution mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return solutionDao.pageList(queryString,p,page,size);
	}
	public Solution loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Solution mo where 1=1 and mo.mkid="+mkid;
		
		
		return solutionDao.loadByMkid(queryString);
	}
}
