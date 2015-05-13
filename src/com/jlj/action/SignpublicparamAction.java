package com.jlj.action;

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


import com.jlj.dao.ISignpublicparamDao;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.opensymphony.xwork2.ActionSupport;

@Component("sigpublicparamAction")
@Scope("prototype")
public class SignpublicparamAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private ISigService sigService;
	private ISignpublicparamService sigpubparamService;
	private Signpublicparam sigpubparam;
	private int id;
	private Sig sig;
	
	
	private Integer spetimeable;
	private Integer suntimeable;
	
	//跳转 一般参数页面  
	public String publicParam() {
		sigpubparam = sigpubparamService.loadById(id);
		if(sigpubparam!=null)
		{
			initPublicParamJSP(sigpubparam);
			return "cssz-cs";
		}else
		{
			return "error";//预留没有查询到相应公共参数时跳转的提示页面
		}
	}
	
	private void initPublicParamJSP(Signpublicparam sigpubparam)
	{
		//工作日设置处理
		switch(sigpubparam.getWorkingset())
		{
			case 0:
				spetimeable = 0;
				suntimeable = 0;
				break;
			case 1:
				spetimeable = 1;
				suntimeable = 0;
				break;
			case 2:
				spetimeable = 0;
				suntimeable = 1;
				break;
			case 3:
				spetimeable = 1;
				suntimeable = 1;
				break;
		}
		
	}

	
	
	//处理一般参数jsp显示
	private void setPublicParamJSP()
	{
		//行人请求处理
		if(sigpubparam.getXyxr()==null)
		{
			sigpubparam.setXyxr(0);
		}
		//工作日设置处理
		if(spetimeable==null)
		{
			spetimeable = 0;
		}
		if(suntimeable==null)
		{
			suntimeable = 0;
		}
		if(spetimeable==1&&suntimeable==1)
		{
			sigpubparam.setWorkingset(3);
		}
		if(spetimeable==1&&suntimeable!=1)
		{
			sigpubparam.setWorkingset(2);
		}
		if(spetimeable!=1&&suntimeable==1)
		{
			sigpubparam.setWorkingset(1);
		}
		if(spetimeable!=1&&suntimeable!=1)
		{
			sigpubparam.setWorkingset(0);
		}
		
		//周日 处理
		if(sigpubparam.getMon()==null)
		{
			sigpubparam.setMon(0);
		}
		if(sigpubparam.getTue()==null)
		{
			sigpubparam.setTue(0);
		}
		if(sigpubparam.getWes()==null)
		{
			sigpubparam.setWes(0);
		}
		if(sigpubparam.getThir()==null)
		{
			sigpubparam.setThir(0);
		}
		if(sigpubparam.getFra()==null)
		{
			sigpubparam.setFra(0);
		}
		if(sigpubparam.getSata()==null)
		{
			sigpubparam.setSata(0);
		}
		if(sigpubparam.getSun()==null)
		{
			sigpubparam.setSun(0);
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
		System.out.println(suntimeable);
		System.out.println(spetimeable);
		setPublicParamJSP();
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


	public ISignpublicparamService getSigpubparamService() {
		return sigpubparamService;
	}

	@Resource
	public void setSigpubparamService(ISignpublicparamService sigpubparamService) {
		this.sigpubparamService = sigpubparamService;
	}


	public Signpublicparam getSigpubparam() {
		return sigpubparam;
	}


	public void setSigpubparam(Signpublicparam sigpubparam) {
		this.sigpubparam = sigpubparam;
	}

	public int getSpetimeable() {
		return spetimeable;
	}

	public void setSpetimeable(int spetimeable) {
		this.spetimeable = spetimeable;
	}

	public int getSuntimeable() {
		return suntimeable;
	}

	public void setSuntimeable(int suntimeable) {
		this.suntimeable = suntimeable;
	}


}
