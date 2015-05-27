package com.jlj.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Greenconflict;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Solution;
import com.jlj.model.Step;
import com.jlj.service.IGreenconflictService;
import com.jlj.service.IRoadService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;
import com.jlj.vo.ConflictVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("solutionAction")
@Scope("prototype")
public class SolutionAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private ISigService sigService;
	private ISignpublicparamService sigpubparamService;
	private ISolutionService solutionService;
	private IStepService stepService;
	private IRoadService roadService;
	private IGreenconflictService greenService;
	
	private List<Solution> solutions;
	private List<Step> steps;
	private List<Greenconflict> greens;
	
	private Solution solution;
	private Signpublicparam sigpubparam;
	private int soid;
	private Sig sig;
	private ConflictVO conflictVO;
	private String sigIp;
	
	public String solutions()
	{
			sigIp = (String) session.get("sigIp");
			if(sigIp==null){
				return "opsessiongo";
			}
			sigpubparam = sigpubparamService.getPublicparamByIp(sigIp);
			if(sigpubparam!=null)
			{
				solutions = solutionService.loadByPubid(sigpubparam.getId());
			}
			if(solutions!=null&&solutions.size()>0)
			{
				if(soid==0)
				{
					soid = 1;
				}
				solution = solutionService.loadById(soid);
				steps = stepService.loadBySoId(soid);//获得相位方案的相位（相位为步序是偶数位的步序,service层已做处理）
				setGreenConflict();
				session.put("sigIp", sigIp);//从地图中进入信号机，将信号机id传入session
				return "cssz-fa";
			}else
			{
				return "error";//预留没有查询到相应公共参数时跳转的提示页面
			}
	}
	
	//获得绿冲突对象
	private void setGreenConflict() {
		greens = greenService.getGreenconflicts();
		if(greens!=null&&greens.size()==16)
		{
			conflictVO = new ConflictVO();
			for(int i=0;i<greens.size();i++)
			{
				String conflictname="";
				
				if(greens.get(i).getL00()!=null&&greens.get(i).getL00()==1)
				{
					conflictname = conflictname+"_0_0,";
				} if(greens.get(i).getL01()!=null&&greens.get(i).getL01()==1)
				{
					conflictname = conflictname+"_0_1,";
				} if(greens.get(i).getL02()!=null&&greens.get(i).getL02()==1)
				{
					conflictname = conflictname+"_0_2,";
				} if(greens.get(i).getL03()!=null&&greens.get(i).getL03()==1)
				{
					conflictname = conflictname+"_0_3,";
				} if(greens.get(i).getL10()!=null&&greens.get(i).getL10()==1)
				{
					conflictname = conflictname+"_1_0,";
				} if(greens.get(i).getL11()!=null&&greens.get(i).getL11()==1)
				{
					conflictname = conflictname+"_1_1,";
				} if(greens.get(i).getL12()!=null&&greens.get(i).getL12()==1)
				{
					conflictname = conflictname+"_1_2,";
				} if(greens.get(i).getL13()!=null&&greens.get(i).getL13()==1)
				{
					conflictname = conflictname+"_1_3,";
				} if(greens.get(i).getL20()!=null&&greens.get(i).getL20()==1)
				{
					conflictname = conflictname+"_2_0,";
				} if(greens.get(i).getL21()!=null&&greens.get(i).getL21()==1)
				{
					conflictname = conflictname+"_2_1,";
				} if(greens.get(i).getL22()!=null&&greens.get(i).getL22()==1)
				{
					conflictname = conflictname+"_2_2,";
				} if(greens.get(i).getL23()!=null&&greens.get(i).getL23()==1)
				{
					conflictname = conflictname+"_2_3,";
				} if(greens.get(i).getL30()!=null&&greens.get(i).getL30()==1)
				{
					conflictname = conflictname+"_3_0,";
				} if(greens.get(i).getL31()!=null&&greens.get(i).getL31()==1)
				{
					conflictname = conflictname+"_3_1,";
				} if(greens.get(i).getL32()!=null&&greens.get(i).getL32()==1)
				{
					conflictname = conflictname+"_3_2,";
				} if(greens.get(i).getL33()!=null&&greens.get(i).getL33()==1)
				{
					conflictname = conflictname+"_3_3,";
				}
				
				switch (i) {
				case 0:
					conflictVO.setC_00(conflictname);
					break;
				case 1:
					conflictVO.setC_01(conflictname);
					break;
				case 2:
					conflictVO.setC_02(conflictname);
					break;
				case 3:
					conflictVO.setC_03(conflictname);
					break;
				case 4:
					conflictVO.setC_10(conflictname);
					break;
				case 5:
					conflictVO.setC_11(conflictname);
					break;
				case 6:
					conflictVO.setC_12(conflictname);
					break;
				case 7:
					conflictVO.setC_13(conflictname);
					break;
				case 8:
					conflictVO.setC_20(conflictname);
					break;
				case 9:
					conflictVO.setC_21(conflictname);
					break;
				case 10:
					conflictVO.setC_22(conflictname);
					break;
				case 11:
					conflictVO.setC_23(conflictname);
					break;
				case 12:
					conflictVO.setC_30(conflictname);
					break;
				case 13:
					conflictVO.setC_31(conflictname);
					break;
				case 14:
					conflictVO.setC_32(conflictname);
					break;
				case 15:
					conflictVO.setC_33(conflictname);
					break;
				default:
					break;
				}
				
				
			}
			
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
		 * 4_0_3:1[解释 id_方向_灯: 灯色]
		 * 4  [解释 id(步序id都是偶数位)]
		 * 0  [方向(0:东-》西,1:南-》北,2:西-》东,3:北-》南]
		 * 3  [0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道]
		 * : 
		 * 1  [3：红 2：黄 1：绿 0：灭 null：未知]
		 */
		String[] solus = map.split(",");
		for (int i = 0; i < solus.length; i++) {
			int stepid= Integer.parseInt(solus[i].substring(0, solus[i].indexOf("_")));
			int roadtype = Integer.parseInt(solus[i].substring(solus[i].indexOf("_")+1, solus[i].lastIndexOf("_")));
			int dengtype = Integer.parseInt(solus[i].substring(solus[i].lastIndexOf("_")+1, solus[i].indexOf(":")));
			String dengtypestr="";
			switch (dengtype) {
			case 0:
				dengtypestr = "leftcolor";
				break;
			case 1:
				dengtypestr = "linecolor";
				break;
			case 2:
				dengtypestr = "rightcolor";
				break;
			case 3:
				dengtypestr = "rxcolor";
				break;
			default:
				break;
			}
			int deng = Integer.parseInt(solus[i].substring(solus[i].indexOf(":")+1));
			System.out.println("stepid="+stepid+",fangxiang="+roadtype+",dengtype="+dengtype+",deng="+deng);
			roadService.updateByCondition(deng,dengtypestr, roadtype, stepid);
		}
		
		
		//下发信号机  相位解决方案-from sl
		return NONE;
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

	
	public int getSoid() {
		return soid;
	}

	public void setSoid(int soid) {
		this.soid = soid;
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

	public ISolutionService getSolutionService() {
		return solutionService;
	}
	@Resource
	public void setSolutionService(ISolutionService solutionService) {
		this.solutionService = solutionService;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public List<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
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

	public ConflictVO getConflictVO() {
		return conflictVO;
	}

	public void setConflictVO(ConflictVO conflictVO) {
		this.conflictVO = conflictVO;
	}


	public IRoadService getRoadService() {
		return roadService;
	}

	@Resource
	public void setRoadService(IRoadService roadService) {
		this.roadService = roadService;
	}

	public String getSigIp() {
		return sigIp;
	}

	public void setSigIp(String sigIp) {
		this.sigIp = sigIp;
	}

	
	
	
}
