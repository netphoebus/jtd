package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISigspecialtimeDao;
import com.jlj.model.Sigspecialtime;
import com.jlj.service.ISigspecialtimeService;


@Component("sigspecialtimeService")
public class SigspecialtimeServiceImp implements ISigspecialtimeService  {
	private ISigspecialtimeDao sigspecialtimeDao;
	public ISigspecialtimeDao getSigspecialtimeDao() {
		return sigspecialtimeDao;
	}
	@Resource
	public void setSigspecialtimeDao(ISigspecialtimeDao sigspecialtimeDao) {
		this.sigspecialtimeDao = sigspecialtimeDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#add(com.jlj.model.Sigspecialtime)
	 */
	public void add(Sigspecialtime sigspecialtime) throws Exception {
		sigspecialtimeDao.save(sigspecialtime);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#delete(com.jlj.model.Sigspecialtime)
	 */
	public void delete(Sigspecialtime sigspecialtime) {
		sigspecialtimeDao.delete(sigspecialtime);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#deleteById(int)
	 */
	public void deleteById(int id) {
		sigspecialtimeDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#update(com.jlj.model.Sigspecialtime)
	 */
	public void update(Sigspecialtime sigspecialtime) {
		sigspecialtimeDao.update(sigspecialtime);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#getSigspecialtimes()
	 */
	public List<Sigspecialtime> getSigspecialtimes() {
		return sigspecialtimeDao.getSigspecialtimes();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#loadById(int)
	 */
	public Sigspecialtime loadById(int id) {
		return sigspecialtimeDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Sigspecialtime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigspecialtimeDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#queryList(int, java.lang.String, int, int)
	 */
	public List<Sigspecialtime> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Sigspecialtime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigspecialtimeDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigspecialtimeService#loadByMkid(long)
	 */
	public Sigspecialtime loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Sigspecialtime mo where 1=1 and mo.mkid="+mkid;
		
		
		return sigspecialtimeDao.loadByMkid(queryString);
	}
	public void updateByOrderid(int month, int day, int orderid,
			Integer publicid) {
		String queryString = "update Sigspecialtime mo set mo.specialmonth=:month,mo.specialday=:day where mo.orderid = :orderid and mo.signpublicparam.id=:publicid ";
		String[] paramNames = new String[] {"month","day", "orderid","publicid" };
		Object[] values = new Object[] {month,day, orderid,publicid };
		sigspecialtimeDao.updateByHql(queryString, paramNames, values);
		
	}
}
