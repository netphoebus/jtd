package com.jlj.action;

import java.util.ArrayList;
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

import com.jlj.model.Commontime;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Solution;
import com.jlj.model.Step;
import com.jlj.service.ICommontimeService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;
import com.jlj.vo.CommontimeVO;
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

	private List<Commontime> commontimes;
	private List<CommontimeVO> commontimeVOs;
	private List<Solution> solutions;
	private List<Step> steps;

	private Sig sig;
	private Commontime commontime;
	private Integer timetype;
	private int timeid;
	private Solution solution;
	private Signpublicparam publicparam;
	private int soid;
	private String sigIp;

	public String sigtimes() {
		sigIp = (String) session.get("sigIp");
		if(sigIp==null){
			return "opsessiongo";
		}
		setURLParameter();
		sig = sigService.querySigByIpAddress(sigIp);
		if(sig!=null)
		{
			commontimes = commontimeService.getCommontimesBySigAndTimetype(sig.getId(),
					timetype);// 直接获得当前所有时间段
			// 查询当前信号机中所有的相位方案
			publicparam = publicparamService.getPublicparamByIp(sigIp);
			solutions = solutionService.getSolutionsByPublicidOrder(publicparam
					.getId());
		}
		if (commontimes.size() > 0) {
			setCommontimeVOs(commontimes);
			getCurrentCommontime();
			getCurrentSolution();

			session.put("sigIp", sigIp);// 从地图中进入信号机，将信号机id传入session
			return "cssz-time";
		} else {
			return "error";// 预留没有查询到相应公共参数时跳转的提示页面
		}
	}

	// 设置从url链接中传过来的参数
	public void setURLParameter() {
		if (req.getParameter("timetype") != null) {
			timetype = Integer.parseInt(req.getParameter("timetype"));// 获得前台的时间类型
		}
		if (req.getParameter("timeid") != null) {
			timeid = Integer.parseInt(req.getParameter("timeid"));// 获得前台的时间段id
		}
		if (req.getParameter("soid") != null) {
			soid = Integer.parseInt(req.getParameter("soid"));// 获得前台sid
		}
		// 处理时间类型
		if (timetype == null || timetype == 0) {
			timetype = 1;
		}
	}

	/**
	 * 前台显示部分方法 1、select获得所有时间段名称和id 2、获得当前显示的commontime 3、获得当前的solution
	 */
	private List<CommontimeVO> setCommontimeVOs(List<Commontime> commontimes) {
		commontimeVOs = new ArrayList<CommontimeVO>();
		int i = 0;
		for (Commontime time : commontimes) {
			commontimeVOs.add(new CommontimeVO(time.getId(), "时间段" + i++));
		}
		return commontimeVOs;
	}

	public void getCurrentCommontime() {
		// 获得当前时间段参数
		if (timeid == 0) {
			commontime = commontimes.get(0);
		} else {
			commontime = commontimeService.loadById(timeid);
		}
	}

	public void getCurrentSolution() {
		if (soid == 0) {
			solution = solutionService.loadById(commontime.getWorkingprogram() + 1);// 相位方案0对应数据库中的id=1
		} else {
			solution = solutionService.loadById(soid);
		}
		steps = stepService.loadBySoId(solution.getId());
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
		System.out.println("----------------------------update commontime------------------------------");
		//修改数据库
		commontimeService.update(commontime);
		//下发信号机  时间段参数 -from sl
		
		
		
		
		return NONE;
	}
	
	public String updateStepTimes() throws Exception {
		System.out.println("================");
		String map = req.getParameter("dates");
		//需要插入数据库 解析 map-from jlj
		System.out.println(map);
		/**
		 * map数组元素解释说明
		 * 50: 0[解释 id_步序: 执行时间]
		 */
		
		
		
		//下发信号机  步序执行时间  -from sl
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

	public void setTimetype(Integer timetype) {
		this.timetype = timetype;
	}

	public int getTimeid() {
		return timeid;
	}

	public void setTimeid(int timeid) {
		this.timeid = timeid;
	}

	public List<CommontimeVO> getCommontimesVO() {
		return commontimeVOs;
	}

	public void setCommontimesVO(List<CommontimeVO> commontimeVOs) {
		this.commontimeVOs = commontimeVOs;
	}

	public Integer getTimetype() {
		return timetype;
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
	
}
