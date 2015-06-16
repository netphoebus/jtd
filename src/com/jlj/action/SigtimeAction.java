package com.jlj.action;

import java.net.InetSocketAddress;
import java.util.ArrayList;
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

import com.jlj.model.Commontime;
import com.jlj.model.Issuedcommand;
import com.jlj.model.Road;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Solution;
import com.jlj.model.Step;
import com.jlj.service.ICommontimeService;
import com.jlj.service.IIssuedcommandService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;
import com.jlj.util.Commands;
import com.jlj.vo.CommontimeVO;
import com.jlj.vo.StepTimeVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("sigtimeAction")
@Scope("prototype")
public class SigtimeAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private ISigService sigService;
	private ICommontimeService commontimeService;
	private ISolutionService solutionService;
	private ISignpublicparamService publicparamService;
	private IStepService stepService;
	private IIssuedcommandService issuedcommandService;

	private List<Commontime> commontimes;
	private List<CommontimeVO> commontimeVOs;
	private List<Solution> solutions;
	private List<Step> steps;
	private List<StepTimeVO> steptimes;

	private Sig sig;
	private Commontime commontime;
	private int orderid;
	private int timetype;
	private Solution solution;
	private Signpublicparam publicparam;
	private int soid;
	private int signid;
	private String sigIp;
	private String map;

	public String sigtimes() {
		sigIp = (String) session.get("sigIp");
		if (sigIp == null) {
			return "opsessiongo";
		}
		setURLParameter();
		sig = sigService.querySigByIpAddress(sigIp);
		if (sig != null) {
			commontimes = commontimeService.getCommontimesBySigAndTimetype(sig
					.getId(), timetype);// 直接获得当前所有时间段
			// 查询当前信号机中所有的相位方案
			// publicparam = publicparamService.getPublicparamByIp(sigIp);
			solutions = solutionService.getSolutionsBySignidOrder(sig.getId());
		}
		if (commontimes.size() > 0) {

			setCommontimeVOs(commontimes);
			commontime = getCurrentCommontime();
			if(commontime!=null)
			{
				steps = getCurrentSolution();
				setCurrentSteptimes(commontime, steps);
			}
			session.put("sigIp", sigIp);// 从地图中进入信号机，将信号机id传入session
			return "cssz-time";
		} else {
			return "error";// 预留没有查询到相应公共参数时跳转的提示页面
		}
	}

	private void setCurrentSteptimes(Commontime commontime, List<Step> steps) {
		// TODO Auto-generated method stub
		steptimes = new ArrayList<StepTimeVO>();
		for (int i = 0; i < steps.size(); i++) {
			StepTimeVO steptime = new StepTimeVO();
			switch (i) {
			case 0:
				steptime.setStepname("0");
				steptime.setSecond(commontime.getT0());
				break;
			case 1:
				steptime.setStepname("1");
				steptime.setSecond(commontime.getT1());
				break;
			case 2:
				steptime.setStepname("2");
				steptime.setSecond(commontime.getT2());
				break;
			case 3:
				steptime.setStepname("3");
				steptime.setSecond(commontime.getT3());
				break;
			case 4:
				steptime.setStepname("4");
				steptime.setSecond(commontime.getT4());
				break;
			case 5:
				steptime.setStepname("5");
				steptime.setSecond(commontime.getT5());
				break;
			case 6:
				steptime.setStepname("6");
				steptime.setSecond(commontime.getT6());
				break;
			case 7:
				steptime.setStepname("7");
				steptime.setSecond(commontime.getT7());
				break;
			case 8:
				steptime.setStepname("8");
				steptime.setSecond(commontime.getT8());
				break;
			case 9:
				steptime.setStepname("9");
				steptime.setSecond(commontime.getT9());
				break;
			case 10:
				steptime.setStepname("10");
				steptime.setSecond(commontime.getT10());
				break;
			case 11:
				steptime.setStepname("11");
				steptime.setSecond(commontime.getT11());
				break;
			case 12:
				steptime.setStepname("12");
				steptime.setSecond(commontime.getT12());
				break;
			case 13:
				steptime.setStepname("13");
				steptime.setSecond(commontime.getT13());
				break;
			case 14:
				steptime.setStepname("14");
				steptime.setSecond(commontime.getT14());
				break;
			case 15:
				steptime.setStepname("15");
				steptime.setSecond(commontime.getT15());
				break;
			case 16:
				steptime.setStepname("16");
				steptime.setSecond(commontime.getT16());
				break;
			case 17:
				steptime.setStepname("17");
				steptime.setSecond(commontime.getT17());
				break;
			case 18:
				steptime.setStepname("18");
				steptime.setSecond(commontime.getT18());
				break;
			case 19:
				steptime.setStepname("19");
				steptime.setSecond(commontime.getT19());
				break;
			case 20:
				steptime.setStepname("20");
				steptime.setSecond(commontime.getT20());
				break;
			case 21:
				steptime.setStepname("21");
				steptime.setSecond(commontime.getT21());
				break;
			case 22:
				steptime.setStepname("22");
				steptime.setSecond(commontime.getT22());
				break;
			case 23:
				steptime.setStepname("23");
				steptime.setSecond(commontime.getT23());
				break;
			case 24:
				steptime.setStepname("24");
				steptime.setSecond(commontime.getT24());
				break;
			case 25:
				steptime.setStepname("25");
				steptime.setSecond(commontime.getT25());
				break;
			case 26:
				steptime.setStepname("26");
				steptime.setSecond(commontime.getT26());
				break;
			case 27:
				steptime.setStepname("27");
				steptime.setSecond(commontime.getT27());
				break;
			case 28:
				steptime.setStepname("28");
				steptime.setSecond(commontime.getT28());
				break;
			case 29:
				steptime.setStepname("29");
				steptime.setSecond(commontime.getT29());
				break;
			case 30:
				steptime.setStepname("30");
				steptime.setSecond(commontime.getT30());
				break;
			case 31:
				steptime.setStepname("31");
				steptime.setSecond(commontime.getT31());
				break;
			default:
				break;
			}
			steptime.setId(steps.get(i).getId());
			steptime.setRoads(steps.get(i).getRoads());
			steptimes.add(steptime);
		}
	}

	// 设置从url链接中传过来的参数
	public void setURLParameter() {
		if (req.getParameter("timetype") != null) {
			timetype = Integer.parseInt(req.getParameter("timetype"));// 获得前台的时间类型
		}
		if (req.getParameter("orderid") != null) {
			orderid = Integer.parseInt(req.getParameter("orderid"));// 获得前台的时间段id
		}
		if (req.getParameter("soid") != null) {
			soid = Integer.parseInt(req.getParameter("soid"));// 获得前台sid
		}
		if (req.getParameter("signid") != null) {
			signid = Integer.parseInt(req.getParameter("signid"));// 获得前台sid
		}
		if (req.getParameter("dates") != null) {
			map = req.getParameter("dates");// 获得前台sid
		}else
		{
			map = " ,";
		}
	}

	/**
	 * 前台显示部分方法 1、select获得所有时间段名称和orderId 2、获得当前显示的commontime 3、获得当前的solution
	 */
	private List<CommontimeVO> setCommontimeVOs(List<Commontime> commontimes) {
		commontimeVOs = new ArrayList<CommontimeVO>();
		for (Commontime time : commontimes) {
			commontimeVOs.add(new CommontimeVO(time.getOrderid(), "时间段" + time.getOrderid()));
		}
		return commontimeVOs;
	}

	public Commontime getCurrentCommontime() {
		commontime = commontimeService.loadByOrderIdAndTimetype(timetype,orderid,sig
				.getId());
		return commontime;
	}

	public List<Step> getCurrentSolution() {
		if (soid == 0) {
			solution = solutionService.loadById(commontime.getWorkingprogram() + 1);// 相位方案0对应数据库中的id=1
		} else {
			solution = solutionService.loadById(soid);
		}
		return steps = stepService.loadBySoId(solution.getId());
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
		System.out.println("update1-获取界面数据，更新数据库--------------------------------");
		// 修改数据库
		
		commontimeService.update(commontime);
		System.out.println("update2-获取数据库数据，下发命令--------------------------------");
		// 下发信号机 时间段参数
		sigIp = (String) session.get("sigIp");
		this.updateCommonTimeBytes(this.getCurrrenSession(sigIp));
		System.out.println("update3-调阅新命令和新数据，更新数据库--------------------------------");
		Commands.executeCommand(6,this.getCurrrenSession(sigIp));//commontime 编号6
		Thread.sleep(100);
		Commands.executeCommand(7,this.getCurrrenSession(sigIp));//commontime 编号7
		return NONE;
	}

	public String updateStepTimes() throws Exception {
		System.out.println("updateStepTimes1-获取界面数据，更新数据库--------------------------------");
		setURLParameter();
		commontime = commontimeService.loadByOrderIdAndTimetype(orderid,timetype,signid);
			
		// 需要插入数据库 解析 map-from jlj
		System.out.println(map);
		/**
		 * map数组元素解释说明 2_0:45[解释 id步序_t0: 执行时间]
		 */
		// 修改数据库中commontime中的时间t0-t31中的字段值-from jlj
		String[] steptimes = map.split(",");
//		System.out.println("----------------------整个字符串的长度="+steptimes.length);
		for (int i = 0; i < steptimes.length; i++) {
			String thissteptime = steptimes[i];
			String methodname = thissteptime.substring(thissteptime.indexOf("_")+1, thissteptime.indexOf(":"));
			int second = Integer.parseInt(thissteptime.substring(thissteptime.indexOf(":")+1));
			commontimeService.updateCommontimeSecond(methodname,second,orderid,timetype,signid);
		}
		
		System.out.println("updateStepTimes2-获取数据库数据，下发命令--------------------------------");
		// 下发信号机 步序执行时间
		sigIp = (String) session.get("sigIp");
		this.updateCommonTimeBytes(this.getCurrrenSession(sigIp));
		
		System.out.println("updateStepTimes3-调阅新命令和新数据，更新数据库--------------------------------");
		Commands.executeCommand(6,this.getCurrrenSession(sigIp));//commontime 编号6
		Thread.sleep(100);
		Commands.executeCommand(7,this.getCurrrenSession(sigIp));//commontime 编号7
		return NONE;
	}

	
	private void updateCommonTimeBytes(IoSession currrenSession) {
		//下发信号机  commontime参数
		if(commontime!=null){
			System.out.println("updateCommonTimeBytes commontime datas 1 datas================"+commontime.getId());
			//0-获取新数据
			int i = commontime.getOrderid();//修改的循环当中的序号head是0-7;tail是8-15
			int hour = commontime.getHour();//(int)data[10+i*40]
			int minute = commontime.getMinute();//(int)data[11+i*40]
			int seconds = commontime.getSeconds();//(int)data[12+i*40]
			int workingway = commontime.getWorkingway();//(int)data[13+i*40]
			int workingprogram = commontime.getWorkingprogram();//(int)data[14+i*40]
			int lstime = commontime.getLstime();//(int)data[15+i*40]
			int hdtime = commontime.getHdtime();//(int)data[16+i*40]
			int qchdtime = commontime.getQchdtime();//(int)data[17+i*40]
			Integer[] worktime = commontime.getTimes();//worktime[]
			
			//1-获取数据库中保存的命令
			Sig sig1 = sigService.querySigByIpAddress(sigIp);
			if(sig1==null){
				return;
			}
			String datastr1 ="";
			if(i<8){
				Issuedcommand issued1 = issuedcommandService.loadBySigidAndNumber(sig1.getId(),6);//根据sigip和number确定唯一命令
				System.out.println("updateCommonTimeBytes commontime datas 1 datas================"+issued1.getDatas());
				if(issued1!=null){
					datastr1 = issued1.getDatas();
				}
			}else if(i>7&&i<16){
				Issuedcommand issued2 = issuedcommandService.loadBySigidAndNumber(sig1.getId(),7);
				System.out.println("updateCommonTimeBytes commontime datas 2 datas================"+issued2.getDatas());
				if(issued2!=null){
					datastr1 = issued2.getDatas();
				}
			}
			System.out.println("datastr2="+datastr1);
			byte[] msendDatas = DataConvertor.decode(datastr1,332);
			
			switch(commontime.getTimetype()){
				case 1:
					msendDatas[6] = (byte)0x83 ;
					break;
				case 2:
					msendDatas[6] = (byte)0x84;
					break;
				case 3:
					msendDatas[6] = (byte)0x85;
					break;
			}
			
			
			msendDatas[7]=i<8?(byte) (0x00):(byte) (0x01);
			
			for (int j = 0; j < 8; j++) {
				msendDatas[10+i*40] = (byte) hour;
				msendDatas[11+i*40] = (byte) minute;
				msendDatas[12+i*40] = (byte) seconds;
				msendDatas[13+i*40] = (byte) workingway;
				msendDatas[14+i*40] = (byte) workingprogram;
				msendDatas[15+i*40] = (byte) lstime;
				msendDatas[16+i*40] = (byte) hdtime;
				msendDatas[17+i*40] = (byte) qchdtime;
				
				for (int j2 = 0; j2 < 32; j2++) {
					msendDatas[18+j2+i*40] = worktime[i].byteValue();
				}
			}
			
			 int k = 0;
			 for( int i1 = 4; i1 < msendDatas.length-2; i1++){
				 //System.out.println((msendDatas[i]&0xFF)+"对应"+msendDatas[i]);
				//System.out.println();
			  k += msendDatas[i1]&0xFF;
			 }
			 
		 
	         
		       for (int i2 = 0; i2 < 2; i2++) {  
		    	   msendDatas[msendDatas.length-i2-1]  = (byte) (k >>> (i2 * 8));  
		       }  
			
			System.out.println("=======================时间段参数下发========================================");
			
			for (int i3 = 0; i3 < msendDatas.length; i3++) {
				System.out.print(msendDatas[i3]);
			}
			System.out.println("");
			System.out.println("========================时间段参数下发=======================================");
			
			currrenSession.write(msendDatas);
		
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

	public ICommontimeService getCommontimeService() {
		return commontimeService;
	}

	@Resource
	public void setCommontimeService(ICommontimeService commontimeService) {
		this.commontimeService = commontimeService;
	}

	public List<Commontime> getCommontimes() {
		return commontimes;
	}

	public void setCommontimes(List<Commontime> commontimes) {
		this.commontimes = commontimes;
	}

	public Commontime getCommontime() {
		return commontime;
	}

	public void setCommontime(Commontime commontime) {
		this.commontime = commontime;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getTimetype() {
		return timetype;
	}

	public void setTimetype(int timetype) {
		this.timetype = timetype;
	}

	public List<CommontimeVO> getCommontimesVO() {
		return commontimeVOs;
	}

	public void setCommontimesVO(List<CommontimeVO> commontimeVOs) {
		this.commontimeVOs = commontimeVOs;
	}

	

	public ISolutionService getSolutionService() {
		return solutionService;
	}

	@Resource
	public void setSolutionService(ISolutionService solutionService) {
		this.solutionService = solutionService;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public ISignpublicparamService getPublicparamService() {
		return publicparamService;
	}

	@Resource
	public void setPublicparamService(ISignpublicparamService publicparamService) {
		this.publicparamService = publicparamService;
	}

	public Signpublicparam getPublicparam() {
		return publicparam;
	}

	public void setPublicparam(Signpublicparam publicparam) {
		this.publicparam = publicparam;
	}

	public int getSoid() {
		return soid;
	}

	public void setSoid(int soid) {
		this.soid = soid;
	}

	public IStepService getStepService() {
		return stepService;
	}

	@Resource
	public void setStepService(IStepService stepService) {
		this.stepService = stepService;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public String getSigIp() {
		return sigIp;
	}

	public void setSigIp(String sigIp) {
		this.sigIp = sigIp;
	}

	public List<StepTimeVO> getSteptimes() {
		return steptimes;
	}

	public void setSteptimes(List<StepTimeVO> steptimes) {
		this.steptimes = steptimes;
	}
	
	
	public IIssuedcommandService getIssuedcommandService() {
		return issuedcommandService;
	}

	@Resource
	public void setIssuedcommandService(IIssuedcommandService issuedcommandService) {
		this.issuedcommandService = issuedcommandService;
	}

	public int getSignid() {
		return signid;
	}

	public void setSignid(int signid) {
		this.signid = signid;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	
}
