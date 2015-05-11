package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISignpublicparamDao;
import com.jlj.model.Signpublicparam;
import com.jlj.service.ISignpublicparamService;


@Component("signpublicparamService")
public class SignpublicparamServiceImp implements ISignpublicparamService  {
	private ISignpublicparamDao signpublicparamDao;
	public ISignpublicparamDao getSignpublicparamDao() {
		return signpublicparamDao;
	}
	@Resource
	public void setSignpublicparamDao(ISignpublicparamDao signpublicparamDao) {
		this.signpublicparamDao = signpublicparamDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#add(com.jlj.model.Signpublicparam)
	 */
	public void add(Signpublicparam signpublicparam) throws Exception {
		signpublicparamDao.save(signpublicparam);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#delete(com.jlj.model.Signpublicparam)
	 */
	public void delete(Signpublicparam signpublicparam) {
		signpublicparamDao.delete(signpublicparam);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#deleteById(int)
	 */
	public void deleteById(int id) {
		signpublicparamDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#update(com.jlj.model.Signpublicparam)
	 */
	public void update(Signpublicparam signpublicparam) {
		signpublicparamDao.update(signpublicparam);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getSignpublicparams()
	 */
	public List<Signpublicparam> getSignpublicparams() {
		return signpublicparamDao.getSignpublicparams();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#loadById(int)
	 */
	public Signpublicparam loadById(int id) {
		return signpublicparamDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Signpublicparam mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return signpublicparamDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#queryList(int, java.lang.String, int, int)
	 */
	public List<Signpublicparam> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Signpublicparam mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
//		queryString += " order by mo.id desc ";
		return signpublicparamDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISignpublicparamService#loadByMkid(long)
	 */
	public Signpublicparam loadByMkid(long mkid) {
		// TODO Auto-generated method stub
		
		String queryString = "from Signpublicparam mo where 1=1 and mo.mkid="+mkid;
		
		
		return signpublicparamDao.loadByMkid(queryString);
	}
}
