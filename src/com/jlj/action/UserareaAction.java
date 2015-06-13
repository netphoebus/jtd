package com.jlj.action;

import java.net.URLDecoder;
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

import com.jlj.model.Sig;
import com.jlj.model.Userarea;
import com.jlj.model.Usero;
import com.jlj.service.ISigService;
import com.jlj.service.IUserareaService;
import com.jlj.service.IUseroService;
import com.opensymphony.xwork2.ActionSupport;

@Component("userareaAction")
@Scope("prototype")
public class UserareaAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IUserareaService userareaService;
	private IUseroService useroService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	private int id;
	private Userarea userarea;
	//分页显示
	private List<Userarea> userareas;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	//条件
	
	private int userid;
	private String uareaname;
	/**
	 * 用户片区
	 */
	public String list() throws Exception{
		//----------------------------------查询片区-------------------------------------
		if(uareaname!=null&&!uareaname.equals("")){
			uareaname=URLDecoder.decode(uareaname, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		if(userid!=0){
			totalCount=userareaService.getConditionTotalCount(userid,uareaname);
			//总页数
			pageCount=userareaService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			userareas=userareaService.queryConditionList(userid,uareaname,page,size);
		}
		return "list";
	}
	
	/**
	 * 片区管理
	 */
	private List<Usero> useros;
	public String alllist() throws Exception{
		useros = useroService.getUsers();
		
		//----------------------------------查询片区-------------------------------------
		if(uareaname!=null&&!uareaname.equals("")){
			uareaname=URLDecoder.decode(uareaname, "utf-8");
		}
		if(page<1){
			page=1;
		}
			//总记录数
			totalCount=userareaService.getConditionTotalCount(uareaname);
			//总页数
			pageCount=userareaService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			userareas=userareaService.queryConditionList(uareaname,page,size);
		return "alllist";
	}
	
	
	private String outinfo;
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		userareaService.add(userarea);
		outinfo="恭喜您，添加片区成功！";
		return this.alllist();
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		userareaService.deleteById(id);
		outinfo="恭喜您，删除片区成功！";
		return this.alllist();
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		useros = useroService.getUsers();
		userarea=userareaService.loadById(id);
		return "load";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load2() throws Exception{
		useros = useroService.getUsers();
		userarea=userareaService.loadById(id);
		return "load2";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		userareaService.update(userarea);
		outinfo="恭喜您，修改片区成功！";
		return this.alllist();
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update2() throws Exception{
		userareaService.update(userarea);
		outinfo="恭喜您，修改片区成功！";
		return this.list();
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

	
	//get、set-------------------------------------------
	
	public IUserareaService getUserareaService() {
		return userareaService;
	}
	
	@Resource
	public void setUserareaService(IUserareaService userareaService) {
		this.userareaService = userareaService;
	}
	public Userarea getUserarea() {
		return userarea;
	}
	public void setUserarea(Userarea userarea) {
		this.userarea = userarea;
	}
	public List<Userarea> getUserareas() {
		return userareas;
	}
	public void setUserareas(List<Userarea> userareas) {
		this.userareas = userareas;
	}
	public String getOutinfo() {
		return outinfo;
	}
	public void setOutinfo(String outinfo) {
		this.outinfo = outinfo;
	}
	
	public IUseroService getUseroService() {
		return useroService;
	}
	@Resource
	public void setUseroService(IUseroService useroService) {
		this.useroService = useroService;
	}
	
	public int getuserid() {
		return userid;
	}
	public void setuserid(int userid) {
		this.userid = userid;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUareaname() {
		return uareaname;
	}


	public void setUareaname(String uareaname) {
		this.uareaname = uareaname;
	}

	public List<Usero> getUseros() {
		return useros;
	}

	public void setUseros(List<Usero> useros) {
		this.useros = useros;
	}
	
	
}