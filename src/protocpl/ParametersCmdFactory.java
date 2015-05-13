package protocpl;

import java.util.Date;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.action.SigAction;



public class ParametersCmdFactory extends CmdFactoryBase implements ICmdParser{

	public static boolean setSuccess;
	public ParametersCmdFactory(byte[] data){
		super(data);
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_PARAMETERS;
		//DataCacheFactory.Init();
	}
	
	@Override
	public void Process(IoSession session, CommandBase cmd){
	//	System.out.println("cmd.getCmdType() is "+cmd.getCmdType() +"this.expected_cmd is "+this.expected_cmd);
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
		
		System.out.println("the 6 is"+this.m_oData[6]+"the 7 is"+this.m_oData[7]);
		
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
		
		int Red_Clearance_Time	 	= data[11];
		int Yellow_Flash_Time 		= data[12];
		int number 					= data[13];
		int comparam				= data[15];
		int checkflow 				= data[16];
		int innermark				= data[17];
		int Workingset 				= data[18];
		int SigSun 					= data[19];
		int SigSunTime[] 			= new int[7];
		for (int i = 0; i < SigSunTime.length; i++) {
			SigSunTime[i] 			= SigSun&((int)Math.pow(2,i));
		}
		int gmintime 				= data[26];
		int gmaxtime 				= data[27];
		int zdbctime 				= data[28];
		
		int xrfxtime 				= data[42];
		int cycle 					= data[43];			
		int  xyxr 					= data[44];
		int SigSpecialTime[][] 		= new int[24][2];
		for( int j =0 ;j < 24;j++){
			SigSpecialTime[j][0] 	= data[58+j*2] ;
			SigSpecialTime[j][1] 	= data[58+j*2+1] ;
		}
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		
	}
	
}
