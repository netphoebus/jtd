package com.jlj.action;

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

import com.jlj.model.Commontime;
import com.jlj.model.Sig;
import com.jlj.service.ICommontimeService;
import com.jlj.service.ISigService;
import com.opensymphony.xwork2.ActionSupport;

@Component("sigtimeAction")
@Scope("prototype")
public class SigtimeAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private ISigService sigService;
	private ICommontimeService commontimeService;
	
	private List<Commontime> commontimes;
	
	private Sig sig;
	private int id;
	private Commontime commontime;
	private Integer timetype;
	private int sid;
	private int timeid;
	
	public String sigtimes()
	{
		timetype  = Integer.parseInt(req.getParameter("timetype"));//获得前台的时间类型
		//处理时间类型
		if(timetype==null||timetype==0)
		{
			timetype = 1;
		}
		//判断是否获得了sid，信号机的id
		if(sid!=0)
		{
			commontimes = commontimeService.getCommontimesBySigAndTimetype(sid,timetype);
		}
		if(commontimes.size()>0)
		{
			session.put("sid", sid);//从地图中进入信号机，将信号机id传入session
			return "cssz-time";
		}else
		{
			return "error";//预留没有查询到相应公共参数时跳转的提示页面
		}
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */

	public String add() throws Exception {
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update() throws Exception {
		return SUCCESS;
	}

	// get、set-------------------------------------------

	// 获得HttpServletResponse对象
	public void setServletResponse(HttpServletResponse response) {
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

	public Sig getSig() {
		return sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ISigService getSigService() {
		return sigService;
	}

	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}


	public ICommontimeService getCommontimeService() {
		return commontimeService;
	}

	@Resource
	public void setCommontimeService(ICommontimeService commontimeService) {
		this.commontimeService = commontimeService;
	}


	public List<Commontime> getCommontimes() {
		return commontimes;
	}


	public void setCommontimes(List<Commontime> commontimes) {
		this.commontimes = commontimes;
	}


	public Commontime getCommontime() {
		return commontime;
	}


	public void setCommontime(Commontime commontime) {
		this.commontime = commontime;
	}


	public void setTimetype(Integer timetype) {
		this.timetype = timetype;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getTimeid() {
		return timeid;
	}


	public void setTimeid(int timeid) {
		this.timeid = timeid;
	}
	
	
	
}
