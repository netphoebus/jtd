package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Greenroad;
import com.jlj.model.Sig;
import com.jlj.service.IGreenroadService;
import com.jlj.vo.MarkerVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("greenroadAction")
@Scope("prototype")
public class GreenroadAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private List<Greenroad> greenroads;

	private IGreenroadService greenroadService;
	private Greenroad greenroad;
	private int id;
	private Long mklid;
	private String smids;
	
	/**
	 * 加载绿波带
	 * @throws Exception
	 */
	public String loadLines() throws Exception {
		
		greenroads = greenroadService.getAllGreenroads();
		if(greenroads!=null&&greenroads.size()>0)
		{
			JSONArray jsonArr = JSONArray.fromObject(greenroads);
			System.out.println(jsonArr);
			PrintWriter out;
			try {
				response.setContentType("text/html;charset=UTF-8");
				out = response.getWriter();
				out.print(jsonArr.toString());
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
	
	
	public String addOrUpdateLine() throws Exception {
		setAjaxParams();
		greenroad = greenroadService.loadByMkid(mklid);
		if(greenroad!=null)
		{
			//update
			
			
		}else
		{
			greenroad = new Greenroad();
			greenroad.setMarklineid(mklid);
			greenroad.setSigmids(smids);
			greenroadService.add(greenroad);
		}
		
		
		return NONE;
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
	
	/**
	 * 处理ajax请求参数
	 * 
	 */
	private void setAjaxParams()
	{
		String linemid = req.getParameter("linemid");
		smids = req.getParameter("sids");
		
		System.out.println("linemid:"+linemid);
		System.out.println("smids:"+smids);
		
		if(linemid!=null)
		{
			mklid = Long.parseLong(linemid);
		}
		if(smids==null)
		{
			smids = "";
		}
		
	}
	/**
	 * 检查绿波带对象
	 * 
	 */
	
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

	public Greenroad getGreenroad() {
		return greenroad;
	}

	public void setGreenroad(Greenroad greenroad) {
		this.greenroad = greenroad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IGreenroadService getGreenroadService() {
		return greenroadService;
	}

	@Resource
	public void setGreenroadService(IGreenroadService greenroadService) {
		this.greenroadService = greenroadService;
	}


	public Long getMklid() {
		return mklid;
	}


	public void setMklid(Long mklid) {
		this.mklid = mklid;
	}


	public String getSmids() {
		return smids;
	}


	public void setSmids(String smids) {
		this.smids = smids;
	}


	public List<Greenroad> getGreenroads() {
		return greenroads;
	}


	public void setGreenroads(List<Greenroad> greenroads) {
		this.greenroads = greenroads;
	}


	

	
	
}
