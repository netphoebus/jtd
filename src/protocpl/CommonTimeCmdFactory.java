package protocpl;

import java.util.ArrayList;

import org.apache.mina.core.session.IoSession;

import com.jlj.model.Commontime;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class CommonTimeCmdFactory extends CmdFactoryBase implements ICmdParser{

	public CommonTimeCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_TIME;
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
			Upload_CommonTimeHead(session,this.m_oData);
		}else if(this.m_oData[7]==1){
			Upload_CommonTimeTail(session,this.m_oData);
		}
		return false;
	}

	private void Upload_CommonTimeTail(IoSession session, byte[] data) {
		// TODO Auto-generated method stub
		ArrayList<Commontime> commtimelist = new ArrayList<Commontime>();
		
		for(int i = 0;i<8;i++){
			Commontime commontime = new Commontime();
			commontime.setHour((int)data[10+i*40]);
			commontime.setMinute((int)data[11+i*40]);		
			commontime.setSeconds((int)data[12+i*40]);;
			commontime.setWorkingway((int)data[13+i*40]);
			commontime.setWorkingprogram((int)data[14+i*40]);
			commontime.setLstime((int)data[15+i*40]);
			commontime.setHdtime((int)data[16+i*40]);
			commontime.setQchdtime((int)data[17+i*40]) ;
			int worktime[] = new int[32];
			for(int j=0;j<32;j++){
				worktime[j] = data[18+j+i*40];
			}
			//commontime.setWorktime(worktime);
		//	commontime.setSolutions(solutions)
			commtimelist.add(commontime);
		}
	}

	private void Upload_CommonTimeHead(IoSession session, byte[] data) {
		// TODO Auto-generated method stub
		ArrayList<Commontime> commtimelist = new ArrayList<Commontime>();
		
		for(int i = 0;i<8;i++){
			Commontime commontime = new Commontime();
			commontime.setHour((int)data[10+i*40]);
			commontime.setMinute((int)data[11+i*40]);		
			commontime.setSeconds((int)data[12+i*40]);;
			commontime.setWorkingway((int)data[13+i*40]);
			commontime.setWorkingprogram((int)data[14+i*40]);
			commontime.setLstime((int)data[15+i*40]);
			commontime.setHdtime((int)data[16+i*40]);
			commontime.setQchdtime((int)data[17+i*40]) ;
			int worktime[] = new int[32];
			for(int j=0;j<32;j++){
				worktime[j] = data[18+j+i*40];
			}
			//commontime.setWorktime(worktime);
			commtimelist.add(commontime);
		}
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
}
	

