package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISigordinarytimeDao;
import com.jlj.model.Sigordinarytime;
import com.jlj.service.ISigordinarytimeService;


@Component("sigordinarytimeService")
public class SigordinarytimeServiceImp implements ISigordinarytimeService  {
	private ISigordinarytimeDao sigordinarytimeDao;
	public ISigordinarytimeDao getSigordinarytimeDao() {
		return sigordinarytimeDao;
	}
	@Resource
	public void setSigordinarytimeDao(ISigordinarytimeDao sigordinarytimeDao) {
		this.sigordinarytimeDao = sigordinarytimeDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#add(com.jlj.model.Sigordinarytime)
	 */
	public void add(Sigordinarytime sigordinarytime) throws Exception {
		sigordinarytimeDao.save(sigordinarytime);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#delete(com.jlj.model.Sigordinarytime)
	 */
	public void delete(Sigordinarytime sigordinarytime) {
		sigordinarytimeDao.delete(sigordinarytime);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#deleteById(int)
	 */
	public void deleteById(int id) {
		sigordinarytimeDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#update(com.jlj.model.Sigordinarytime)
	 */
	public void update(Sigordinarytime sigordinarytime) {
		sigordinarytimeDao.update(sigordinarytime);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#getSigordinarytimes()
	 */
	public List<Sigordinarytime> getSigordinarytimes() {
		return sigordinarytimeDao.getSigordinarytimes();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#loadById(int)
	 */
	public Sigordinarytime loadById(int id) {
		return sigordinarytimeDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Sigordinarytime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigordinarytimeDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#queryList(int, java.lang.String, int, int)
	 */
	public List<Sigordinarytime> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Sigordinarytime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigordinarytimeDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigordinarytimeService#loadByMkid(long)
	 */
	public Sigordinarytime loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Sigordinarytime mo where 1=1 and mo.mkid="+mkid;
		
		
		return sigordinarytimeDao.loadByMkid(queryString);
	}
}
