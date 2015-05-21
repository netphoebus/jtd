package protocpl;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.model.Road;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Solution;
import com.jlj.model.Step;
import com.jlj.service.IRoadService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;

public class PhaseCmdFactory extends CmdFactoryBase implements ICmdParser{
	final static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	final static ISignpublicparamService signpublicparamService = (ISignpublicparamService)ac.getBean("signpublicparamService");
	final static ISolutionService solutionService = (ISolutionService)ac.getBean("solutionService");
	final static IStepService stepService = (IStepService)ac.getBean("stepService");
	final static IRoadService roadService = (IRoadService)ac.getBean("roadService");
	public PhaseCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_PHASE;
	}
	
	@Override
	public void Process(IoSession session, CommandBase cmd){
		System.out.println("cmd.getCmdType() is "+cmd.getCmdType() +"this.expected_cmd is "+this.expected_cmd);
		if(cmd.getCmdType() == this.expected_cmd)
		{
				
			OnAfter_Ack(session, cmd);
			
		}
		
	}
	
	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		//this.m_oData
		if(this.m_oData[7]==0){
			Upload_fault(session,this.m_oData);
		}else if(this.m_oData[7]==1){
			Upload_parameters(session,this.m_oData);
		}else if(this.m_oData[7]==4){
			
		}
		return false;
	}

	public void UpdatePushTask() {
		// TODO Auto-generated method stub
		
	}

	public byte[] getSerialNum() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSerialNum(byte[] serial) {
		// TODO Auto-generated method stub
		
	}
	
	private void Upload_parameters(IoSession session,byte[] data){
		
		//data[7]  相位方案序号
	
		ArrayList<int[][]> locatelist = new ArrayList<int[][]>();
		
		for(int step_i = 0;step_i<16;step_i++){
			int locate[][] = new int[4][5];
			for(int i=0;i<4;i++){
		  		if((data[i*2+10+step_i*8]&0x80)>0){
		  			locate[i][0] = 3;              
		  		}else if((data[i*2+10+step_i*8]&0x40)>0){
		  			locate[i][0] = 2;
		  		}else if((data[i*2+10+step_i*8]&0x20)>0){
		  			locate[i][0] = 1;
		  		}else{
		  			locate[i][0] = 0;
		  		}
		  		
		  		if((data[i*2+10+step_i*8]&0x10)>0){
		  			locate[i][1] = 3;
		  		}else if((data[i*2+10+step_i*8]&0x08)>0){
		  			locate[i][1] = 2;
		  		}else if((data[i*2+10+step_i*8]&0x04)>0){
		  			locate[i][1] = 1;
		  		}else{
		  			locate[i][1] = 0;
		  		}
		  		
		  		if((data[i*2+11+step_i*8]&0x80)>0){
		  			locate[i][2] = 3;
		  		}else if((data[i*2+11+step_i*8]&0x40)>0){
		  			locate[i][2] = 2;
		  		}else if((data[i*2+11+step_i*8]&0x20)>0){
		  			locate[i][2] = 1;
		  		}else{
		  			locate[i][2] = 0;
		  		}
		  		
		  		if((data[i*2+11+step_i*8]&0x10)>0){
		  			locate[i][3] = 3;
		  		}else if((data[i*2+11+step_i*8]&0x08)>0){
		  			locate[i][3] = 1;
		  		}else{
		  			locate[i][3] = 0;
		  		}
		  		
		  		if((data[i*2+11+step_i*8]&0x04)>0){
		  			locate[i][4] = 3;
		  		}else if((data[i*2+11+step_i*8]&0x02)>0){
		  			locate[i][4] = 1;
		  		}else{
		  			locate[i][4] = 0;
		  		}
		  		
		  		locatelist.add(locate);
		  	}
			//---------------------数据库----------------------------
			//根据ip获取对应的公共参数，保存相位方案以及步序和方向（东南西北、左直右人人）
			//获取session中的IP
			String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
			Signpublicparam signpublicparam =signpublicparamService.getPublicparamByIp(clientIP);
			List<Solution> solutions = solutionService.getSolutionsByPublicidOrder(signpublicparam.getId());
			if(solutions==null||solutions.size()==0){
				for (int j = 0; j < locatelist.size(); j++) {
					Solution solution = new Solution();
					solution.setOrderid(j);
					solution.setSignpublicparam(signpublicparam);
					solution.setSoluname("相位方案"+j);
					try {
						solutionService.add(solution);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//保存该相位方案的所有相位步序
					for (int k = 0; k < 16; k++) {
						Step step = new Step();
						step.setOrderid(k);
						step.setPhasename("相位"+k/2);
						step.setStepname("步序"+k);
//						step.setSecond(second);//秒
						step.setSolution(solution);
						try {
							stepService.add(step);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//保存该相位步序下的所有方向
						for (int a = 0; a < 4; a++) {
							Road road = new Road();
							road.setLeftcolor(locatelist.get(j)[a][0]);
							road.setLinecolor(locatelist.get(j)[a][1]);
							road.setRightcolor(locatelist.get(j)[a][2]);
							road.setRxcolor(locatelist.get(j)[a][3]);
							road.setRoadtype(a);
							road.setStep(step);
							try {
								roadService.add(road);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}
			}else{
				//更新数据库
				for (int j = 0; j < locatelist.size(); j++) {
					String soluname="相位方案"+j;
					Solution solution = solutions.get(j);
					int soluid=0;
					if(solution!=null){
						soluid=solutions.get(j).getId();
					}
					
					solutionService.updateBySoluid(soluname,soluid);
					
					//保存该相位方案的所有相位步序
					for (int k = 0; k < 16; k++) {
						int orderid=k;
						String phasename="相位"+k/2;
						String stepname="步序"+k;
						int stepid=0;
						Step step = stepService.queryStepBySoluid(orderid,soluid);
						stepService.updateByStepid(phasename,stepname,step.getId());
						
						//保存该相位步序下的所有方向
						for (int a = 0; a < 4; a++) {
							int leftcolor=locatelist.get(j)[a][0];
							int linecolor=locatelist.get(j)[a][1];
							int rightcolor=locatelist.get(j)[a][2];
							int rxcolor=locatelist.get(j)[a][3];
							int roadtype=a;
							roadService.updateByRoadid(leftcolor,linecolor,rightcolor,rxcolor,roadtype,step.getId());
						}
					}
					
				}
			}
			
			
//			for(int road_i = 0;road_i<4 ; road_i++){
//				Road road = new Road();
//				road.setRoadtype(road_i);
//				road.setLeftcolor(locate[road_i][0]);
//				road.setLinecolor(locate[road_i][1]);
//				road.setRightcolor(locate[road_i][2]);
//				road.setRxcolor(locate[road_i][3]);
//				
//			}
		}	
//		for(int step_i = 0;step_i<2;step_i++){
//			Step step = new Step();
//			step.setOrderid();
//			step.setStepname();
//		}
		
//		for( int phase_i = 0;phase_i<32;phase_i++){
//			Phase phase = new Phase();
//			phase.setOrderid(phase_i);
//			phase.setPhasename("相位"+phase_i);
//			
//			for(int step_i = 0;step_i<2;step_i++){
//				Step step = new Step();
//				step.setOrderid(phase_i*2+step_i);
//				step.setStepname("步序"+phase_i*2+step_i);
//			}
//			
//			phase.setSteps(steps)
//		}
		
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		
	}
	
	
}
