package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.jlj.service.ISigService;
import com.jlj.service.imp.SigServiceImp;
import com.opensymphony.xwork2.ActionSupport;

@Component("sigAction")
@Scope("prototype")
public class SigAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	public static int[][] trafficlights = new int[4][5];
	private static int[][] trafficlights_next = new int[4][5];
	private ISigService sigService;
	private Sig sig;
	private int id;
	private String ip;
	
	
	public String toTraffic()
	{
		long mkid = Long.parseLong(req.getParameter("mkid"));
		sig = sigService.loadByMkid(mkid);
		if(sig!=null)
		{
			ip = sig.getIp();
		}
		return "traffic";
	}
	
	
	// =========后台首页类别=================================================
	public String realTime() {
		
		 
		
		/**
		 * trafficLigths[0-3]:表示一个红绿灯的各个方向依次为：0:东,1:南,2:西,3:北
		 * trafficLigths[0-3][0-4]：表示一个方向的5具体的灯： 0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道
		 * ,4:人行道 表示一个具体的灯： 3：红 2：黄 1：绿 0：灭 null：未知
		 * 
		 * 
		 */

		if (trafficlights != trafficlights_next) {
			trafficlights_next = trafficlights;
			String jsonString = "{\"success\":\"true\"" + ",\"h01\":\""
					+ trafficlights_next[0][3] + "\"" + // 东西方向人行道灯(表示两个)

					",\"h02\":\"" + trafficlights_next[2][0] + "\"" + // 西边左转灯
					",\"h03\":\"" + trafficlights_next[2][1] + "\"" + // 西边直行灯
					",\"h04\":\"" + trafficlights_next[2][2] + "\"" + // 西边右转灯

					",\"h05\":\"" + trafficlights_next[0][0] + "\"" + // 东边左转灯
					",\"h06\":\"" + trafficlights_next[0][1] + "\"" + // 东边直行灯
					",\"h07\":\"" + trafficlights_next[0][2] + "\"" + // 东边右转灯

					",\"s01\":\"" + trafficlights_next[1][3] + "\"" + // 南北方向人行道(表示两个)

					",\"s02\":\"" + trafficlights_next[3][2] + "\"" + // 北边右转灯
					",\"s03\":\"" + trafficlights_next[3][1] + "\"" + // 北边直行灯
					",\"s04\":\"" + trafficlights_next[3][0] + "\"" + // 北边左转灯

					",\"s05\":\"" + trafficlights_next[1][1] + "\"" + // 南边直行灯
					",\"s06\":\"" + trafficlights_next[1][0] + "\"" + // 南边左转灯
					",\"s07\":\"" + trafficlights_next[1][2] + "\"" + // 南边右转灯
					"}";
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(jsonString);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return NONE;
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


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
