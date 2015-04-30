package protocpl;

import org.apache.mina.core.session.IoSession;

import com.jlj.action.SigAction;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class diaoyueCmdFactory extends CmdFactoryBase implements ICmdParser{

	private int locate[][];
	
	public diaoyueCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_DIAOYUE;
		locate = new int[4][5];
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
		
		upload_RealTimeStatus(data,session);
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
	
	 public void upload_RealTimeStatus(String data,IoSession session){
		  String temp[] = new String[8];
	  		
	  		for(int i=0;i<8;i++){
	  			temp[i] = data.substring(20+i*2, 22+i*2);;
	  		}
	  		
	  		for(int i=0;i<4;i++){
	  		if((DataConvertor.str2hex(temp[i*2])&0x80)>0){
	  			locate[i][0] = 3;              
	  		}else if((DataConvertor.str2hex(temp[i*2])&0x40)>0){
	  			locate[i][0] = 2;
	  		}else if((DataConvertor.str2hex(temp[i*2])&0x20)>0){
	  			locate[i][0] = 1;
	  		}else{
	  			locate[i][0] = 0;
	  		}
	  		
	  		if((DataConvertor.str2hex(temp[i*2])&0x10)>0){
	  			locate[i][1] = 3;
	  		}else if((DataConvertor.str2hex(temp[i*2])&0x08)>0){
	  			locate[i][1] = 2;
	  		}else if((DataConvertor.str2hex(temp[i*2])&0x04)>0){
	  			locate[i][1] = 1;
	  		}else{
	  			locate[i][1] = 0;
	  		}
	  		
	  		if((DataConvertor.str2hex(temp[i*2+1])&0x80)>0){
	  			locate[i][2] = 3;
	  		}else if((DataConvertor.str2hex(temp[i*2+1])&0x40)>0){
	  			locate[i][2] = 2;
	  		}else if((DataConvertor.str2hex(temp[i*2+1])&0x20)>0){
	  			locate[i][2] = 1;
	  		}else{
	  			locate[i][2] = 0;
	  		}
	  		
	  		if((DataConvertor.str2hex(temp[i*2+1])&0x10)>0){
	  			locate[i][3] = 3;
	  		}else if((DataConvertor.str2hex(temp[i*2+1])&0x08)>0){
	  			locate[i][3] = 1;
	  		}else{
	  			locate[i][3] = 0;
	  		}
	  		
	  		if((DataConvertor.str2hex(temp[i*2+1])&0x04)>0){
	  			locate[i][4] = 3;
	  		}else if((DataConvertor.str2hex(temp[i*2+1])&0x02)>0){
	  			locate[i][4] = 1;
	  		}else{
	  			locate[i][4] = 0;
	  		}
	  	}

	  	
	  	
	  //	System.out.println("the address is "+session.getRemoteAddress().toString()+"the select address is "+SigAction.getIp());
	  	if(SigAction.curruntSigIp !=  null)
	  	if(session.getRemoteAddress().toString().contains(SigAction.curruntSigIp )){
	  	//	System.out.println("enter !!!");
	  		SigAction.trafficlights = locate;
	  	}
	  	
	  	//
	  }
	
}
