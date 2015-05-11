package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPhaseDao;
import com.jlj.model.Phase;
import com.jlj.service.IPhaseService;


@Component("phaseService")
public class PhaseServiceImp implements IPhaseService  {
	private IPhaseDao phaseDao;
	public IPhaseDao getPhaseDao() {
		return phaseDao;
	}
	@Resource
	public void setPhaseDao(IPhaseDao phaseDao) {
		this.phaseDao = phaseDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#add(com.jlj.model.Phase)
	 */
	public void add(Phase phase) throws Exception {
		phaseDao.save(phase);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#delete(com.jlj.model.Phase)
	 */
	public void delete(Phase phase) {
		phaseDao.delete(phase);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#deleteById(int)
	 */
	public void deleteById(int id) {
		phaseDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#update(com.jlj.model.Phase)
	 */
	public void update(Phase phase) {
		phaseDao.update(phase);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#getPhases()
	 */
	public List<Phase> getPhases() {
		return phaseDao.getPhases();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#loadById(int)
	 */
	public Phase loadById(int id) {
		return phaseDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Phase mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return phaseDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#queryList(int, java.lang.String, int, int)
	 */
	public List<Phase> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Phase mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return phaseDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhaseService#loadByMkid(long)
	 */
	public Phase loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Phase mo where 1=1 and mo.mkid="+mkid;
		
		
		return phaseDao.loadByMkid(queryString);
	}
}
