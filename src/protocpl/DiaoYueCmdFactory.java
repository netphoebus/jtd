package protocpl;

import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.action.SigAction;
import com.jlj.model.Devlog;
import com.jlj.model.Issuedcommand;
import com.jlj.model.Sig;
import com.jlj.service.ICommontimeService;
import com.jlj.service.IDevlogService;
import com.jlj.service.IIssuedcommandService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;

public class DiaoYueCmdFactory extends CmdFactoryBase implements ICmdParser{
	final static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	final static ISignpublicparamService signpublicparamService = (ISignpublicparamService)ac.getBean("signpublicparamService");
	final static ISigService sigService = (ISigService)ac.getBean("sigService");
	final static ICommontimeService commontimeService = (ICommontimeService)ac.getBean("commontimeService");
	final static ISolutionService solutionService = (ISolutionService)ac.getBean("solutionService");
	final static IStepService stepService = (IStepService)ac.getBean("stepService");
	final static IIssuedcommandService issuedcommandService = (IIssuedcommandService)ac.getBean("issuedcommandService");
	final static IDevlogService devlogService = (IDevlogService)ac.getBean("devlogService");
	private int locate[][];
	private int Countdown[];
	public DiaoYueCmdFactory(byte[] data) {
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
			

//			String Reply_cmd = "FF FF FF FF 01 F0 9F 00 00 08 01 98";
//			String[] cmds = Reply_cmd.split(" ");
//	        byte[] aaa = new byte[cmds.length];
//	        int i = 0;
//	        for (String b : cmds) {
//	            if (b.equals("FF")) {
//	                aaa[i++] = -1;
//	            } else {
//	                aaa[i++] = Integer.valueOf(b, 16).byteValue();;
//	            }
//	        }
//	        session.write(IoBuffer.wrap(aaa));
			
			OnAfter_Ack(session, cmd);
			
		}
		
	}
	
	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub		
		if(this.m_oData[7]==0){	
			upload_RealTimeStatus(this.m_oData,session);
		}else if(this.m_oData[7] == 1){
			upload_Localtime(this.m_oData,session);
		}else if(this.m_oData[7] == 2){
			upload_Malfunction(this.m_oData,session);
		}
		return false;
	}
	
	private void send_ack(IoSession session){
		String Reply_cmd = "FF FF FF FF 01 F0 9F 00 00 08 01 98";
		String[] cmds = Reply_cmd.split(" ");
        byte[] aaa = new byte[cmds.length];
        int i = 0;
        for (String b : cmds) {
            if (b.equals("FF")) {
                aaa[i++] = -1;
            } else {
                aaa[i++] = Integer.valueOf(b, 16).byteValue();;
            }
        }
        session.write(IoBuffer.wrap(aaa));
	}
	//上传故障
	private void upload_Malfunction(byte[] data, IoSession session) {
		// TODO Auto-generated method stub
		send_ack(session);
        	int error = data[10]>>7;        //如果大于0 发生故障   等于0 排除故障
        if(error>0){
        	int year = (data[10]&0x7F);     //  年
	        int mounth = data[11];
	        int day = data[12];
	        int hour = data[13];
	        int minute = data[14];
	        int secound = data[15];	        
	        int error_code = data[16]; 
        	String time = year+"-"+mounth+"-"+day+" "+hour+":"+minute+":"+secound;
        	//获取session中的IP
    		String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
    		Sig sig = sigService.querySigByIpAddress(clientIP);
        	
        	
    		if(sig!=null){
    			
            	try {
            		//录入故障日志
                	Devlog devlog = new Devlog();
                	devlog.setSig(sig);
                	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date errorDate = sdf.parse(time);
					devlog.setDevtime(errorDate);
					devlog.setDevevent("故障代码"+error_code);
					devlogService.add(devlog);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	//修改当前信号机故障状态以及故障代码
    			int sigStatus = 1;
    			sigService.updateSigStatus(sigStatus,error_code,sig.getId());
    		}
        }
	}
	//校时
	private void upload_Localtime(byte[] data, IoSession session) {
		// TODO Auto-generated method stub
		send_ack(session);
//        //获取信号机数据
//        int year = data[10];
//        int mounth = data[11];
//        int day = data[12];
//        int week = data[13];
//        int hour = data[14];
//        int minute = data[15];
//        int secound = data[16];
        
      //获取session中的IP
		String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		Sig sig = sigService.querySigByIpAddress(clientIP);
		
		//保存信号机的公共参数下发命令的数据-start-from jlj
		String datastr = DataConvertor.toHexString(data);
		System.out.println("校时--------------------datastr="+datastr);
			//根据ip查出信号机
			if(sig!=null){
				Issuedcommand issuedcommand = issuedcommandService.loadBySigidAndNumber(sig.getId(),28);
				if(issuedcommand==null){
					issuedcommand = new Issuedcommand();
					issuedcommand.setName("校时");
					issuedcommand.setDatas(datastr);
					issuedcommand.setNumber(28);//编号28
					issuedcommand.setSig(sig);
					try {
						issuedcommandService.add(issuedcommand);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					issuedcommandService.updateObjectById(datastr,issuedcommand.getId());
				}
				
			
			}
			
		//保存信号机的公共参数下发命令的数据-end-from jlj
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
	  		if((data[i*2+10]&0x80)>0){
	  			locate[i][0] = 3;              
	  		}else if((data[i*2+10]&0x40)>0){
	  			locate[i][0] = 2;
	  		}else if((data[i*2+10]&0x20)>0){
	  			locate[i][0] = 1;
	  		}else{
	  			locate[i][0] = 0;
	  		}
	  		
	  		if((data[i*2+10]&0x10)>0){
	  			locate[i][1] = 3;
	  		}else if((data[i*2+10]&0x08)>0){
	  			locate[i][1] = 2;
	  		}else if((data[i*2+10]&0x04)>0){
	  			locate[i][1] = 1;
	  		}else{
	  			locate[i][1] = 0;
	  		}
	  		
	  		if((data[i*2+11]&0x80)>0){
	  			locate[i][2] = 3;
	  		}else if((data[i*2+11]&0x40)>0){
	  			locate[i][2] = 2;
	  		}else if((data[i*2+11]&0x20)>0){
	  			locate[i][2] = 1;
	  		}else{
	  			locate[i][2] = 0;
	  		}
	  		
	  		if((data[i*2+11]&0x10)>0){
	  			locate[i][3] = 3;
	  		}else if((data[i*2+11]&0x08)>0){
	  			locate[i][3] = 1;
	  		}else{
	  			locate[i][3] = 0;
	  		}
	  		
	  		if((data[i*2+11]&0x04)>0){
	  			locate[i][4] = 3;
	  		}else if((data[i*2+11]&0x02)>0){
	  			locate[i][4] = 1;
	  		}else{
	  			locate[i][4] = 0;
	  		}
	  	}
	  		
	  		for(int j=0;j<4;j++)
	  			Countdown[j]=data[27+8+j];
	  		
	  	
	  	int date[] = new int[7];
	  	for(int i=0;i<7;i++){
	  		date[i] = data[29+i];
	  	}
	  	                
	  		
	  	System.out.println("本地时间是"+date[1]+"年"+date[2]+"月"+date[3]+"日"+date[4]+"时"+date[5]+"分"+date[6]+"秒"+"星期"+date[0]);
	  	
	  	
	  	String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
	  	if(SigAction.curruntSigIp !=  null)
	  	if(clientIP.equals(SigAction.curruntSigIp )){
	  		SigAction.trafficlights = locate;
	  		SigAction.Countdown = Countdown;
	  	}
	  	
	  }
	
}
