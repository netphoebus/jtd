package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISigsuntimeDao;
import com.jlj.model.Sigsuntime;
import com.jlj.service.ISigsuntimeService;


@Component("sigsuntimeService")
public class SigsuntimeServiceImp implements ISigsuntimeService {
	private ISigsuntimeDao sigsuntimeDao;
	public ISigsuntimeDao getSigsuntimeDao() {
		return sigsuntimeDao;
	}
	@Resource
	public void setSigsuntimeDao(ISigsuntimeDao sigsuntimeDao) {
		this.sigsuntimeDao = sigsuntimeDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#add(com.jlj.model.Sigsuntime)
	 */
	public void add(Sigsuntime sigsuntime) throws Exception {
		sigsuntimeDao.save(sigsuntime);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#delete(com.jlj.model.Sigsuntime)
	 */
	public void delete(Sigsuntime sigsuntime) {
		sigsuntimeDao.delete(sigsuntime);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#deleteById(int)
	 */
	public void deleteById(int id) {
		sigsuntimeDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#update(com.jlj.model.Sigsuntime)
	 */
	public void update(Sigsuntime sigsuntime) {
		sigsuntimeDao.update(sigsuntime);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#getSigsuntimes()
	 */
	public List<Sigsuntime> getSigsuntimes() {
		return sigsuntimeDao.getSigsuntimes();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#loadById(int)
	 */
	public Sigsuntime loadById(int id) {
		return sigsuntimeDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Sigsuntime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigsuntimeDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#queryList(int, java.lang.String, int, int)
	 */
	public List<Sigsuntime> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Sigsuntime mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return sigsuntimeDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISigsuntimeService#loadByMkid(long)
	 */
	public Sigsuntime loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Sigsuntime mo where 1=1 and mo.mkid="+mkid;
		
		
		return sigsuntimeDao.loadByMkid(queryString);
	}
	public void updateWeekBysigsunid(String week, Integer sigsunid) {
		String queryString = "update Sigsuntime mo set mo.week=:week where mo.id = :sigsunid";
		String[] paramNames = new String[] {"week", "sigsunid" };
		Object[] values = new Object[] {week, sigsunid };
		sigsuntimeDao.updateByHql(queryString, paramNames, values);
	}
}
