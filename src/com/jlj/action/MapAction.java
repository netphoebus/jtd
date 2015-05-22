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

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Sig;
import com.jlj.model.Userarea;
import com.jlj.service.ISigService;
import com.jlj.vo.MarkerVO;
import com.opensymphony.xwork2.ActionSupport;

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
	private List<Sig> sigs;
	private Sig sig;

	/**
	 * load加载地图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception {
		System.out.println("---------------1");
		sigs = sigService.getAllSigs();
		System.out.println("---------------2");
		if(sigs!=null&&sigs.size()>0)
		{
			for (Sig sig : sigs) {
				MarkerVO markervo = new MarkerVO();
				markervo.setId(sig.getMkid());
				markervo.setAddress(sig.getAddress());
				markervo.setIp(sig.getIp());
				markervo.setLat(sig.getLat());
				markervo.setLng(sig.getLng());
				markervo.setName(sig.getName());
				initMarkers.add(markervo);
			}
			JSONArray jsonArr = JSONArray.fromObject(initMarkers);

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
	public String addOrUpdate() throws Exception {
		String ip = req.getParameter("ip");
		long mkid = Long.parseLong(req.getParameter("id"));
		String address = req.getParameter("address");
		String name = req.getParameter("name");
		String lng = req.getParameter("lng");
		String lat = req.getParameter("lat");
		Sig sig1 = sigService.querySigByIpAddress(ip);
		if(sig1==null){
			System.out.println("coming null.......");
			Sig sig = new Sig();
			sig.setMkid(mkid);
			sig.setIp(ip);
			sig.setAddress(address);
			sig.setName(name);
			sig.setLat(lat);
			sig.setLng(lng);
			sigService.add(sig);
		}else
		{
			System.out.println("coming.......");
			sig1.setMkid(mkid);
			sig1.setAddress(address);
			sig1.setName(name);
			sig1.setLat(lat);
			sig1.setLng(lng);
			sigService.update(sig1);
		}
		return NONE;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		long mkid = Long.parseLong(req.getParameter("id"));
		System.out.println(mkid);
		sigs = sigService.getSigs();
		if(sigs!=null&&sigs.size()>0)
		{
			for (Sig sigobj : sigs) {
				if(sigobj.getMkid()!=null&&sigobj.getMkid()==mkid)
				{
					sig = sigobj;
					sig.setMkid(null);
					sig.setAddress(null);
					sig.setName(null);
					sig.setLat(null);
					sig.setLng(null);
					sigService.update(sig);
					break;
				}
			}
		}
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
	 * 跳转到实时页面
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

	public Sig getSig() {
		return sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	
}
