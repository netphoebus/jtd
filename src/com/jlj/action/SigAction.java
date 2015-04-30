package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mina.TimeServerHandler;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Sig;
import com.jlj.service.ISigService;
import com.jlj.util.Commands;
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
	public static String curruntSigIp;
	
	
	public String toTraffic()
	{
		long mkid = Long.parseLong(req.getParameter("mkid"));
		sig = sigService.loadByMkid(mkid);
		if(sig!=null)
		{
			curruntSigIp = sig.getIp();
		}
		return "traffic";
	}
	
	public String doCommand()
	{
		String commandIdStr = req.getParameter("commandId");
		if(commandIdStr!=null)
		{
			int commandId = Integer.parseInt(commandIdStr);
			if(curruntSigIp!=null&&TimeServerHandler.iosessions!=null&&TimeServerHandler.iosessions.size()>0)
			{
				Commands.executeCommand(commandId,curruntSigIp,TimeServerHandler.iosessions);
			}
		}
		
		return null;
	}
	
	
	// =========后台首页类别=================================================
	public String realtime() {
		/**
		 * trafficLigths[0-3]:表示一个红绿灯的各个方向依次为：0:东-》西,1:南-》北,2:西-》东,3:北-》南
		 * trafficLigths[0-3][0-4]：表示一个方向的5具体的灯： 0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道
		 * ,4:人行道 表示一个具体的灯： 3：红 2：黄 1：绿 0：灭 null：未知
		 * 
		 * 
		 */
		if (trafficlights != trafficlights_next) {
			trafficlights_next = trafficlights;
			String jsonString = "{\"success\":\"true\"" + ",\"l03\":\""
					+ trafficlights_next[1][3] + "\"" + // 东西方向人行道灯(表示两个)
					
					",\"l20\":\"" + trafficlights_next[2][0] + "\"" + // 西边左转灯
					",\"l21\":\"" + trafficlights_next[2][1] + "\"" + // 西边直行灯
					",\"l22\":\"" + trafficlights_next[2][2] + "\"" + // 西边右转灯

					",\"l00\":\"" + trafficlights_next[0][0] + "\"" + // 东边左转灯
					",\"l01\":\"" + trafficlights_next[0][1] + "\"" + // 东边直行灯
					",\"l02\":\"" + trafficlights_next[0][2] + "\"" + // 东边右转灯

					",\"l13\":\"" + trafficlights_next[0][3] + "\"" + // 南北方向人行道(表示两个)

					",\"l32\":\"" + trafficlights_next[3][2] + "\"" + // 北边右转灯
					",\"l31\":\"" + trafficlights_next[3][1] + "\"" + // 北边直行灯
					",\"l30\":\"" + trafficlights_next[3][0] + "\"" + // 北边左转灯

					",\"l11\":\"" + trafficlights_next[1][1] + "\"" + // 南边直行灯
					",\"l10\":\"" + trafficlights_next[1][0] + "\"" + // 南边左转灯
					",\"l12\":\"" + trafficlights_next[1][2] + "\"" + // 南边右转灯
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

	
	
	
}