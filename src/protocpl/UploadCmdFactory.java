package protocpl;

import org.apache.mina.core.session.IoSession;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class UploadCmdFactory extends CmdFactoryBase implements ICmdParser{

	public UploadCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_UPLOAD;
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		super.Process(session, cmd);
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
		
		if(this.m_oData[7]==1){
			Upload_time(session,this.m_oData);
		}else if(this.m_oData[7]==2){
			Upload_fault(session,this.m_oData);
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
	
	private void Upload_time(IoSession session,byte[] data){
		int year;
		int month;
		int day;
		int weak;
		int hour;
		int minute;
		int second;
		
		// 对应data[10]开始 7个字节
		
		
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		
	}
}
