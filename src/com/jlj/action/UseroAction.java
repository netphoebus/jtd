package com.jlj.action;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Usero;
import com.jlj.service.IUseroService;
import com.opensymphony.xwork2.ActionSupport;

@Component("useroAction")
@Scope("prototype")
public class UseroAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IUseroService useroService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	private int id;
	private Usero usero;
	//登陆-用户名、密码、验证码参数
	private String username;
	private String password;
	private String validate;
	//分页显示
	private String[] arg=new String[2];
	private List<Usero> useros;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	private String frontpa;
	
	/**
	 * 用户登陆
	 */
	public String login(){
		if(username==null||username.equals("")||password==null||password.equals("")){
			String loginfail="用户名或密码不能为空";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}
		Usero usero=useroService.userlogin(username,password);
		String code=(String) session.get("code");
		if(usero==null){
			String loginfail="用户名或密码输入有误";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}else if(validate==null||!validate.equalsIgnoreCase(code)){
			String loginfail="验证码输入有误";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}else{
			session.put("usero", usero);
			return "loginSucc";
		}
	}
	/**
	 * 公众号管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=useroService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		useros=useroService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=useroService.getTotalCount(con,convalue);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		useroService.add(usero);
		
		arg[0]="useroAction!list";
		arg[1]="公众号管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Usero usero=useroService.loadById(id);
		useroService.delete(usero);
		
		arg[0]="useroAction!list";
		arg[1]="公众号管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		useroService.update(usero);
		arg[0]="useroAction!list";
		arg[1]="公众号管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		usero=useroService.loadById(id);
		return "view";
	}
	/**
	 * 查看个人信息
	 * @return
	 */
	public String clientview(){
		usero=useroService.loadById(id);
		return "clientview";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		usero=useroService.loadById(id);
		return "load";
	}
	
	private String newpwd;//新密码
	private String againpwd;//再次输入新密码
	private String oldpwd;//旧密码
	/**
	 * 修改个人密码
	 * @return
	 */
	public String upMyPwd(){
		Usero usero=useroService.userlogin(username,oldpwd);
		String errorInfo=null;
		if(usero==null){
			errorInfo="原密码输入有误";
			request.put("errorInfo", errorInfo);
			return "operror";
		}else{
			if(newpwd!=null&&!newpwd.equals("")&&againpwd!=null&&!againpwd.equals("")&&againpwd.equals(newpwd)){
				useroService.updatePwd(newpwd,usero.getId());
				
				arg[0]="main.jsp";
				arg[1]="主页";
				return SUCCESS;
			}else{
				errorInfo="两次密码输入不一致";
				request.put("errorInfo", errorInfo);
				return "operror";
			}
		}
	}
	
	
	
	
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }    
    public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
    public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public String getConvalue() {
		return convalue;
	}
	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getAgainpwd() {
		return againpwd;
	}
	public void setAgainpwd(String againpwd) {
		this.againpwd = againpwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}
	
	//get、set-------------------------------------------
	
	public IUseroService getUseroService() {
		return useroService;
	}
	
	@Resource
	public void setUseroService(IUseroService useroService) {
		this.useroService = useroService;
	}
	public Usero getUsero() {
		return usero;
	}
	public void setUsero(Usero usero) {
		this.usero = usero;
	}
	public List<Usero> getUseros() {
		return useros;
	}
	public void setUseros(List<Usero> useros) {
		this.useros = useros;
	}
	
	
}
