package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import com.jlj.service.ISigService;
import com.jlj.vo.MarkerVO;

@Component("mapAction")
@Scope("prototype")
public class MapAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private ISigService sigService;

	private List<MarkerVO> initMarkers = new ArrayList<MarkerVO>();
	private List<Sig> sigs = new ArrayList<Sig>();

	/**
	 * load加载地图
	 * 
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
		
=======
	public String load() throws Exception {

		signals = signalService.list();
		for (int i = 0; i < signals.size(); i++) {
			Marker marker = signals.get(i).getMarkers().get(0);
			MarkerVO markervo = new MarkerVO();
			markervo.setId(marker.getId());
			markervo.setAddress(marker.getAddress());
			markervo.setIp(marker.getIp());
			markervo.setLat(marker.getLat());
			markervo.setLng(marker.getLng());
			markervo.setName(marker.getName());
			initMarkers.add(markervo);
		}
		// JSONObject jsonObject = JSONObject.fromObject(markers);

		JSONArray jsonArr = JSONArray.fromObject(initMarkers);

>>>>>>> origin/master
		System.out.print(jsonArr);

		String jsonString = jsonArr.toString();

		PrintWriter out;
		try {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.print(jsonString);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		
=======

>>>>>>> origin/master
*/
		return NONE;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		String ip = req.getParameter("ip");
		String address = req.getParameter("address");
		String name = req.getParameter("name");
		String lng = req.getParameter("lng");
		String lat = req.getParameter("lat");

//		List<Marker> markers = new ArrayList<Marker>();
//		markers.add(marker);
//		Signal signal = new Signal();
//		signal.setMarkers(markers);
//
//		System.out.println(signal.getMarkers().get(0).getAddress());
//		signalService.save(signal);

		return NONE;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		long id = Long.parseLong(req.getParameter("id"));

		return NONE;
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
	 * 查看信息
	 * 
	 * @return
	 */
	public String view() {
		return "view";
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @return
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

	public List<Sig> getSigs() {
		return sigs;
	}

	public void setSigs(List<Sig> sigs) {
		this.sigs = sigs;
	}

	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}

	public ISigService getSigService() {
		return sigService;
	}
	
	public List<MarkerVO> getInitMarkers() {
		return initMarkers;
	}

	public void setInitMarkers(List<MarkerVO> initMarkers) {
		this.initMarkers = initMarkers;
	}

}
