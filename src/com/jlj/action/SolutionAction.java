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
	private IGreenconflictService greenService;
	
	private Solution solution;
	private List<Solution> solutions;
	private List<Step> steps;
	private List<Greenconflict> greens;
	private Signpublicparam sigpubparam;
	private int soid;
	private Sig sig;
	private ConflictVO conflictVO;//绿冲突表：实际有的冲突对象
	
	
	public String solutions()
	{
		conflictVO = getConflicts();
		solutions = solutionService.getSolutions();
		if(soid==0)
		{
			soid = 1;
		}
		req.setAttribute("soid", soid);
		solution = solutionService.loadById(soid);
		steps = stepService.loadBySoId(soid);//获得相位方案的相位（相位为步序是偶数位的步序,service层已做处理）
		
		if(solutions!=null)
		{
			return "cssz-fa";
		}else
		{
			return "error";//预留没有查询到相应公共参数时跳转的提示页面
		}
	}
	
	//获得冲突对象
	private ConflictVO getConflicts() {
		// TODO Auto-generated method stub
		greens = greenService.getGreenconflicts();
		if(greens.size()>0)
		{
			//for(Gr)
		}
		
		
		return conflictVO;
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
		 * 0  [方向(0:东-》西,1:南-》北,2:西-》东]
		 * 3  [0:左转灯,1: 直行灯 ,2:右转灯 ,3:人行道]
		 * : 
		 * 1  [3：红 2：黄 1：绿 0：灭 null：未知]
		 */
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

	public ConflictVO getConflictVO() {
		return conflictVO;
	}

	public void setConflictVO(ConflictVO conflictVO) {
		this.conflictVO = conflictVO;
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

	
	
	
	
}
