package protocpl;

import java.net.InetSocketAddress;
import java.util.Date;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.action.SigAction;
import com.jlj.model.Flow;
import com.jlj.model.Sig;
import com.jlj.service.ICommontimeService;
import com.jlj.service.IDevlogService;
import com.jlj.service.IFlowService;
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
	final static IFlowService flowService = (IFlowService)ac.getBean("flowService");
	
	private int locate[][];
	private int Countdown[];
	private static int flag = 0;
	private static int flow_returnid;
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
	  	              
	  	
	  		
	  	System.out.println("本地时间是"+date[1]+"年"+date[2]+"月"+date[3]+"日"+date[4]+"时"+date[5]+"分"+date[6]+"秒"+"星期"+date[0]+"故障代码"+(data[41]&0x7f));
	  	System.out.println("东倒"+data[37]+"南倒"+data[38]+"西倒"+data[39]+"北倒"+data[40]);
	  	int flow = ((data[43]&0xff)<<24)+((data[44]&0xff)<<16)+((data[45]&0xff)<<8)+((data[46]&0xff));
	  	System.out.println("车道号"+data[42]+"流量是"+flow);
	  	
	  	String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
	  	if(SigAction.curruntSigIp !=  null)
	  	if(clientIP.equals(SigAction.curruntSigIp )){
	  		SigAction.trafficlights = locate;
	  		SigAction.Countdown = Countdown;
	  	}
	  	//0-计数器flag=1；判断器isnext=0；
	  	int isnext=0;
	  	//0:东左 1：东直 2：东右 3：南左 4：南直 5：南右 6：西左 7：西直 8:西右 9：北左 10：北直 11：北右
	  	int whichroad = data[42];
	  	if(whichroad<flag){
	  		isnext =1;
	  		flag = whichroad;
	  	}
	  	flag++;
	  	if(whichroad==11){
	  		flag=0;
	  	}
	  	
	  	//1-根据ip地址获取信号机id
	  	//2-根据sigid和车道号的编号插入车流量信息
	  	
	  	Sig sig = sigService.querySigByIpAddress(clientIP);
	  	if(sig!=null){
	  		if(isnext==1){
	  			//新插入记录
	  			Flow flowobj = new Flow();
	  			flowobj.setSig(sig);
	  			switch (whichroad) {
				case 0:
					flowobj.setDleft(flow);
					break;
				case 1:
					flowobj.setDline(flow);
					break;
				case 2:
					flowobj.setDright(flow);
					break;
				case 3:
					flowobj.setNleft(flow);
					break;
				case 4:
					flowobj.setNline(flow);
					break;
				case 5:
					flowobj.setNright(flow);
					break;
				case 6:
					flowobj.setXleft(flow);
					break;
				case 7:
					flowobj.setXline(flow);
					break;
				case 8:
					flowobj.setXright(flow);
					break;
				case 9:
					flowobj.setBleft(flow);
					break;
				case 10:
					flowobj.setBline(flow);
					break;
				case 11:
					flowobj.setBright(flow);
					break;
				default:
					break;
				}
	  			flowobj.setTime(new Date());
	  			try {
	  				flow_returnid = flowService.addReturn(flowobj);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  		}else{
	  			//更新记录
	  			String flowziduan="";
	  			switch (whichroad) {
				case 0:
					flowziduan="dleft";
					break;
				case 1:
					flowziduan="dline";
					break;
				case 2:
					flowziduan="dright";
					break;
				case 3:
					flowziduan="nleft";
					break;
				case 4:
					flowziduan="nline";
					break;
				case 5:
					flowziduan="nright";
					break;
				case 6:
					flowziduan="xleft";
					break;
				case 7:
					flowziduan="xline";
					break;
				case 8:
					flowziduan="xright";
					break;
				case 9:
					flowziduan="bleft";
					break;
				case 10:
					flowziduan="bline";
					break;
				case 11:
					flowziduan="bright";
					break;
				default:
					break;
				}
	  			flowService.updateFlowByCondition(flowziduan,flow,flow_returnid);
	  			
	  		}
	  	}
	  }
	
}
