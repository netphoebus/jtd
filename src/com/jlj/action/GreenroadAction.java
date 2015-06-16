package com.jlj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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

import com.jlj.model.Commontime;
import com.jlj.model.Greenroad;
import com.jlj.model.Sig;
import com.jlj.service.ICommontimeService;
import com.jlj.service.IGreenroadService;
import com.jlj.service.ISigService;
import com.jlj.vo.SigGreenRoadVO;
import com.jlj.vo.UsefulPhaseVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("greenroadAction")
@Scope("prototype")
public class GreenroadAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;

	private List<Greenroad> greenroads;
	private List<SigGreenRoadVO> sigVOs;
	private List<UsefulPhaseVO> phaseVOs;

	private IGreenroadService greenroadService;
	private ICommontimeService commontimeService;
	private ISigService sigService;

	private Greenroad greenroad;
	private Commontime commontime;
	private Sig sig;
	private SigGreenRoadVO sigVO;
	private int id;
	private Long mklid;
	private String smids;
	private int orderid;
	private int timetype;
	private int maxCircleTime;
	private String map;
	private String begintime;

	/**
	 * 地图加载绿波带
	 * 
	 * @throws Exception
	 */
	public String loadLines() throws Exception {

		greenroads = greenroadService.getAllGreenroads();
		if (greenroads != null && greenroads.size() > 0) {
			JSONArray jsonArr = JSONArray.fromObject(greenroads);
			System.out.println(jsonArr);
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
	public String add() throws Exception {
		return SUCCESS;
	}

	/**
	 * 绿波带地图页面新增 绿波带
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addOrUpdateLine() throws Exception {
		setURLParameter();
		greenroad = greenroadService.loadByMkid(mklid);
		if (greenroad != null) {
			// update
		} else {
			greenroad = new Greenroad();
			greenroad.setMarklineid(mklid);
			greenroad.setSigmids(smids);
			greenroadService.add(greenroad);
		}
		return NONE;
	}
	
	/**
	 * 跳转至绿波带设置时距图 页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String lbd() throws Exception {
		setURLParameter();
		greenroad = greenroadService.loadByMkid(mklid);
		if (greenroad != null) {
			setSigVOS(greenroad);
			maxCircleTime = setMaxCircle(sigVOs);
			return "lbd";
		} else {
			return "error";
		}

	}
	
	
	/**
	 * 时距图设置电缆联动和相位开始时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public String setPharseTime() throws Exception {
		setURLParameter();
		System.out.println(map+" "+begintime+" "+orderid+" "+timetype);
		int hour = 0;
		int minute = 0;
		int seconds = 0;
		int workingway =3;
		/**
		 * map数组元素解释说明 1:0[解释 sid信号机id: 开始时间]
		 * 开始时间是秒 90 120 或其他 
		 * 需处理 commontime :hour minute seconds  workingway 0表示普通控制方式，1表示黄闪，2表示关灯，3表示协调控制（绿波带），4表示感应控制，5表示中心控制，6未定义;
		 * 
		 */
		String[] sigctimes = map.split(",");
		for (int i = 0; i < sigctimes.length; i++) {
			String[] sig_time = sigctimes[i].split(":");
			int sid = Integer.parseInt(sig_time[0]);
			int add_second = Integer.parseInt(sig_time[1]);
			commontime = commontimeService.loadByOrderIdAndTimetype(timetype, orderid, sid);
			if(!begintime.equals("0")&&!begintime.equals("")&&begintime.length()>0&&begintime.indexOf(":")!=-1)
			{
				hour = Integer.parseInt(begintime.split(":")[0]);
				minute =  Integer.parseInt(begintime.split(":")[1]);
			}else
			{
				hour = commontime.getHour();
				minute = commontime.getMinute();
			}
			if(add_second>3600)
			{
				hour = hour + add_second/3600;
				minute = minute + add_second%60;
				seconds = seconds + add_second%3600;
			}else
			{
				minute = minute + add_second/60;
				seconds = seconds + add_second%60;
			}
			commontimeService.updateCommontime(hour,minute,seconds,workingway,orderid,timetype,sid);
		}
		// 下发信号机 时间段参数
		return NONE;
	}
	
	/**
	 * 设置最大周期
	 * @param sigVOs2
	 * @return
	 */
	private int setMaxCircle(List<SigGreenRoadVO> sigs) {
		// TODO Auto-generated method stub
		List<Integer> circles = new ArrayList<Integer>();
		int max = 0;
		if(sigs!=null&&sigs.size()>0)
		{
			for(SigGreenRoadVO sig:sigs)
			{
				circles.add(sig.getCircleTime());
			}
			max = Collections.max(circles);
		}
		return max;
	}

	/**
	 * 设置sigVOs 运输类
	 * @param greenroad
	 */
	private void setSigVOS(Greenroad greenroad) {
		sigVOs = new ArrayList<SigGreenRoadVO>();
		String[] mkids = greenroad.getSigmids().split(",");
		for (int i = 0; i < mkids.length; i++) {
			sig = sigService.loadByMkid(Long.parseLong(mkids[i]));
			if (sig != null) {
				sigVO = new SigGreenRoadVO();
				sigVO.setId(sig.getId());
				sigVO.setName(sig.getName());
				commontime = commontimeService.loadByOrderIdAndTimetype(
						timetype, orderid, sig.getId());
				if (commontime != null) {
					
					sigVO = setCurrentSigVOParam(sigVO);//设置 单个sigVO的复杂属性
				}
				sigVOs.add(sigVO);
			}
		}
	}

	/**
	 * 设置sigVO对象
	 * 包括（周期:circleRealTime,可用相位:phaseVOs,可用相位所占比例:pharsePros）
	 * @param sigVO
	 * @return
	 */
	private SigGreenRoadVO setCurrentSigVOParam(SigGreenRoadVO sigVO) {
		// TODO Auto-generated method stub
		List<UsefulPhaseVO> phaseVOs = new ArrayList<UsefulPhaseVO>();//设置sigVO对象中的可用相位
		List<String> pharsePros = new ArrayList<String>();//设置可用相位相位比例 (注：为了前台显示时距图时所有比例都要使用到)
		int circleRealTime = 0;
		
		String phaseString = commontime.getT0() + "," + commontime.getT1()
				+ "," + commontime.getT2() + "," + commontime.getT3() + ","
				+ commontime.getT4() + "," + commontime.getT5() + ","
				+ commontime.getT6() + "," + commontime.getT7() + ","
				+ commontime.getT8() + "," + commontime.getT9() + ","
				+ commontime.getT10() + "," + commontime.getT11() + ","
				+ commontime.getT12() + "," + commontime.getT13() + ","
				+ commontime.getT14() + "," + commontime.getT15() + ","
				+ commontime.getT16() + "," + commontime.getT17() + ","
				+ commontime.getT18() + "," + commontime.getT19() + ","
				+ commontime.getT20() + "," + commontime.getT21() + ","
				+ commontime.getT22() + "," + commontime.getT23() + ","
				+ commontime.getT24() + "," + commontime.getT25() + ","
				+ commontime.getT26() + "," + commontime.getT27() + ","
				+ commontime.getT28() + "," + commontime.getT29() + ","
				+ commontime.getT30() + "," + commontime.getT31();

		if (phaseString.substring(0, 1) != null
				&& !phaseString.substring(0, 1).equals("0")) {
			int firstIndex = phaseString.indexOf(",0");
			if (firstIndex != -1) {
				phaseString = phaseString.substring(0, firstIndex);
			}
			String[] usefulPhase = phaseString.split(",");

			circleRealTime = calculateCircleTime(commontime, usefulPhase.length);// 当前的相位周期

			for (int i = 0; i < usefulPhase.length; i++) {
				UsefulPhaseVO phaseVO = new UsefulPhaseVO();
				DecimalFormat df = new DecimalFormat("######0.00");
				double pro = getNowPro(i, circleRealTime, commontime);
				System.out.println("所占比例为：" + df.format(pro));
				pharsePros.add(df.format(pro));
				phaseVO.setCirclePro(getNowPro(i, circleRealTime, commontime));
				phaseVO.setSigid_usefulpid(sigVO.getId() + "_" + i);//相位都是从0相位开始的
				phaseVO.setName("相位" + i);
				phaseVOs.add(phaseVO);
			}
		}
		sigVO.setCircleTime(circleRealTime);
		sigVO.setUsefulPhases(phaseVOs);
		sigVO.setPharsePros(pharsePros);
		return sigVO;
	}

	

	
	/**
	 * 获得当前相位所占比例
	 * @param i
	 * @param circleRealTime
	 * @param commontime
	 * @return
	 */
	private double getNowPro(int i, int circleRealTime, Commontime commontime) {
		double pharseTime = commontime.getHdtime() + commontime.getQchdtime();
		switch (i) {
		case 0:
			pharseTime = pharseTime + commontime.getT0();
			break;
		case 1:
			pharseTime = pharseTime + commontime.getT1();
			break;
		case 2:
			pharseTime = pharseTime + commontime.getT2();
			break;
		case 3:
			pharseTime = pharseTime + commontime.getT3();
			break;
		case 4:
			pharseTime = pharseTime + commontime.getT4();
			break;
		case 5:
			pharseTime = pharseTime + commontime.getT5();
			break;
		case 6:
			pharseTime = pharseTime + commontime.getT6();
			break;
		case 7:
			pharseTime = pharseTime + commontime.getT7();
			break;
		case 8:
			pharseTime = pharseTime + commontime.getT8();
			break;
		case 9:
			pharseTime = pharseTime + commontime.getT9();
			break;
		case 10:
			pharseTime = pharseTime + commontime.getT10();
			break;
		case 11:
			pharseTime = pharseTime + commontime.getT11();
			break;
		case 12:
			pharseTime = pharseTime + commontime.getT12();
			break;
		case 13:
			pharseTime = pharseTime + commontime.getT13();
			break;
		case 14:
			pharseTime = pharseTime + commontime.getT14();
			break;
		case 15:
			pharseTime = pharseTime + commontime.getT15();
			break;
		case 16:
			pharseTime = pharseTime + commontime.getT16();
			break;
		case 17:
			pharseTime = pharseTime + commontime.getT17();
			break;
		case 18:
			pharseTime = pharseTime + commontime.getT18();
			break;
		case 19:
			pharseTime = pharseTime + commontime.getT19();
			break;
		case 20:
			pharseTime = pharseTime + commontime.getT20();
			break;
		case 21:
			pharseTime = pharseTime + commontime.getT21();
			break;
		case 22:
			pharseTime = pharseTime + commontime.getT22();
			break;
		case 23:
			pharseTime = pharseTime + commontime.getT23();
			break;
		case 24:
			pharseTime = pharseTime + commontime.getT24();
			break;
		case 25:
			pharseTime = pharseTime + commontime.getT25();
			break;
		case 26:
			pharseTime = pharseTime + commontime.getT26();
			break;
		case 27:
			pharseTime = pharseTime + commontime.getT27();
			break;
		case 28:
			pharseTime = pharseTime + commontime.getT28();
			break;
		case 29:
			pharseTime = pharseTime + commontime.getT29();
			break;
		case 30:
			pharseTime = pharseTime + commontime.getT30();
			break;
		case 31:
			pharseTime = pharseTime + commontime.getT31();
			break;
		default:
			break;
		}
		return pharseTime / circleRealTime;
	}

	/**
	 * 计算当前信号机在当前时间段的周期
	 * @param commontime
	 * @param length
	 * @return
	 */
	private int calculateCircleTime(Commontime commontime, int length) {

		int circleTime = commontime.getHdtime() * length
				+ commontime.getQchdtime() * length;
		switch (length) {
		case 1:
			circleTime = circleTime + commontime.getT0();
			break;
		case 2:
			circleTime = circleTime + commontime.getT0() + commontime.getT1();
			break;
		case 3:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2();
			break;
		case 4:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3();
			break;
		case 5:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4();
			break;
		case 6:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5();
			break;
		case 7:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6();
			break;
		case 8:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7();
			break;
		case 9:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8();
			break;
		case 10:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9();
			break;
		case 11:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10();
			break;
		case 12:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11();
			break;
		case 13:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12();
			break;
		case 14:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13();
			break;
		case 15:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14();
			break;
		case 16:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15();
			break;
		case 17:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16();
			break;
		case 18:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17();
			break;
		case 19:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18();
			break;
		case 20:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19();
			break;
		case 21:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20();
			break;
		case 22:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21();
			break;
		case 23:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22();
			break;
		case 24:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23();
			break;
		case 25:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24();
			break;
		case 26:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25();
			break;
		case 27:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26();
			break;
		case 28:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26() + commontime.getT27();
			break;
		case 29:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26() + commontime.getT27()
					+ commontime.getT28();
			break;
		case 30:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26() + commontime.getT27()
					+ commontime.getT28() + commontime.getT29();
			break;
		case 31:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26() + commontime.getT27()
					+ commontime.getT28() + commontime.getT29()
					+ commontime.getT30();
			break;
		case 32:
			circleTime = circleTime + commontime.getT0() + commontime.getT1()
					+ commontime.getT2() + commontime.getT3()
					+ commontime.getT4() + commontime.getT5()
					+ commontime.getT6() + commontime.getT7()
					+ commontime.getT8() + commontime.getT9()
					+ commontime.getT10() + commontime.getT11()
					+ commontime.getT12() + commontime.getT13()
					+ commontime.getT14() + commontime.getT15()
					+ commontime.getT16() + commontime.getT17()
					+ commontime.getT18() + commontime.getT19()
					+ commontime.getT20() + commontime.getT21()
					+ commontime.getT22() + commontime.getT23()
					+ commontime.getT24() + commontime.getT25()
					+ commontime.getT26() + commontime.getT27()
					+ commontime.getT28() + commontime.getT29()
					+ commontime.getT30() + commontime.getT31();
			break;

		default:
			break;
		}

		return circleTime;
	}

	

	/**
	 * 设置时距图完成后跳转至 时距图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String greenroad() throws Exception {
		return "greenroad";
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
		return SUCCESS;
	}

	/**
	 * 处理请求参数
	 * 
	 */
	private void setURLParameter() {
		if (req.getParameter("mklid") != null) {
			mklid = Long.parseLong(req.getParameter("mklid"));
		}
		if (req.getParameter("sids") != null) {
			smids = req.getParameter("sids");
		} else {
			smids = "";
		}
		if (req.getParameter("timetype") != null) {
			timetype = Integer.parseInt(req.getParameter("timetype"));// 获得前台的时间类型
		}
		if (req.getParameter("orderid") != null) {
			orderid = Integer.parseInt(req.getParameter("orderid"));// 获得前台的时间段id
		}
		if (req.getParameter("dates") != null) {
			map = req.getParameter("dates");// 获得前台sid
		}else
		{
			map = "";
		}
		if (req.getParameter("begintime") != null) {
			begintime = req.getParameter("begintime");// 获得前台sid
		}
	}

	/**
	 * 检查绿波带对象
	 * 
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

	public Greenroad getGreenroad() {
		return greenroad;
	}

	public void setGreenroad(Greenroad greenroad) {
		this.greenroad = greenroad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IGreenroadService getGreenroadService() {
		return greenroadService;
	}

	@Resource
	public void setGreenroadService(IGreenroadService greenroadService) {
		this.greenroadService = greenroadService;
	}

	public Long getMklid() {
		return mklid;
	}

	public void setMklid(Long mklid) {
		this.mklid = mklid;
	}

	public String getSmids() {
		return smids;
	}

	public void setSmids(String smids) {
		this.smids = smids;
	}

	public List<Greenroad> getGreenroads() {
		return greenroads;
	}

	public void setGreenroads(List<Greenroad> greenroads) {
		this.greenroads = greenroads;
	}

	public ICommontimeService getCommontimeService() {
		return commontimeService;
	}

	@Resource
	public void setCommontimeService(ICommontimeService commontimeService) {
		this.commontimeService = commontimeService;
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

	public List<SigGreenRoadVO> getSigVOs() {
		return sigVOs;
	}

	public void setSigVOs(List<SigGreenRoadVO> sigVOs) {
		this.sigVOs = sigVOs;
	}

	public List<UsefulPhaseVO> getPhaseVOs() {
		return phaseVOs;
	}

	public void setPhaseVOs(List<UsefulPhaseVO> phaseVOs) {
		this.phaseVOs = phaseVOs;
	}

	public ISigService getSigService() {
		return sigService;
	}

	@Resource
	public void setSigService(ISigService sigService) {
		this.sigService = sigService;
	}

	public Sig getSig() {
		return sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	public SigGreenRoadVO getSigVO() {
		return sigVO;
	}

	public void setSigVO(SigGreenRoadVO sigVO) {
		this.sigVO = sigVO;
	}

	public int getMaxCircleTime() {
		return maxCircleTime;
	}

	public void setMaxCircleTime(int maxCircleTime) {
		this.maxCircleTime = maxCircleTime;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	

	
	

}
