package com.jlj.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.opensymphony.xwork2.ActionSupport;
import com.jlj.model.*;
import com.jlj.service.ISignalService;
@Component("mapAction")
@Scope("prototype")
public class MapAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	private ISignalService signService;
	
	
//	private List<Marker> markers = new ArrayList<Marker>();
	
	/**
	 * load加载地图
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception{
		
		/*
		Marker marker = new Marker();
		marker.setId(1429345746000l);//id有问题？
		marker.setAddress("123");
		marker.setName("123");
		marker.setLat("31.371519712131036");
		marker.setLng("119.69741821289062");
		
		markers.add(marker);
		*/
		//JSONObject jsonObject = JSONObject.fromObject(markers);
		/*
		JSONArray jsonArr= JSONArray.fromObject(markers);
		
		System.out.print(jsonArr);
		
		String jsonString = jsonArr.toString();
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonString);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		return NONE;
	}
	
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		
		long id =  Long.parseLong(req.getParameter("id"));
		String ip = req.getParameter("ip");
		String address = req.getParameter("address");
		String name = req.getParameter("name");
		String lng = req.getParameter("lng");
		String lat = req.getParameter("lat");
		/*
		Marker marker = new Marker();
		marker.setId(id);
		marker.setIp(ip);
		marker.setAddress(address);
		marker.setName(name);
		marker.setLat(lat);
		marker.setLng(lng);
		System.out.println(marker);
		*/
		return NONE;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		long id =  Long.parseLong(req.getParameter("id"));
		
		return NONE;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{		
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	
	
	
	//get、set-------------------------------------------

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
//	public List<Marker> getMarkers() {
//		return markers;
//	}
//	public void setMarkers(List<Marker> markers) {
//		this.markers = markers;
//	}
    
	

}
