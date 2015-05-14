package protocpl;

import org.apache.mina.core.session.IoSession;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class SunTimeCmdFactory extends CmdFactoryBase implements ICmdParser{

	public SunTimeCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_TIME;
	}
	
	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		//this.m_oData
		if(this.m_oData[7]==0){
			Upload_SunTimeHead(session,this.m_oData);
		}else if(this.m_oData[7]==1){
			Upload_SunTimeTail(session,this.m_oData);
		}
		return false;
	}

	private void Upload_SunTimeTail(IoSession session, byte[] data) {
		// TODO Auto-generated method stub
		
	}

	private void Upload_SunTimeHead(IoSession session, byte[] data) {
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