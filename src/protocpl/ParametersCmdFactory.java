package protocpl;

import org.apache.mina.core.session.IoSession;



import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;



public class ParametersCmdFactory extends CmdFactoryBase implements ICmdParser{

	
	public ParametersCmdFactory(byte[] data){
		super(data);
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_PARAMETERS;
		//DataCacheFactory.Init();
	}
	
	@Override
	public void Process(IoSession session, CommandBase cmd){
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
		String data = DataConvertor.bytesToHexString(this.m_oData);
		System.out.println("the data is "+data);
		
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

}
