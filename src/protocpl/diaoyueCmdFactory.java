package protocpl;

import java.net.InetSocketAddress;

import org.apache.mina.core.session.IoSession;

import com.jlj.action.SigAction;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class diaoyueCmdFactory extends CmdFactoryBase implements ICmdParser{

	private int locate[][];
	private int Countdown[];
	public diaoyueCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_DIAOYUE;
		locate = new int[4][5];
		Countdown = new int[4];
	}
	
	@Override
	public void Process(IoSession session, CommandBase cmd){
		//System.out.println("cmd.getCmdType() is "+cmd.getCmdType() +"this.expected_cmd is "+this.expected_cmd);
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
		upload_RealTimeStatus(this.m_oData,session);
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
	
	 public void upload_RealTimeStatus(byte[] data,IoSession session){
		 
	  		
	  		for(int i=0;i<4;i++){
	  		if((data[i*2+8]&0x80)>0){
	  			locate[i][0] = 3;              
	  		}else if((data[i*2+8]&0x40)>0){
	  			locate[i][0] = 2;
	  		}else if((data[i*2+8]&0x20)>0){
	  			locate[i][0] = 1;
	  		}else{
	  			locate[i][0] = 0;
	  		}
	  		
	  		if((data[i*2+8]&0x10)>0){
	  			locate[i][1] = 3;
	  		}else if((data[i*2+8]&0x08)>0){
	  			locate[i][1] = 2;
	  		}else if((data[i*2+8]&0x04)>0){
	  			locate[i][1] = 1;
	  		}else{
	  			locate[i][1] = 0;
	  		}
	  		
	  		if((data[i*2+9]&0x80)>0){
	  			locate[i][2] = 3;
	  		}else if((data[i*2+9]&0x40)>0){
	  			locate[i][2] = 2;
	  		}else if((data[i*2+9]&0x20)>0){
	  			locate[i][2] = 1;
	  		}else{
	  			locate[i][2] = 0;
	  		}
	  		
	  		if((data[i*2+9]&0x10)>0){
	  			locate[i][3] = 3;
	  		}else if((data[i*2+9]&0x08)>0){
	  			locate[i][3] = 1;
	  		}else{
	  			locate[i][3] = 0;
	  		}
	  		
	  		if((data[i*2+9]&0x04)>0){
	  			locate[i][4] = 3;
	  		}else if((data[i*2+9]&0x02)>0){
	  			locate[i][4] = 1;
	  		}else{
	  			locate[i][4] = 0;
	  		}
	  	}
	  		
	  		for(int j=0;j<4;j++)
	  			Countdown[j]=data[27+8+j];
	  		
	  	
	  	
	  	String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
	  	if(SigAction.curruntSigIp !=  null)
	  	if(clientIP.equals(SigAction.curruntSigIp )){
	  		SigAction.trafficlights = locate;
	  		SigAction.Countdown = Countdown;
	  	}
	  	
	  }
	
}
