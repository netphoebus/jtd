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

import com.jlj.model.Greenconflict;
import com.jlj.model.Sig;
import com.jlj.service.IGreenconflictService;
import com.opensymphony.xwork2.ActionSupport;

@Component("greenAction")
@Scope("prototype")
public class GreenconflictAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private IGreenconflictService greenService;
	private List<Greenconflict> greens;

	private Sig sig;
	private int id;
	
	public String green()
	{
		greens = greenService.loadBySid(id);
		if(greens!=null)
		{
			session.put("id", id);//从地图中进入信号机，将信号机id传入session
			return "cssz-fa";
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


	public IGreenconflictService getGreenService() {
		return greenService;
	}

	@Resource
	public void setGreenService(IGreenconflictService greenService) {
		this.greenService = greenService;
	}


	public List<Greenconflict> getGreens() {
		return greens;
	}


	public void setGreens(List<Greenconflict> greens) {
		this.greens = greens;
	}
	
	
}
