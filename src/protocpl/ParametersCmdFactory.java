package protocpl;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;

import org.apache.mina.core.session.IoSession;



public class ParametersCmdFactory extends CmdFactoryBase implements ICmdParser{

	public static String datas;
	public static boolean setSuccess;
	public ParametersCmdFactory(byte[] data){
		super(data);
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_PARAMETERS;
		//DataCacheFactory.Init();
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
	
	  public  void  setData(String data){
		  datas = data;
		  setSuccess = true;
		  //System.out.println(time_qingchanghongdeng+time_huangshan+tongxuncanshu+liuliangjiance+gongzuorishezhi+zhourishezhi+G_min+G_max);
	  }
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		//this.m_oData
		String data = DataConvertor.bytesToHexString(this.m_oData);
		System.out.println("the data is "+data);
		setData(data);
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
