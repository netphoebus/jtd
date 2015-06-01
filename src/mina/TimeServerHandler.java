package mina;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.action.SigAction;
import com.jlj.model.Sig;
import com.jlj.model.Userarea;
import com.jlj.service.ISigService;
import com.jlj.service.IUserareaService;


  
public class TimeServerHandler  implements IoHandler {
	public static List<IoSession> iosessions = new ArrayList<IoSession>();
	final static int[] cmd_diaoyue = new int[]{0xFF ,0xFF ,0xFF ,0xFF ,0x01 ,0xF0 ,0x90 ,0x00 ,0x00 ,0x08 ,0x01 ,0x89};
	final static String cmd_diaoyue1 = "FF FF FF FF 01 F0 90 00 00 08 01 89";
	final static String cmd_canshu = "FF FF FF FF 01 F0 92 00 00 08 01 8B";
	
	final static String cmd_test = "74 65 73 74 73 65 6E 64";
	public final static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	public final static ISigService sigService = (ISigService)ac.getBean("sigService");
	public final static IUserareaService userareaService = (IUserareaService)ac.getBean("userareaService");
	
	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		arg1.printStackTrace();  
		
	}

	public void inputClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	protected byte[] m_oData = null;
	
	public void messageReceived(IoSession session, Object msg) throws Exception {
		//CmdFactoryBase cmdFactory = (CmdFactoryBase)session.getAttribute(CmdFactoryBase.SESSION_PARAM_CMD_FACTORY);
		//if(null == cmdFactory){
		CmdFactoryBase cmdFactory = CmdFactoryBase.SelectCmdFactory(session, msg);
//			session.setAttribute(CmdFactoryBase.SESSION_PARAM_CMD_FACTORY, cmdFactory);
//		}
//		else {
//			
//		}
	System.out.println("ente messageReceived"+bytesToHexString(DataConvertor.toByteArray(msg)));
//			byte[] m_oData = DataConvertor.toByteArray(msg);
//			String data = bytesToHexString(m_oData);
//			AnalysisData(data, session);
			if(cmdFactory != null){
				CommandBase cmd = cmdFactory.CreateCommand(session, msg);
				if(null != cmd){
					cmdFactory.Process(session, cmd);
				}
			}
			
	}
	

	
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("发送信息:"+arg1.toString()+"到"+arg0.getRemoteAddress().toString()); 
	}

	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IP:"+arg0.getRemoteAddress().toString()+"断开连接"); 
		CmdFactoryBase cmdFactory = (CmdFactoryBase)arg0.getAttribute(CmdFactoryBase.SESSION_PARAM_CMD_FACTORY);
		if(cmdFactory != null)
		{
			cmdFactory.TaskDispose();
		}
		iosessions.remove(arg0);
	}

	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IP:"+session.getRemoteAddress().toString());
		iosessions.add(session);
		//获取session中的IP地址，匹配数据库，发现sig表中无该ip，添加数据；发现sig表中有ip，则不插入-from jlj
		String ipAddress= ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		Sig sig = sigService.querySigByIpAddress(ipAddress);
		if(sig==null){
			sig = new Sig();
			sig.setIp(ipAddress);
			Userarea userarea = userareaService.loadById(1);//load未知区域
			if(userarea==null){
				System.out.println("userarea=null--------------------");
			}
			sig.setUserarea(userarea);
			sigService.add(sig);
		}
	}

	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "IDLE " + arg0.getIdleCount( arg1 ));  
		//if()
	}

	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "opened " );  
			String[] cmds = cmd_diaoyue1.split(" ");
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
	
	public static void AnalysisData(String data,IoSession session){
	   	boolean started = false;
	  	String XHJ_address;
	  	String ZXJ_address;
	  	String Comm0;
	  	String Comm1;
		int sum = 0;   
		  
		    
		    int east[] 	= new int[5];  //1绿，2黄，3红，0灭  方向顺序 左直右人人
		    int west[]	= new int[5];		
		    int north[]	= new int[5];
		    int sourth[]= new int[5];
		    
		   
		    
		  // ff ff ff ff 01 f0 00 00 00 30 90 34
		  
	  	char[] mdata = data.toCharArray();
	  	for(int i= 0;i<8;i++){
	  		if(mdata[i] == 'f'){
	  			sum++;
	  		}
	  	}
	  	if(sum == 8)
	  		started = true;
	  	if(started == true){
	  		
	  		
	  		
	  		XHJ_address = data.substring(8 ,10);
	  		ZXJ_address = data.substring(10,12);
	  		Comm0 		= data.substring(12,14);
	  		Comm1		= data.substring(14,16);
	  		//System.out.println("the comm0 is"+str2hex(Comm0));
	  		switch(str2hex(Comm0)){
	  			case 0: //调阅实时状态
	  				upload_RealTimeStatus(data,session);
	  				break;
	  			case 1:
	  				
	  				if(str2hex(Comm1)==1){
	  					//上传本地时间
	  					
	  				}else if(str2hex(Comm1)==2){
	  					//上传故障代码
	  				}
	  				
	  				break;
	  			case 2:  //上传基本参数
	  				if(str2hex(Comm1)==1){
	  					//上传公共参数
	  					upload_CommonPara(data,session);
	  				}
	  				break;
	  			case 3:
	  				
	  				break;
	  			case 4:
	  				break;
	  			case 5:
	  				break;
	  			default:
	  				break;
	  		}
	  		
	  	}
	
	  	
	  }
	  
	
	  public static void upload_RealTimeStatus(String data,IoSession session){
		  String temp[] = new String[8];
		  int locate[][] = new int[4][5];
	  		for(int i=0;i<8;i++){
	  			temp[i] = data.substring(20+i*2, 22+i*2);;
	  		}
	  		
	  		for(int i=0;i<4;i++){
	  		if((str2hex(temp[i*2])&0x80)>0){
	  			locate[i][0] = 3;              
	  		}else if((str2hex(temp[i*2])&0x40)>0){
	  			locate[i][0] = 2;
	  		}else if((str2hex(temp[i*2])&0x20)>0){
	  			locate[i][0] = 1;
	  		}else{
	  			locate[i][0] = 0;
	  		}
	  		
	  		if((str2hex(temp[i*2])&0x10)>0){
	  			locate[i][1] = 3;
	  		}else if((str2hex(temp[i*2])&0x08)>0){
	  			locate[i][1] = 2;
	  		}else if((str2hex(temp[i*2])&0x04)>0){
	  			locate[i][1] = 1;
	  		}else{
	  			locate[i][1] = 0;
	  		}
	  		
	  		if((str2hex(temp[i*2+1])&0x80)>0){
	  			locate[i][2] = 3;
	  		}else if((str2hex(temp[i*2+1])&0x40)>0){
	  			locate[i][2] = 2;
	  		}else if((str2hex(temp[i*2+1])&0x20)>0){
	  			locate[i][2] = 1;
	  		}else{
	  			locate[i][2] = 0;
	  		}
	  		
	  		if((str2hex(temp[i*2+1])&0x10)>0){
	  			locate[i][3] = 3;
	  		}else if((str2hex(temp[i*2+1])&0x08)>0){
	  			locate[i][3] = 1;
	  		}else{
	  			locate[i][3] = 0;
	  		}
	  		
	  		if((str2hex(temp[i*2+1])&0x04)>0){
	  			locate[i][4] = 3;
	  		}else if((str2hex(temp[i*2+1])&0x02)>0){
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
	
	  public static void upload_CommonPara(String data,IoSession session){
		  System.out.println(data);
		  String time_qingchanghongdeng	 = data.substring(18,20);
		  String time_huangshan 		 = data.substring(20,22) ;
		  String tongxuncanshu 			= data.substring(26,28);
		  String liuliangjiance			= data.substring(28,30);
		  String neibubiaozhi;
		  String gongzuorishezhi		= data.substring(32,34);
		  String zhourishezhi			= data.substring(34,36);
		  String year;
		  String month;
		  String day;
		  String hour;
		  String minite;
		  String second;
		  String G_min 					= data.substring(48,50);
		  String G_max					= data.substring(50,52);
		  String G_step					= data.substring(52,54);
		  
		  String xingren				= data.substring(80,82);
		  String zhouqi					= data.substring(82,84);
		  String enable					= data.substring(84,86);
		  String[] mdata = new String[48];
		  for(int i=0;i<48;i++)
			  mdata[i] = data.substring(112+i*2,114+i*2);
		  
		  //System.out.println(time_qingchanghongdeng+time_huangshan+tongxuncanshu+liuliangjiance+gongzuorishezhi+zhourishezhi+G_min+G_max);
	  }
	  
	  public static String bytesToHexString(byte[] src){  
	      StringBuilder stringBuilder = new StringBuilder("");  
	      if (src == null || src.length <= 0) {  
	          return null;  
	      }  
	      for (int i = 0; i < src.length; i++) {  
	          int v = src[i] & 0xFF;  
	          String hv = Integer.toHexString(v);  
	          if (hv.length() < 2) {  
	              stringBuilder.append(0);  
	          }  
	          stringBuilder.append(hv);  
	      }  
	    //  System.out.println("---"+stringBuilder.toString()+"---");
	      
	      return stringBuilder.toString();  
	  }  
	  
	  public static int str2hex(String str){
	  	String temp = str.substring(0, 1);
	    String temp2= str.substring(1, 2);
		int l = str2hexfun(temp);
	    int m = str2hexfun(temp2);
	    int sum = (l<<4)+m;
	      
			return sum;
	  	
	  }
	  
	  public static int str2hexfun(String str){
	  	
	  	if(str.equals("a")){
	  		return 10;
	  	}else if(str.equals("b"))
	  		return 11;
	  	else if(str.equals("c"))
	  		return 12;
	  	else if(str.equals("d"))
	  		return 13;
	  	else if(str.equals("e"))
	  		return 14;
	  	else if(str.equals("f"))
	  		return 15;
	  	else{
	  		int i = Integer.valueOf(str).intValue();
	  	return i;
	  	}
	  }
	  public static String str2HexStr(String str)    
	  {      
	    
	      char[] chars = "0123456789ABCDEF".toCharArray();      
	      StringBuilder sb = new StringBuilder("");    
	      byte[] bs = str.getBytes();      
	      int bit;      
	          
	      for (int i = 0; i < bs.length; i++)    
	      {      
	          bit = (bs[i] & 0x0f0) >> 4;      
	          sb.append(chars[bit]);      
	          bit = bs[i] & 0x0f;      
	          sb.append(chars[bit]);    
	          sb.append(' ');    
	      }      
	      return sb.toString().trim();      
	  }    

		 public static String BytesHexString(byte[] b) {   
	         String ret = "";   
	         for (int i = 0; i < b.length; i++) {   
	           String hex = Integer.toHexString(b[i] & 0xFF);   
	           if (hex.length() == 1) {   
	             hex = '0' + hex;   
	           }   
	           ret += hex.toUpperCase();   
	         }   
	         return ret;   
	      }   
}
