package com.jlj.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jlj.dao.IClientDao;
import com.jlj.model.Client;
import com.jlj.service.IClientService;
import com.jlj.util.ToolkitUtil;
//@Component("clientService")
@Path("/clientservice")
public class ClientServiceImp implements IClientService {
	private IClientDao clientDao;
	public IClientDao getClientDao() {
		return clientDao;
	}
	@Resource
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#add(com.jlj.model.Client)
	 */
	public void add(Client client) throws Exception {
		clientDao.save(client);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#delete(com.jlj.model.Client)
	 */
	public void delete(Client client) {
		clientDao.delete(client);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#deleteById(int)
	 */
	public void deleteById(int id) {
		clientDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#update(com.jlj.model.Client)
	 */
	public void update(Client client) {
		clientDao.update(client);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getClients()
	 */
	public List<Client> getClients() {
		return clientDao.getClients();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#loadById(int)
	 */
	public Client loadById(int id) {
		return clientDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
//		String queryString = "select count(*) from Client mo where mo.publicaccount=? ";
		String queryString = "select count(*) from Client mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
//			p = new Object[]{publicaccount,'%'+convalue+'%'};
			p = new Object[]{'%'+convalue+'%'};
		}else{
//			p = new Object[]{publicaccount};
		}
		return clientDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Client> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
//		String queryString = "from Client mo where mo.publicaccount=? ";
		String queryString = "from Client mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
//			p = new Object[]{publicaccount,'%'+convalue+'%'};
			p = new Object[]{'%'+convalue+'%'};
		}else{
//			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id asc ";
		return clientDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getClientsByPublicAccount(java.lang.String)
	 */
	public List<Client> getClientsByPublicAccount(String paccount) {
		String queryString = "from Client mo where mo.publicaccount = ? order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return clientDao.getObjectsByCondition(queryString, p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getFrontPageCount(int, int)
	 */
	public int getFrontPageCount(int catid, int size) {
		int totalCount=this.getFrontTotalCount(catid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getFrontTotalCount(int)
	 */
	public int getFrontTotalCount(int catid) {
		String queryString = "select count(*) from Client mo where mo.catid=? ";
		Object[] p = new Object[]{catid};
		return clientDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#queryFrontList(int, int, int)
	 */
	@GET
	@Path("/list/{catid}/{page}/{size}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Client> queryFrontList(@PathParam("catid") int catid,
			@PathParam("page") int page,@PathParam("size") int size) {
		String queryString = "from Client mo where mo.catid=? order by mo.aid asc";
		Object[] p = new Object[]{catid};
		return clientDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#userLogin(java.lang.String, java.lang.String)
	 */
	@GET
	@Path("/userlogin/{username}/{password}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Client> userLogin(@PathParam("username") String username,@PathParam("password") String password){
		//用来装ttmembers的list
		List<Client> ttmembers=new ArrayList<Client>();
		//1-查询该username的salt字段
		String salt="";
		String queryString2="from Client mo where mo.username=:username ";
		String[] paramNames2=new String[]{"username"};
		Object[] values2=new Object[]{username};
		Client loginer2=clientDao.queryByNamedParam(queryString2, paramNames2, values2);
		if(loginer2!=null){
//			salt = loginer2.getSalt();
		}else{
			return ttmembers;
		}
		//2-密码通过MD5二次加密匹配，若查询得到该用户名和密码，list装一个对象；若查不到，跳过。
		String queryString="from Client mo where mo.username=:username and mo.password=:password";
		String newpassword=ToolkitUtil.generatePassword(ToolkitUtil.generatePassword(password)+salt);  
		String[] paramNames=new String[]{"username","password"};
		Object[] values=new Object[]{username,newpassword};
		Client loginer=clientDao.queryByNamedParam(queryString, paramNames, values);
		if(loginer!=null){
			ttmembers.add(loginer);
		}
		return ttmembers;
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#updatePwd(java.lang.String, java.lang.String, java.lang.String)
	 */
	@GET
	@Path("/updatepwd/{username}/{oldpwd}/{newpwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public int updatePwd(@PathParam("username") String username,@PathParam("oldpwd") String oldpwd,@PathParam("newpwd") String newpwd){
		int isup = 0;
		//1-检查该用户是否存在：若不存在，返回-1;若存在，获取salt，并把用户输入的旧密码与数据库密码匹配
		String queryString2="from Client mo where mo.username=:username ";
		String[] paramNames2=new String[]{"username"};
		Object[] values2=new Object[]{username};
		Client ttMember=clientDao.queryByNamedParam(queryString2, paramNames2, values2);
		String salt= "";
		if(ttMember==null){
			return -1;
		}else{
//			salt = ttMember.getSalt();
		}
		//包装旧密码
		String oldpwdmd5=ToolkitUtil.generatePassword(ToolkitUtil.generatePassword(oldpwd)+salt);
		//2-旧密码与数据库密码匹配:匹配不上，返回-1；匹配成功，重新包装（二次加密和salt）新密码，修改数据
		String queryString="update Client mo set mo.password=? where mo.username=? and mo.password=?";
		//包装新密码
		String newpwdmd5=ToolkitUtil.generatePassword(ToolkitUtil.generatePassword(newpwd)+salt);
		Object[] p=new Object[]{newpwdmd5,username,oldpwdmd5};
		isup=clientDao.updatePwdByhql(queryString,p);//影响行数，0或1
		return isup;
		
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#addMember(java.lang.String, java.lang.String, java.lang.String)
	 */
	@GET
	@Path("/register/{username}/{password}/{limits}")
	@Produces(MediaType.APPLICATION_JSON)
	public int addMember(@PathParam("username") String username,@PathParam("password") String password,@PathParam("limits") String limits){
		int result=0;
		//1-判断是否该用户名已注册，已注册返回-1;注册成功返回大于0的整数;注册失败返回0;
		String queryString="from Client mo where mo.username=:username ";
		String[] paramNames=new String[]{"username"};
		Object[] values=new Object[]{username};
		Client loginer=clientDao.queryByNamedParam(queryString, paramNames, values);
		if(loginer!=null){
			return -1;
		}else{
			//md5二次加密密码
			//2-生成salt随机码6位字符串
			String salt=ToolkitUtil.getRandomNum(6);
			//3-生成md5二次加密之后的新密码
			String md5pwd=ToolkitUtil.generatePassword(ToolkitUtil.generatePassword(password)+salt);
			Client client = new Client();//(int)new Date().getTime()
			try {
				result = clientDao.savereturn(client);

			} catch (Exception e) {
				e.printStackTrace();
				result=0;
			}
			return result;
		}
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#getApkVersion()
	 */
	@GET
	@Path("/apkversion")
	@Produces(MediaType.APPLICATION_JSON)
	public String getApkVersion(){
		//1-判断是否该用户名已注册，已注册返回-1;注册成功返回大于0的整数;注册失败返回0;
		String queryString="from TtSettings mo where mo.k=:appversion ";
		String[] paramNames=new String[]{"appversion"};
		Object[] values=new Object[]{"appversion"};
//		TtSettings ttsettings=ttSettingsDao.queryByNamedParam(queryString, paramNames, values);
//		if(ttsettings!=null){
//			return ttsettings.getV();
//		}else{
//			return "no";
//		}
		return "no";
		
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IClientService#checkcardnum(java.lang.String, java.lang.String, int)
	 */
	@GET
	@Path("/checkcardnum/{cardnum}/{realname}/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public int checkcardnum(@PathParam("cardnum") String cardnum,@PathParam("realname") String realname,@PathParam("uid") int uid){
		int result=0;
//		String queryString="from Client mo where mo.cardnum=:cardnum ";
//		String[] paramNames=new String[]{"cardnum"};
//		Object[] values=new Object[]{cardnum};
//		Client loginer=clientDao.queryByNamedParam(queryString, paramNames, values);
//		if(loginer!=null){
//			result=1;
//		}else{
//			result=0;//卡号不存在:数据尚未同步或已与别的用户名绑定，请与管理员联系
//		}
//		String queryString2="from HhwCommonMemberProfile mo where mo.realname=:realname and mo.uid=:uid";
//		String[] paramNames2=new String[]{"realname","uid"};
//		Object[] values2=new Object[]{realname,uid};
//		HhwCommonMemberProfile member=hhwCommonMemberProfileDao.queryByNamedParam(queryString2, paramNames2, values2);
//		if(member!=null){
//			result = 1;
//		}else{
//			result = -1;//真实姓名不匹配，请与管理员联系
//		}
//		if(result==1){
//			String queryString3="update HhwCommonMemberProfile mo set mo.field5=? where mo.uid=? ";
//			Object[] p = new Object[]{cardnum,uid};
//			result = hhwCommonMemberProfileDao.updatePwdByhql(queryString3, p);
//			if(result==0){
//				result=-2;//"绑定失败"
//			}
//		}
		System.out.println("----------------------cardnum="+cardnum+",realname="+realname+",uid="+uid);
		return result;//result>0则提示用户"绑定成功"
	}
	
}
