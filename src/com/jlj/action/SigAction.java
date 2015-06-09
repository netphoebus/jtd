package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mina.TimeServerHandler;
import net.sf.json.JSONArray;

import org.apache.mina.core.session.IoSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Sig;
import com.jlj.model.SigPara;
import com.jlj.service.ISigService;
import com.jlj.util.Commands;
import com.jlj.vo.SigStatus;
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
	public static int[] Countdown = new int[4];
	private ISigService sigService;
	private Sig sig;
	private int id;
	public static String curruntSigIp;
	public int curruntCommandId;
	private SigPara sigParas;

	public String sigStatus() {
		// Usero usero = (Usero)session.get("usero");
		// int userid = usero.getId();
		int userid = 1;
		List<Sig> usersigs = sigService.querySigsByUser(userid);
		if (usersigs != null && usersigs.size() > 0) {
			List<SigStatus> sigstatuses = new ArrayList<SigStatus>();
			for (int i = 0; i < usersigs.size(); i++) {
				String thestatus="";
				IoSession theSession =this.getCurrrenSession(usersigs.get(i).getIp());
				if(theSession==null){
					thestatus = "<font color=red>断开</font>";
				}else if(usersigs.get(i).getIserror()==1){
					thestatus = "<font color=red>故障</font>";
				}else{
					thestatus = "正常";
				}
				SigStatus sigstatus = new SigStatus(usersigs.get(i)
						.getName(), thestatus);
				sigstatuses.add(sigstatus);
			}
			// 将list转化成JSON对象
			JSONArray jsonArray = JSONArray.fromObject(sigstatuses);
//			System.out.println(jsonArray.toString());
			PrintWriter out;
			try {
				response.setCharacterEncoding("UTF-8"); 
				out = response.getWriter();
				out.print(jsonArray);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}

	public IoSession getCurrrenSession(String sigIp)
	{
		for(IoSession session : TimeServerHandler.iosessions)
		{
			if(((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress().equals(sigIp))
			{
				return session;
			}
		}
		return null;
	}
	
	public String toTraffic() {
		long mkid = Long.parseLong(req.getParameter("mkid"));
		sig = sigService.loadByMkid(mkid);
		if (sig != null) {
			curruntSigIp = sig.getIp();
			session.put("sigIp", sig.getIp());// 从地图中进入信号机，将信号机ip传入session
		}
		return "traffic";
	}

	// 发送简单命令
	public String doCommand() {
		String commandIdStr = req.getParameter("commandId");
		System.out.println("执行命令编号：" + commandIdStr + "   " + "信号机链接对象："
				+ TimeServerHandler.iosessions);
		if (commandIdStr != null) {
			curruntCommandId = Integer.parseInt(commandIdStr);
			if (curruntSigIp != null && TimeServerHandler.iosessions != null
					&& TimeServerHandler.iosessions.size() > 0) {
				Commands.executeCommand(curruntCommandId, curruntSigIp,
						TimeServerHandler.iosessions);
			}
		}
		return null;
	}

	// 获得状态
	public String realtime() {
		/**
		 * trafficLigths[0-3]:表示一个红绿灯的各个方向依次为：0:东-》西,1:南-》北,2:西-》东,3:北-》南
		 * trafficLigths[0-3][0-4]：表示一个方向的5具体的灯： 0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道
		 * ,4:人行道 表示一个具体的灯： 3：红 2：黄 1：绿 0：灭 null：未知
		 */
		if (trafficlights != trafficlights_next) {
			trafficlights_next = trafficlights;
			String jsonString = "{\"success\":\"true\"" + ",\"l03\":\""
					+ trafficlights_next[0][3] + "\"" + // 东人行道
					",\"l23\":\"" + trafficlights_next[2][3] + "\"" + // 西人行道

					",\"l20\":\"" + trafficlights_next[2][0] + "\"" + // 西边左转灯
					",\"l21\":\"" + trafficlights_next[2][1] + "\"" + // 西边直行灯
					",\"l22\":\"" + trafficlights_next[2][2] + "\"" + // 西边右转灯

					",\"l00\":\"" + trafficlights_next[0][0] + "\"" + // 东边左转灯
					",\"l01\":\"" + trafficlights_next[0][1] + "\"" + // 东边直行灯
					",\"l02\":\"" + trafficlights_next[0][2] + "\"" + // 东边右转灯

					",\"l13\":\"" + trafficlights_next[1][3] + "\"" + // 南人行道
					",\"l33\":\"" + trafficlights_next[3][3] + "\"" + // 北人行道

					",\"l32\":\"" + trafficlights_next[3][2] + "\"" + // 北边右转灯
					",\"l31\":\"" + trafficlights_next[3][1] + "\"" + // 北边直行灯
					",\"l30\":\"" + trafficlights_next[3][0] + "\"" + // 北边左转灯

					",\"l11\":\"" + trafficlights_next[1][1] + "\"" + // 南边直行灯
					",\"l10\":\"" + trafficlights_next[1][0] + "\"" + // 南边左转灯
					",\"l12\":\"" + trafficlights_next[1][2] + "\"" + // 南边右转灯

					",\"dd\":\"" + trafficlights_next[0] + "\"" + // 东边倒计时
					",\"nd\":\"" + trafficlights_next[1] + "\"" + // 南边倒计时
					",\"xd\":\"" + trafficlights_next[2] + "\"" + // 西边倒计时
					",\"bd\":\"" + trafficlights_next[3] + "\"" + // 北边倒计时

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

	public SigPara getSigParas() {
		return sigParas;
	}

	public void setSigParas(SigPara sigParas) {
		this.sigParas = sigParas;
	}

	public int getCurruntCommandId() {
		return curruntCommandId;
	}

	public void setCurruntCommandId(int curruntCommandId) {
		this.curruntCommandId = curruntCommandId;
	}

}
