package protocpl;

import org.apache.mina.core.session.IoSession;

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
		
	}

	private void Upload_CommonTimeHead(IoSession session, byte[] data) {
		// TODO Auto-generated method stub
		
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
