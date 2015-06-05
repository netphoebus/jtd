package com.jlj.action;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mina.DataConvertor;
import mina.TimeServerHandler;

import org.apache.mina.core.session.IoSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Greenconflict;
import com.jlj.model.Issuedcommand;
import com.jlj.model.Road;
import com.jlj.model.Sig;
import com.jlj.model.Solution;
import com.jlj.model.Step;
import com.jlj.service.IGreenconflictService;
import com.jlj.service.IIssuedcommandService;
import com.jlj.service.ISigService;
import com.opensymphony.xwork2.ActionSupport;

@Component("greenAction")
@Scope("prototype")
public class GreenconflictAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private IGreenconflictService greenService;
	private ISigService sigService;
	private IIssuedcommandService issuedcommandService;
	
	private List<Greenconflict> greens;

	private Sig sig;
	private String sigIp;
	
	public String green()
	{
		sigIp = (String) session.get("sigIp");
		if(sigIp==null){
			return "opsessiongo";
		}
		sig = sigService.querySigByIpAddress(sigIp);
		if(sig!=null)
		{
			greens = greenService.loadBySid(sig.getId());
		}
		if(greens!=null&&greens.size()>0)
		{
			session.put("sigIp", sigIp);//从地图中进入信号机，将信号机id传入session
			return "cssz-ct";
		}else
		{
			return "error";//预留没有查询到相应公共参数时跳转的提示页面
		}
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
		System.out.println("================");
		String map = req.getParameter("dates");
		//需要插入数据库 解析 map-from jlj
		System.out.println(map);
		/**
		 * map数组元素解释说明
		 * 16_02: 1[解释 id_方向灯: 冲突]
		 * 16  [解释 id(绿冲突表id]
		 * 02  东右[方向(0:东-》西,1:南-》北,2:西-》东][0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道]
		 * : 
		 * 1  [1:冲突 0：不冲突]
		 */
		String[] greens = map.split(",");
		for (int i = 0; i < greens.length; i++) {
			String green = greens[i];
			int gid = Integer.parseInt(green.substring(0, green.indexOf("_")));
			String name = green.substring(green.indexOf("_")+1,green.indexOf(":"));
			int isct = Integer.parseInt(green.substring(green.indexOf(":")+1));
			System.out.println(isct+"\t"+name+"\t"+gid);
			greenService.updateGreenByCondition(isct,name,gid);
		}
		
		
		
		
		//下发
		sigIp = (String) session.get("sigIp");
		this.updateGreenconflictBytes(sigIp,this.getCurrrenSession(sigIp));
		
		return NONE;
	}

	private void updateGreenconflictBytes(String sigIp,IoSession currrenSession) {
		//下发信号机-绿冲突表
		List<Greenconflict> greens = greenService.getGreensByIpAddress(sigIp);
		
		//1-获取数据库中保存的命令
		Sig sig1 = sigService.querySigByIpAddress(sigIp);
		if(sig1==null){
			return;
		}
		Issuedcommand issued1 = issuedcommandService.loadBySigidAndNumber(sig1.getId(),35);//根据sigip和number确定唯一命令
		System.out.println("greenconflict datas-----------------------="+issued1.getDatas());
		String datastr1 ="";
		if(issued1!=null){
			datastr1 = issued1.getDatas();
		}
		System.out.println("datastr1="+datastr1);
		
		byte[] msendDatas = DataConvertor.decode(datastr1,256+12);
		
		msendDatas[6] = (byte) 0x82;   //报文头
		msendDatas[7] = (byte) 0x04;   //报文头
		
		if(greens!=null&&greens.size()==16){
			for (int i = 0; i < greens.size(); i++) {
				Greenconflict green1 = greens.get(i);
				msendDatas[10+i*16] = green1.getL00().byteValue();//conflict[i][0];
				msendDatas[11+i*16] = green1.getL00().byteValue();//conflict[i][1];
				msendDatas[12+i*16] = green1.getL00().byteValue();//conflict[i][2];
				msendDatas[13+i*16] = green1.getL00().byteValue();//conflict[i][3];
				msendDatas[14+i*16] = green1.getL00().byteValue();//conflict[i][4];
				msendDatas[15+i*16] = green1.getL00().byteValue();//conflict[i][5];
				msendDatas[16+i*16] = green1.getL00().byteValue();//conflict[i][6];
				msendDatas[17+i*16] = green1.getL00().byteValue();//conflict[i][7];
				msendDatas[18+i*16] = green1.getL00().byteValue();//conflict[i][8];
				msendDatas[19+i*16] = green1.getL00().byteValue();//conflict[i][9];
				msendDatas[20+i*16] = green1.getL00().byteValue();//conflict[i][10];
				msendDatas[21+i*16] = green1.getL00().byteValue();//conflict[i][11];
				msendDatas[22+i*16] = green1.getL00().byteValue();//conflict[i][12];
				msendDatas[23+i*16] = green1.getL00().byteValue();//conflict[i][13];
				msendDatas[24+i*16] = green1.getL00().byteValue();//conflict[i][14];
				msendDatas[25+i*16] = green1.getL00().byteValue();//conflict[i][15];
				
				
				
			}
		}
		
			int k = 0;
			for( int i = 4; i < 256+12-2; i++){
				k += msendDatas[i]&0xFF;
			}
		
			for (int i = 0; i < 2; i++) {  
	    	   msendDatas[msendDatas.length-i-1]  = (byte) (k >>> (i * 8));  
	       } 
		 
			System.out.println("=========================绿冲突表下发======================================");
			
			for (int i = 0; i < msendDatas.length; i++) {
				System.out.print(msendDatas[i]);
			}
			System.out.println("");
			System.out.println("=========================绿冲突表下发======================================");
			
		 
		//2-获取的新数据，包装成新命令，并修改数据库“命令表issuedCommand”-from jlj
		
		
		//3-命令下发-需改-from sl
		currrenSession.write(msendDatas);
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


	public IGreenconflictService getGreenService() {
		return greenService;
	}

	@Resource
	public void setGreenService(IGreenconflictService greenService) {
		this.greenService = greenService;
	}

	public List<Greenconflict> getGreens() {
		return greens;
	}

	public void setGreens(List<Greenconflict> greens) {
		this.greens = greens;
	}
	public ISigService getSigService() {
		return sigService;
	}
	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}
	public String getSigIp() {
		return sigIp;
	}
	public void setSigIp(String sigIp) {
		this.sigIp = sigIp;
	}
	public IIssuedcommandService getIssuedcommandService() {
		return issuedcommandService;
	}
	@Resource
	public void setIssuedcommandService(IIssuedcommandService issuedcommandService) {
		this.issuedcommandService = issuedcommandService;
	}
	
	
	
}
