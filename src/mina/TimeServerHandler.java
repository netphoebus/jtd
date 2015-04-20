package mina;
import java.util.Date;  
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;  
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  

import com.jlj.action.ClientAction;
import com.jlj.action.RealTimeTrafficAction;

  
public class TimeServerHandler  implements IoHandler {
	final static int[] cmd_diaoyue = new int[]{0xFF ,0xFF ,0xFF ,0xFF ,0x01 ,0xF0 ,0x90 ,0x00 ,0x00 ,0x08 ,0x01 ,0x89};
	final static String cmd_diaoyue1 = "FF FF FF FF 01 F0 90 00 00 08 01 89";
	final static String cmd_test = "74 65 73 74 73 65 6E 64";
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
		byte[] m_oData = null;
		String data ;
		CmdFactoryBase cmdFactory = (CmdFactoryBase)session.getAttribute(CmdFactoryBase.SESSION_PARAM_CMD_FACTORY);
		if(null == cmdFactory){
			cmdFactory = CmdFactoryBase.SelectCmdFactory(session, msg);
			
			session.setAttribute(CmdFactoryBase.SESSION_PARAM_CMD_FACTORY, cmdFactory);
		}
		else {
			
		}

		m_oData = DataConvertor.toByteArray(msg);
		//CommandBase cmd = null;

			
			
			System.out.println(">>>>>>>>recv" +m_oData);
			data = bytesToHexString(m_oData);
			AnalysisData(data);
			//AnalysisData_Sensor(data);
			
			
			
		//CommandBase cmd = cmdFactory.CreateCommand(session, msg);
		
		//if(null != cmd){
		//	cmdFactory.Process(session, cmd);
		//}
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
	
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("发送信息:"+arg1.toString()); 
	}

	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IP:"+arg0.getRemoteAddress().toString()+"断开连接");  
	}

	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IP:"+arg0.getRemoteAddress().toString()); 
		
		
	}

	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "IDLE " + arg0.getIdleCount( arg1 ));  
		String[] cmds = cmd_test.split(" ");
        byte[] aaa = new byte[cmds.length];
        int i = 0;
        for (String b : cmds) {
            if (b.equals("FF")) {
                aaa[i++] = -1;
            } else {
                aaa[i++] = Integer.valueOf(b, 16).byteValue();;
            }
        }
        arg0.write(IoBuffer.wrap(aaa));
	}

	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "opened " );  
		//session.write(cmdtest);
			//arg0.write(cmd_diaoyue1);
		//for(int i = 0;i<cmd_diaoyue.length;i++)
		//	arg0.write(cmd_diaoyue[i]);
		
		  //String[] cmds = cmd_diaoyue1.split(" ");
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
	public static void AnalysisData_Sensor(String data){
		
		boolean started = false;
		String head = data.substring(0, 8);
	  	if(head.equals("35356161")){
	  		started = true;
	  	}
	  	if(started == true){
	  		//char[] a = data.substring(16,18).toCharArray();
	  		int[] b = new int[5];
	  		int[] w = new int[3];
	  		int n;
	  		String zheng;
	  		for(int i =0;i<5;i++){
	  			b[i] = Integer.valueOf(data.substring(16+i*2,18+i*2)).intValue();
	  			if((b[i]-30)<10){
	  				b[i] = b[i]-30;
	  			}	
	  		}
	  		if(data.substring(26,28).equals("2b")){
	  			zheng = "+";
	  		}else{
	  			zheng = "-";
	  		}
	  		for(int i =0;i<3;i++){
	  			w[i] = Integer.valueOf(data.substring(28+i*2,30+i*2)).intValue();
	  			if((w[i]-30)<10){
	  				w[i] = w[i]-30;
	  			}	
	  		}
	  		n = Integer.valueOf(data.substring(36,38)).intValue()-30;
	  		String sensorNum = String.format("%d%d%d%d%d", b[0],b[1],b[2],b[3],b[4]);
	  		String sensorTemp = String.format("%s%d%d%d.%d", zheng,w[0],w[1],w[2],n);
	  		System.out.print("the num of sensor is"+sensorNum+"the temperature is"+sensorTemp);
	  	}
	}
	public static void AnalysisData(String data){
	   	boolean started = false;
	  	String XHJ_address;
	  	String ZXJ_address;
		int sum = 0;   
		  
		    
		    int east[] 	= new int[5];  //1绿，2黄，3红，0灭  方向顺序 左直右人人
		    int west[]	= new int[5];		
		    int north[]	= new int[5];
		    int sourth[]= new int[5];
		    
		    int locate[][] = new int[4][5];
		    
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
	  		XHJ_address = data.substring(8, 10);
	  		ZXJ_address = data.substring(10, 12);
	  		//String temp = data.substring(19, 20);
	  		//String temp1 = data.substring(20, 21);
	  		//int t = Integer.valueOf(temp).intValue();
	  		//int t1 = Integer.valueOf(temp1).intValue();
	  		
	  		String temp[] = new String[8];
	  		
	  		for(int i=0;i<8;i++){
	  			temp[i] = data.substring(20+i*2, 22+i*2);;
	  		}
	  		
	  		//String temp	 = data.substring(20, 22);
	  		//String temp1 = data.substring(22, 24);
	/*	    		
	  		int t = Integer.valueOf(temp).intValue();
	  		if(t == 0){
	  			east[0] = 0;
	  			east[1] = 0;
	  		}
	  		else if(t > 10){
	  			east[0] = t/40+1;
	  			if(t%20 == 0){
	  				east[1] = 0;
	  			}
	  			int t1 = t%10/4;
	  			if(t1 == 0)
	  				east[1] = 3;
	  			east[1] = t1;
	  		}else{
	  			east[0] = 0;
	  			int t1 = t%10/4;
	  			if(t1 == 0)
	  				east[1] = 3;
	  			east[1] = t1;
	  		}
	*/
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
//	  		for(int i=0;i<locate.length;i++){
//	  	  		for(int j=0;j<locate[i].length;j++){
//	  	  		System.out.print(locate[i][j]);
//	  	  		
//	  	  			}
//	  	  		System.out.println(" ");
//	  	  	}
	  	}
	  	RealTimeTrafficAction.trafficlights = locate;
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
	      System.out.println("---"+stringBuilder.toString()+"---");
	      
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

}
