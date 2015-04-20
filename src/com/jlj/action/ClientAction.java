package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Client;
import com.jlj.service.IClientService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("clientAction")
@Scope("prototype")
public class ClientAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IClientService clientService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Client client;
	//分页显示
	private String[] arg=new String[2];
	private List<Client> clients;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	public static int[][] trafficlights =  new int[4][5];
	//=========后台首页类别=================================================
	public String test(){
		//initTrafficLights();
		
		/**
		 * trafficLigths[0-3]:表示一个红绿灯的各个方向依次为：0:东,1:南,2:西,3:北
		 * 			  trafficLigths[0-3][0-4]：表示一个方向的5具体的灯： 0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道 ,4:人行道
		 * 			  表示一个具体的灯：  3：红 2：黄 1：绿 0：灭  null：未知
		 * 
		 * 
		 */
		
		for(int i=0;i<trafficlights.length;i++){
  	  		for(int j=0;j<trafficlights[i].length;j++){
  	  		System.out.print(trafficlights[i][j]);
  	  		
  	  			}
  	  		System.out.println(" ");
  	  	}
		
		String jsonString = "{\"success\":\"true\"" +
				",\"h01\":\"" + trafficlights[0][3] + "\"" + //东西方向人行道灯(表示两个)
				
				",\"h02\":\"" + trafficlights[2][0] + "\"" + //西边左转灯
				",\"h03\":\"" + trafficlights[2][1] + "\"" + //西边直行灯
				",\"h04\":\"" + trafficlights[2][2] + "\"" + //西边右转灯
				
				",\"h05\":\"" + trafficlights[0][0] + "\"" + //东边左转灯
				",\"h06\":\"" + trafficlights[0][1] + "\"" + //东边直行灯
				",\"h07\":\"" + trafficlights[0][2] + "\"" + //东边右转灯
				
				",\"s01\":\"" + trafficlights[1][3] + "\"" + //南北方向人行道(表示两个)
				
				",\"s02\":\"" + trafficlights[3][2] + "\"" + //北边右转灯
				",\"s03\":\"" + trafficlights[3][1] + "\"" + //北边直行灯
				",\"s04\":\"" + trafficlights[3][0] + "\"" + //北边左转灯
				
				",\"s05\":\"" + trafficlights[1][1] + "\"" + //南边直行灯
				",\"s06\":\"" + trafficlights[1][0] + "\"" + //南边左转灯
				",\"s07\":\"" + trafficlights[1][2] + "\"" + //南边右转灯
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
		return NONE;
	}
	/**
	 * 首页类别管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=clientService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		clients=clientService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=clientService.getTotalCount(con,convalue,status,publicaccount);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
//		String paccount=client.getPublicaccount();
//		
//		if(picture!=null){
//			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
//			this.upload(imageName);
//			client.setImage(paccount+"/"+imageName);
//			
//		}
		clientService.add(client);
		
//		arg[0]="clientAction!list?publicaccount="+paccount;
//		arg[1]="首页类别管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
//		Pubclient pubclient = (Pubclient)session.get("pubclient");
//		if(pubclient==null){
//			String errorInfo="会话失效，请重新登录";
//			request.put("errorInfo", errorInfo);
//			return "operror";
//		}
//		String paccount=pubclient.getPublicaccount();
//		Client client=clientService.loadById(id);
//		//删除图片
//		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+client.getImage());
//		photofile.delete();
		clientService.delete(client);
		
//		arg[0]="clientAction!list?publicaccount="+paccount;
//		arg[1]="首页类别管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
//		String paccount=client.getPublicaccount();
//		
//		if(picture!=null){
//			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
//			this.upload(imageName);
//			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+client.getImage());
//			photofile.delete();
//			client.setImage(paccount+"/"+imageName);
//			
//		}
		clientService.update(client);
//		arg[0]="clientAction!list?publicaccount="+paccount;
//		arg[1]="首页类别管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		client=clientService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		client=clientService.loadById(id);
		return "load";
	}
	
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
//	//文件上传
//	public void upload(String imageName) throws Exception{
//		String floderName=((Pubclient)session.get("pubclient")).getPublicaccount();
//		File saved=new File(ServletActionContext.getServletContext().getRealPath(floderName),imageName);
//		InputStream ins=null;
//		OutputStream ous=null;
//		try {
//			saved.getParentFile().mkdirs();
//			ins=new FileInputStream(picture);
//			ous=new FileOutputStream(saved);
//			byte[] b=new byte[1024];
//			int len = 0;
//			while((len=ins.read(b))!=-1){
//				ous.write(b,0,len);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if(ous!=null)
//				ous.close();
//			if(ins!=null) 
//				ins.close();
//		}
//	}
	
	//get、set-------------------------------------------
	public IClientService getClientService() {
		return clientService;
	}
	@Resource
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
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
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public String getConvalue() {
		return convalue;
	}
	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	public String getPublicaccount() {
		return publicaccount;
	}
	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

}
