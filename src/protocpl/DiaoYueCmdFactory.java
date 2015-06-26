package protocpl;

import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.jlj.model.Userarea;
import com.jlj.service.ICommontimeService;
import com.jlj.service.IDevlogService;
import com.jlj.service.IFlowService;
import com.jlj.service.IIssuedcommandService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISolutionService;
import com.jlj.service.IStepService;
import com.jlj.service.IUserareaService;

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
	public final static IUserareaService userareaService = (IUserareaService)ac.getBean("userareaService");
	
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
	public void Process(IoSession session, CommandBase cmd) throws Exception{
		//System.out.println("cmd.getCmdType() is "+cmd.getCmdType() +"this.expected_cmd is "+this.expected_cmd);
		if(cmd.getCmdType() == this.expected_cmd)
		{
			
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
			
			OnAfter_Ack(session, cmd);
		}
		
	}
	
	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) throws Exception {
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
	
	 public void upload_RealTimeStatus(byte[] data,IoSession session) throws Exception{
		 
		 	int number = (data[4]&0xff<<8) + data[5]&0xff;
		 	Sig sig = sigService.querySigByNumber(number+"");
	  		if(session.getAttribute("indexJoinSQL")==null)
	  		{
	  		//	System.out.println("=========================================upload_RealTimeStatus number="+number);
	  			session.setAttribute("number",number+"");
	  			if(sig==null){
	  				sig = new Sig();
	  				sig.setIserror(0);
	  				sig.setNumber(number+"");
	  				Userarea userarea = userareaService.loadById(1);//load未知区域
	  				if(userarea==null){
	  					System.out.println("userarea=null--------------------");
	  				}
	  				sig.setUserarea(userarea);
	  				sigService.add(sig);
	  			}
	  			session.setAttribute("indexJoinSQL", 1);//控制进入次数
	  		}
		 
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
	  	/*//判断信号机时间和中心机时间是否相同,如果不同自动校时
	  	if(checkSigTime(date[1],date[2],date[3],date[4],date[5],date[6]))
	  	{
	  		byte[] msendDatas = new byte[20];
			msendDatas[0] = (byte) 0xff;
			msendDatas[1] = (byte) 0xff;
			msendDatas[2] = (byte) 0xff;
			msendDatas[3] = (byte) 0xff;
			msendDatas[4] = (byte) 0x01; //有问题
			msendDatas[5] = (byte) 0xf0; //有问题
			msendDatas[6] = (byte)0x81 ;
			msendDatas[7] = 0x00;
			msendDatas[8] = 0x00;
			msendDatas[9] = 0x10;
			Calendar nowdate = Calendar.getInstance();
				
			msendDatas[10] = (byte) (nowdate.get(Calendar.YEAR)%2000);
		    msendDatas[11] = (byte) (nowdate.get(Calendar.MONTH)+1);
		    msendDatas[12] = (byte) nowdate.get(Calendar.DAY_OF_MONTH);
		    if(nowdate.get(Calendar.DAY_OF_WEEK )<2){
		    	msendDatas[13] = 0x07;
		    }else if(nowdate.get(Calendar.DAY_OF_WEEK )>1){
		    	msendDatas[13] = (byte)( nowdate.get(Calendar.DAY_OF_WEEK)-1);
		    }
		    
		    msendDatas[14] = (byte) nowdate.get(Calendar.HOUR_OF_DAY);
		    msendDatas[15] = (byte) nowdate.get(Calendar.MINUTE);
		    msendDatas[16] = (byte) nowdate.get(Calendar.SECOND);
			
			System.out.println("本地时间是"+msendDatas[10]+"年"+msendDatas[11]+"月"+msendDatas[12]+"日"+msendDatas[14]+"时"+msendDatas[15]+"分"+msendDatas[16]+"秒"+"星期"+msendDatas[13]);
		    
		    int k = 0;
			 for( int i1 = 4; i1 < msendDatas.length-2; i1++){
				 //System.out.println((msendDatas[i]&0xFF)+"对应"+msendDatas[i]);
				//System.out.println();
			  k += msendDatas[i1]&0xFF;
			 }
			 
		       for (int i2 = 0; i2 < 2; i2++) {  
		    	   msendDatas[msendDatas.length-i2-1]  = (byte) (k >>> (i2 * 8));  
		       }  
			
			System.out.println("=======================校时下发========================================");
			
			for (int i3 = 0; i3 < msendDatas.length; i3++) {
				System.out.print(msendDatas[i3]);
			}
			System.out.println("");
			System.out.println("========================校时下发=======================================");
			
			//2-获取的新数据，包装成新命令，并修改数据库“命令表issuedCommand”-from jlj
			//3-命令下发-from sl
			session.write(IoBuffer.wrap(msendDatas));
	  	}*/
	  	//System.out.println("本地时间是"+date[1]+"年"+date[2]+"月"+date[3]+"日"+date[4]+"时"+date[5]+"分"+date[6]+"秒"+"星期"+date[0]+"故障代码"+(data[41]&0x7f));
	  	//System.out.println("东倒"+data[37]+"南倒"+data[38]+"西倒"+data[39]+"北倒"+data[40]);
	  	int flow = ((data[43]&0xff)<<24)+((data[44]&0xff)<<16)+((data[45]&0xff)<<8)+((data[46]&0xff));
	  	//System.out.println("车道号"+data[42]+"流量是"+flow);
	  	
//	  	String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
//	  	if(SigAction.curruntSigIp !=  null)
//	  	if(clientIP.equals(SigAction.curruntSigIp )){
//	  		SigAction.trafficlights = locate;
//	  		SigAction.Countdown = Countdown;
//	  	}
	  	if(SigAction.curruntSigNumber !=  null)
	  	if((number+"").equals(SigAction.curruntSigNumber )){
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
	  	
//	  	Sig sig = sigService.querySigByIpAddress(clientIP);
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

	 /**
	  * 判断信号机时间与当前中心机软件系统时间是否一致
	  * @param i 年
	  * @param j 月
	  * @param k 日
	  * @param l 时
	  * @param m 分
	  * @param n 秒
	  * @return
	  */
	private boolean checkSigTime(int i, int j, int k, int l, int m, int n) {
		System.out.println("自动校时=================================================");
		String dateStr = "";   
		String[] dates = null;
		List<Integer> dateNumber = null;
	  	Date date = new Date();   
        //format的格式可以任意   
        DateFormat sdf = new SimpleDateFormat("yy/MM/dd/HH/mm/ss");   
        try {   
            dateStr = sdf.format(date);   
            dates = dateStr.split("/");
            dateNumber = new ArrayList<Integer>();
            for(int z=0;z<dates.length;z++)
            {
            	dateNumber.add(Integer.parseInt(dates[z]));
            }
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
    	System.out.println("信号机时间是"+i+"年"+j+"月"+k+"日"+l+"时"+m+"分"+n+"秒");
    	System.out.println("系统时间是"+dateNumber.get(0)+"年"+dateNumber.get(1)+"月"+dateNumber.get(2)+"日"+dateNumber.get(3)+"时"+dateNumber.get(4)+"分"+dateNumber.get(5)+"秒");
		if(i!=dateNumber.get(0)||j!=dateNumber.get(1)||k!=dateNumber.get(2)||l!=dateNumber.get(3)||m!=dateNumber.get(4)||Math.abs(n-dateNumber.get(5))>5)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

	
	
}
