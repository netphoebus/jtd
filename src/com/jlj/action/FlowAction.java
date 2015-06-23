package com.jlj.action;

import java.io.UnsupportedEncodingException;
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

import com.jlj.model.Flow;
import com.jlj.model.Sig;
import com.jlj.model.Usero;
import com.jlj.service.IFlowService;
import com.jlj.service.ISigService;
import com.jlj.service.IUseroService;
import com.opensymphony.xwork2.ActionSupport;

@Component("flowAction")
@Scope("prototype")
public class FlowAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IFlowService flowService;
	private IUseroService useroService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	private int id;
	private Flow flow;
	//分页显示
	private String[] arg=new String[2];
	private List<Flow> flows;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	//条件
	private int con;
	private String convalue;
	
	private List<Usero> useros;
	
	private ISigService sigService;
	private int sigid;
	private List<Sig> sigs;
	
	/**
	 * 车流量管理
	 */
	private String time1;
	private String time2;
	public String list() throws Exception{
		//----------------------------------查询车流量-------------------------------------
		Usero usero = (Usero)session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}
		int userid = usero.getId();
		sigs=sigService.querySigsByUser(userid);
		
		if(time1!=null&&!time1.equals("")){
			time1=URLDecoder.decode(time1, "utf-8");
		}
		
		if(time2!=null&&!time2.equals("")){
			time2=URLDecoder.decode(time2, "utf-8");
		}
		
		if(page<1){
			page=1;
		}
		//总记录数
		if(sigid!=0||(time1!=null&&!time1.trim().equals(""))||(time2!=null&&!time2.trim().equals(""))){
			
			totalCount=flowService.getConditionTotalCount(sigid,time1,time2);
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryConditionList(sigid,time1,time2,page,size);
		}else{
			totalCount=flowService.getTotalCount();
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryList(page,size);
		}
		
		return "list";
	}
	/**
	 * 流量折线图
	 * @return
	 */
	public String listline() throws Exception{
		//----------------------------------查询流量折线图-------------------------------------
		Usero usero = (Usero)session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}
		int userid = usero.getId();
		sigs=sigService.querySigsByUser(userid);
		
		if(time1!=null&&!time1.equals("")){
			time1=URLDecoder.decode(time1, "utf-8");
		}
		
		if(time2!=null&&!time2.equals("")){
			time2=URLDecoder.decode(time2, "utf-8");
		}
		
		if(page<1){
			page=1;
		}
		//总记录数
		if(sigid!=0||(time1!=null&&!time1.trim().equals(""))||(time2!=null&&!time2.trim().equals(""))){
			
			totalCount=flowService.getConditionTotalCount(sigid,time1,time2);
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryConditionList(sigid,time1,time2,page,size);
		}else{
			totalCount=flowService.getTotalCount();
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryList(page,size);
		}
		return "listline";
	}
	
	/**
	 * 流量直方图
	 * @return
	 * @throws Exception 
	 */
	public String listbar() throws Exception{
		//----------------------------------查询直方图-------------------------------------
		Usero usero = (Usero)session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}
		int userid = usero.getId();
		sigs=sigService.querySigsByUser(userid);
		
		if(time1!=null&&!time1.equals("")){
			time1=URLDecoder.decode(time1, "utf-8");
		}
		
		if(time2!=null&&!time2.equals("")){
			time2=URLDecoder.decode(time2, "utf-8");
		}
		
		if(page<1){
			page=1;
		}
		//总记录数
		if(sigid!=0||(time1!=null&&!time1.trim().equals(""))||(time2!=null&&!time2.trim().equals(""))){
			
			totalCount=flowService.getConditionTotalCount(sigid,time1,time2);
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryConditionList(sigid,time1,time2,page,size);
		}else{
			totalCount=flowService.getTotalCount();
			//总页数
			pageCount=flowService.getPageCount(totalCount,size);
			if(pageCount!=0&&page>pageCount){
				page=pageCount;
			}
			//所有当前页记录对象
			flows=flowService.queryList(page,size);
		}
		return "listbar";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	private String outinfo;
	public String add() throws Exception{
		flowService.add(flow);
		outinfo="恭喜您，添加用户成功！";
		return this.list();
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public String delete() throws Exception{
		flowService.deleteById(id);
		outinfo="恭喜您，删除用户成功！";
		return this.list();
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		flowService.update(flow);
		outinfo="恭喜您，修改用户成功！";
		return this.list();
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		flow=flowService.loadById(id);
		return "load";
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
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	

	
	//get、set-------------------------------------------
	
	public IFlowService getFlowService() {
		return flowService;
	}
	
	@Resource
	public void setFlowService(IFlowService flowService) {
		this.flowService = flowService;
	}
	public Flow getFlow() {
		return flow;
	}
	public void setFlow(Flow flow) {
		this.flow = flow;
	}
	public List<Flow> getFlows() {
		return flows;
	}
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
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
	public List<Usero> getUseros() {
		return useros;
	}
	public void setUseros(List<Usero> useros) {
		this.useros = useros;
	}
	public List<Sig> getSigs() {
		return sigs;
	}
	public void setSigs(List<Sig> sigs) {
		this.sigs = sigs;
	}
	public ISigService getSigService() {
		return sigService;
	}
	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}
	public int getSigid() {
		return sigid;
	}
	public void setSigid(int sigid) {
		this.sigid = sigid;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
	
	
}
