package com.jlj.action;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mina.TimeServerHandler;

import org.apache.mina.core.session.IoSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("promotionAction")
@Scope("prototype")
public class PromotionAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private String centerIp;
	private String centerPort;
	
	
	/**
	 * 跳转至升级界面
	 * @return
	 * @throws UnknownHostException 
	 */
	public String promotion() throws UnknownHostException
	{
		String address = InetAddress.getLocalHost().getHostAddress();   
		System.out.println(address);
		if(address!=null&&!address.equals(""))
		{
			centerIp = address;
		}
		
		
		return "cssz-sj";
	}
	
	
	/**
	 * 升级及下发
	 * @return
	 */
	public String promotionSig()
	{
		System.out.println("正在升级.....");
		System.out.println(centerIp);
		System.out.println(centerPort);
		return null;
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


	
	public IoSession getCurrrenSession(String sigNumber)
	{
		for(IoSession session : TimeServerHandler.iosessions)
		{
			if(session.getAttribute("number").equals(sigNumber))
			{
				return session;
			}
		}
		return null;
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


	public String getCenterIp() {
		return centerIp;
	}


	public void setCenterIp(String centerIp) {
		this.centerIp = centerIp;
	}


	public String getCenterPort() {
		return centerPort;
	}


	public void setCenterPort(String centerPort) {
		this.centerPort = centerPort;
	}

	
	
	
}
