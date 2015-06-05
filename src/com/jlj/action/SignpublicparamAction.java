package com.jlj.action;

import java.net.InetSocketAddress;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mina.DataConvertor;
import mina.TimeServerHandler;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Issuedcommand;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.service.IIssuedcommandService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.opensymphony.xwork2.ActionSupport;

@Component("sigpublicparamAction")
@Scope("prototype")
public class SignpublicparamAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	
	private ISigService sigService;
	private ISignpublicparamService sigpubparamService;
	private IIssuedcommandService issuedcommandService;
	
	private Signpublicparam sigpubparam;
	private Sig sig;
	private int sigpubid;//信号机公共参数Id
	private String sigIp;//信号机IP
	
	private Integer spetimeable;
	private Integer suntimeable;
	
	//跳转 一般参数页面  
	public String publicParam() {
		sigIp = (String) session.get("sigIp");
		if(sigIp==null){
			return "opsessiongo";
		}
		//根据IP来查询信号机公共参数
		sigpubparam = sigpubparamService.loadBySigIp(sigIp);
		if(sigpubparam!=null&&sigpubparam.getIp()!=null)
		{
			//判断信号机公共参数中的signid是否为空，如果为空则设置公共参数中的signid对应sig
			if(sigpubparam.getSig()==null)
			{
				sig = sigService.querySigByIpAddress(sigIp);
				sigpubparam.setSig(sig);
				sigpubparamService.update(sigpubparam);//公共参数中设置信号机id
			}
			session.put("sigIp", sigIp);//从地图中进入信号机，将信号机ip传入session
			initPublicParamJSP(sigpubparam.getWorkingset());
			//判断是否首次进入一般参数,如果首次进入一般参数则需设置公共参数中的signid对应sig
			return "cssz-cs";
		}else
		{
			return "error";//预留没有查询到相应公共参数时跳转的提示页面
		}
				
	}
	
	//工作日设置处理
	private void initPublicParamJSP(int workingset)
	{

		switch(workingset)
		{
			case 0:
				spetimeable = 0;
				suntimeable = 0;
				break;
			case 1:
				spetimeable = 1;
				suntimeable = 0;
				break;
			case 2:
				spetimeable = 0;
				suntimeable = 1;
				break;
			case 3:
				spetimeable = 1;
				suntimeable = 1;
				break;
			default:
				spetimeable = 0;
				suntimeable = 0;
					
		}
		
	}

	
	
	//处理一般参数jsp显示
	private void setPublicParamJSP()
	{
		//行人请求处理
		if(sigpubparam.getXyxr()==null)
		{
			sigpubparam.setXyxr(0);
		}
		//工作日设置处理
		if(spetimeable==null)
		{
			spetimeable = 0;
		}
		if(suntimeable==null)
		{
			suntimeable = 0;
		}
		if(spetimeable==1&&suntimeable==1)
		{
			sigpubparam.setWorkingset(3);
		}
		if(spetimeable==1&&suntimeable!=1)
		{
			sigpubparam.setWorkingset(2);
		}
		if(spetimeable!=1&&suntimeable==1)
		{
			sigpubparam.setWorkingset(1);
		}
		if(spetimeable!=1&&suntimeable!=1)
		{
			sigpubparam.setWorkingset(0);
		}
		
		//周日 处理
		if(sigpubparam.getMon()==null)
		{
			sigpubparam.setMon(0);
		}
		if(sigpubparam.getTue()==null)
		{
			sigpubparam.setTue(0);
		}
		if(sigpubparam.getWes()==null)
		{
			sigpubparam.setWes(0);
		}
		if(sigpubparam.getThir()==null)
		{
			sigpubparam.setThir(0);
		}
		if(sigpubparam.getFra()==null)
		{
			sigpubparam.setFra(0);
		}
		if(sigpubparam.getSata()==null)
		{
			sigpubparam.setSata(0);
		}
		if(sigpubparam.getSun()==null)
		{
			sigpubparam.setSun(0);
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
		System.out.println(suntimeable);
		System.out.println(spetimeable);
		setPublicParamJSP();
		
		
		
		//下发信号机公共参数-from sl
		sigIp = (String) session.get("sigIp");
		if(sigIp==null){
			return "opsessiongo";
		}
		sigpubparamService.update(sigpubparam);//修改-from lq
	//	updateSigPublicparamBytes(sigIp,getCurrrenSession(sigIp));
		
		return NONE;
	}
	
	private void updateSigPublicparamBytes(String sigIp,IoSession currrenSession) {
		Sig sig1 = sigService.querySigByIpAddress(sigIp);
		if(sig1!=null){
			Issuedcommand issuedcommand = issuedcommandService.loadBySigidAndNumber(sig1.getId(),5);//编号5
			System.out.println("SigPublicparam datas-----------------------="+issuedcommand.getDatas());

			if(issuedcommand!=null){
//				int Red_Clearance_Time	 	= data[11];
//				int Yellow_Flash_Time 		= data[12];
//				int number 					= data[13];
//				int comparam				= data[15];
//				int checkflow 				= data[16];
//				int innermark				= data[17];
//				int Workingset 				= data[18];
//				int SigSun 					= data[19];
//				int SigSunTime[] 			= new int[7];
//				for (int i = 0; i < SigSunTime.length; i++) {
//					SigSunTime[i] 			= SigSun&((int)Math.pow(2,i));
//				}
//				int gmintime 				= data[26];
//				int gmaxtime 				= data[27];
//				int zdbctime 				= data[28];
//				int countdownmode			= data[29];
//				int xrfxtime 				= data[42];
//				int cycle 					= data[43];			
//				int  xyxr 					= data[44];
//				int SigSpecialTime[][] 		= new int[24][2];
//				for( int j =0 ;j < 24;j++){
//					SigSpecialTime[j][0] 	= data[58+j*2] ;
//					SigSpecialTime[j][1] 	= data[58+j*2+1] ;
//				}
				//0-获取新数据
				int qchdtime = sigpubparam.getQchdtime();//清场红灯Red_Clearance_Time//data[11]
				int kjhstime = sigpubparam.getKjhstime();//开机黄闪Yellow_Flash_Time//data[12]
				String number = sigpubparam.getNumber();//number//data[13]
				String comparam = sigpubparam.getComparam();//comparam//data[15]
				int checkflow = sigpubparam.getCheckflow();//checkflow//data[16]
				String innermark = sigpubparam.getInnermark();//innermark//data[17]
				int workingset = sigpubparam.getWorkingset();//Workingset//data[18]
				
				Integer[] days = sigpubparam.getDays();//SigSunTime[]
				int gmintime = sigpubparam.getGmintime();//gmintime//data[26]
				int gmaxtime = sigpubparam.getGmaxtime();//gmaxtime//data[27]
				int zdbctime = sigpubparam.getZdbctime();//zdbctime//data[28]
				int countdownmode = sigpubparam.getCountdownmode();//countdownmode//data[29]
				int xrfxtime = sigpubparam.getXrfxtime();//xrfxtime//data[42]
				int cycle = sigpubparam.getCycle();//cycle//data[43]
				int xyxr = sigpubparam.getXyxr();//xyxr//data[44]
				Integer[] getSpecialmonths = sigpubparam.getSpecialmonths();//SigSpecialTime[][]
				Integer[] specialdays = sigpubparam.getSpecialdays();//SigSpecialTime[][]
				
				//1-获取数据库中保存的命令
				String datastr= issuedcommand.getDatas();//普通参数-原始命令
				System.out.println("datastr="+datastr);
				
				//2-获取的新数据，包装成新命令，并修改数据库“命令表issuedCommand”-from jlj
				
				byte[] msendDatas = DataConvertor.decode(datastr,140);
				
				msendDatas[6] = (byte) 0x82;
				msendDatas[7] = (byte) 0x01;
				msendDatas[11] = (byte)qchdtime;
				msendDatas[12] = (byte)kjhstime;
				msendDatas[13] = Byte.parseByte(number, 16);
				msendDatas[15] = Byte.parseByte(comparam, 16);
				msendDatas[16] = (byte)checkflow;
				//msendDatas[17] = Byte.parseByte(innermark, 16);
				msendDatas[17] = (byte)workingset;
				for (int i = 0; i < 7; i++) {
					msendDatas[18] |= days[i]<<(6-i);
				}
				
				msendDatas[26] = (byte) gmintime;
				msendDatas[27] = (byte) gmaxtime;
				msendDatas[28] = (byte) zdbctime;
				msendDatas[29] = (byte) countdownmode;
				msendDatas[30] = (byte) xrfxtime;
				msendDatas[31] = (byte) cycle;
				msendDatas[32] = (byte) xyxr;
				
				for( int j =0 ;j < 24;j++){
					msendDatas[58+j*2]   =	getSpecialmonths[j].byteValue();
					msendDatas[58+j*2+1] = specialdays[j].byteValue() ;
				}
				
				 int k = 0;
				 for( int i = 4; i < msendDatas.length-2; i++){
					 //System.out.println((msendDatas[i]&0xFF)+"对应"+msendDatas[i]);
					//System.out.println();
				  k += msendDatas[i]&0xFF;
				 }
				 
			 
		         
			       for (int i = 0; i < 2; i++) {  
			    	   msendDatas[msendDatas.length-i-1]  = (byte) (k >>> (i * 8));  
			       }  
				
				System.out.println("=======================公共参数下发========================================");
				
				for (int i = 0; i < msendDatas.length; i++) {
					System.out.print(msendDatas[i]);
				}
				System.out.println("");
				System.out.println("========================公共参数下发=======================================");
				//String s = msendDatas + "";
				
				System.out.println("the  send str is"+DataConvertor.bytesToHexString(msendDatas));
				
				String newdatastr = DataConvertor.toHexString(msendDatas);
				issuedcommandService.updateObjectById(newdatastr, issuedcommand.getId());
				//3-命令下发-需改-from sl
				currrenSession.write(IoBuffer.wrap(msendDatas));
			}
		}
		
		
		
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
	
	public void setMsgToSig()
	{
		
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

	public ISigService getSigService() {
		return sigService;
	}

	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}


	public ISignpublicparamService getSigpubparamService() {
		return sigpubparamService;
	}

	@Resource
	public void setSigpubparamService(ISignpublicparamService sigpubparamService) {
		this.sigpubparamService = sigpubparamService;
	}


	public Signpublicparam getSigpubparam() {
		return sigpubparam;
	}


	public void setSigpubparam(Signpublicparam sigpubparam) {
		this.sigpubparam = sigpubparam;
	}

	public int getSpetimeable() {
		return spetimeable;
	}

	public void setSpetimeable(int spetimeable) {
		this.spetimeable = spetimeable;
	}

	public int getSuntimeable() {
		return suntimeable;
	}

	public void setSuntimeable(int suntimeable) {
		this.suntimeable = suntimeable;
	}

	public String getSigIp() {
		return sigIp;
	}

	public void setSigIp(String sigIp) {
		this.sigIp = sigIp;
	}

	public int getSigpubid() {
		return sigpubid;
	}

	public void setSigpubid(int sigpubid) {
		this.sigpubid = sigpubid;
	}

	public IIssuedcommandService getIssuedcommandService() {
		return issuedcommandService;
	}

	@Resource
	public void setIssuedcommandService(IIssuedcommandService issuedcommandService) {
		this.issuedcommandService = issuedcommandService;
	}
	
	
}
