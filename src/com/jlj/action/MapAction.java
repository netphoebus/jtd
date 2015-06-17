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

import com.jlj.model.Sig;
import com.jlj.model.Userarea;
import com.jlj.model.Usero;
import com.jlj.service.ISigService;
import com.jlj.service.IUserareaService;
import com.jlj.vo.MarkerVO;
import com.jlj.vo.UserareaVO;
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
	private IUserareaService userareaService;

	private List<MarkerVO> initMarkers = new ArrayList<MarkerVO>();
	private List<Sig> sigs;
	private List<Userarea> userareas;
	private List<UserareaVO> userareaVOs;
	
	
	private Sig sig;
	private String sigIp;
	private Usero usero;
	private Userarea userarea;
	private int areaid;
	
	
	/*
	 * 信号机 map
	 */
	private String name;
	private int id;
	private Long mkid;
	private String address;
	private String ip;
	private String lng;
	private String lat;
	
	/*
	 * 用户
	 */
	
	
	
	/**
	 * 加载当前地图的区域
	 * @return
	 */
	public String loadArea()
	{
		usero = (Usero) session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}else
		{
			userareas = userareaService.queryList(usero.getId());
			if(userareas.size()>0)
			{
				userarea = userareas.get(0);
				UserareaVO areaVO = new UserareaVO();
				areaVO.setAreaname(userarea.getUareaname());
				areaVO.setId(userarea.getId());
				areaVO.setLat(userarea.getLat());
				areaVO.setLng(userarea.getLng());
				areaVO.setSize(userarea.getSize());
				areaVO.setUlimit(usero.getUlimit());
				JSONObject jsonObj = JSONObject.fromObject(areaVO);
				PrintWriter out;
				try {
					response.setContentType("text/html;charset=UTF-8");
					out = response.getWriter();
					out.print(jsonObj.toString());
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
	}
	
	/**
	 * load加载地图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception {
		usero = (Usero) session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}
		userarea = getCurrentUserarea(usero,areaid);
		if(userarea!=null)
		{
			getCurrentSigs(userarea);
		}
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
	 * 加载当前用户的所有的区域
	 * @return
	 */
	public String loadAreas()
	{
		usero = (Usero) session.get("usero");
		if(usero==null){
			return "opsessiongo";
		}else
		{
			userareas = userareaService.queryList(usero.getId());
			if(userareas.size()>0)
			{
				userareaVOs = new ArrayList<UserareaVO>();
				for(Userarea userarea:userareas)
				{
					UserareaVO areaVO = new UserareaVO();
					areaVO.setAreaname(userarea.getUareaname());
					areaVO.setId(userarea.getId());
					userareaVOs.add(areaVO);
				}
				JSONArray jsonArr = JSONArray.fromObject(userareaVOs);
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
			return null;
		}
		
	}
	
	/**
	 * 查询当前区域内的信号机
	 * @param userarea
	 */
	private void getCurrentSigs(Userarea userarea) {
		// TODO Auto-generated method stub
		sigs = sigService.querySigsByUserarea(userarea.getId());
	}


	/**
	 * 
	 * @param usero2
	 * @return
	 */
	private Userarea getCurrentUserarea(Usero usero,int areaid) {
		// TODO Auto-generated method stub
		userareas = userareaService.queryList(usero.getId());
		if(areaid==0)
		{
			userarea = userareas.get(0);
		}else
		{
			for(Userarea area:userareas)
			{
				if(area.getId()==areaid)
				{
					userarea = area;
					break;
				}
			}
		}
		return userarea;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception信号机
	 */
	public String addOrUpdate() throws Exception {
		Sig sig1 = sigService.querySigByIpAddress(ip);
		userarea = userareaService.loadById(areaid);
		if(sig1==null){
			
			//System.out.println("coming null.......");
			Sig sig = new Sig();
			if(userarea!=null)
			{
				sig.setUserarea(userarea);
			}
			sig.setMkid(mkid);
			sig.setIp(ip);
			sig.setAddress(address);
			sig.setName(name);
			sig.setLat(lat);
			sig.setLng(lng);
			sig.setIserror(0);
			sigService.add(sig);
		}else
		{
			//System.out.println("coming.......");
			if(userarea!=null)
			{
				sig1.setUserarea(userarea);
			}
			sig1.setMkid(mkid);
			sig1.setAddress(address);
			sig1.setName(name);
			sig1.setLat(lat);
			sig1.setLng(lng);
			sig1.setIserror(0);
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
		sigIp = (String) session.get("sigIp");
		if(sigIp==null){
			return "opsessiongo";
		}
		sig = sigService.querySigByIpAddress(sigIp);
		sig.setMkid(null);
		sig.setAddress(null);
		sig.setName(null);
		sig.setLat(null);
		sig.setLng(null);
		sigService.update(sig);
		return "map";
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
	 * 处理从url链接中传过来的参数
	 */
	public void setURLParameter() {
		if (req.getParameter("address") != null) {
			address = req.getParameter("address");
		}
		if (req.getParameter("name") != null) {
			name = req.getParameter("name");
		}
		if (req.getParameter("mkid") != null) {
			mkid = Long.parseLong(req.getParameter("mkid"));
		}
		if (req.getParameter("ip") != null) {
			ip = req.getParameter("ip");
		}
		if (req.getParameter("lat") != null) {
			lat = req.getParameter("lat");
		}
		if (req.getParameter("lng") != null) {
			lng = req.getParameter("lng");
		}
		if (req.getParameter("areaid") != null) {
			areaid = Integer.parseInt(req.getParameter("areaid"));
		}
		System.out.println(address+""+ name+""+ mkid+""+ip +""+lat +""+lng +""+areaid);
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

	public String getSigIp() {
		return sigIp;
	}

	public void setSigIp(String sigIp) {
		this.sigIp = sigIp;
	}


	public Usero getUsero() {
		return usero;
	}

	public void setUsero(Usero usero) {
		this.usero = usero;
	}



	public List<Userarea> getUserareas() {
		return userareas;
	}



	public void setUserareas(List<Userarea> userareas) {
		this.userareas = userareas;
	}


	public IUserareaService getUserareaService() {
		return userareaService;
	}

	@Resource
	public void setUserareaService(IUserareaService userareaService) {
		this.userareaService = userareaService;
	}


	public int getAreaid() {
		return areaid;
	}


	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}


	public Userarea getUserarea() {
		return userarea;
	}


	public void setUserarea(Userarea userarea) {
		this.userarea = userarea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getMkid() {
		return mkid;
	}

	public void setMkid(Long mkid) {
		this.mkid = mkid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public List<UserareaVO> getUserareaVOs() {
		return userareaVOs;
	}

	public void setUserareaVOs(List<UserareaVO> userareaVOs) {
		this.userareaVOs = userareaVOs;
	}

	

	
}
