package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IUserDao;
import com.jlj.model.User;
import com.jlj.service.IUserService;


@Component("userService")
public class UserServiceImp implements IUserService  {
	private IUserDao userDao;
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#add(com.jlj.model.User)
	 */
	public void add(User user) throws Exception {
		userDao.save(user);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#delete(com.jlj.model.User)
	 */
	public void delete(User user) {
		userDao.delete(user);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#deleteById(int)
	 */
	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#update(com.jlj.model.User)
	 */
	public void update(User user) {
		userDao.update(user);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#getUsers()
	 */
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#loadById(int)
	 */
	public User loadById(int id) {
		return userDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from User mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return userDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IUserService#queryList(int, java.lang.String, int, int)
	 */
	public List<User> queryList(int con, String convalue, int page, int size) {
		String queryString = "from User mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return userDao.pageList(queryString,p,page,size);
	}
	
}
