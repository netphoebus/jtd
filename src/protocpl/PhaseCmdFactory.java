package protocpl;

import java.util.ArrayList;

import org.apache.mina.core.session.IoSession;

import com.jlj.model.Phase;
import com.jlj.model.Road;
import com.jlj.model.Step;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class PhaseCmdFactory extends CmdFactoryBase implements ICmdParser{

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
		
		for(int step_i = 0;step_i<64;step_i++){
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
