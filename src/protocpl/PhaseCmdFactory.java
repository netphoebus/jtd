package protocpl;

import org.apache.mina.core.session.IoSession;

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
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		
	}
	
	
}
