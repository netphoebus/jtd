package protocpl;

import java.net.InetSocketAddress;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.model.Greenconflict;
import com.jlj.model.Sig;
import com.jlj.model.Signpublicparam;
import com.jlj.service.IGreenconflictService;
import com.jlj.service.ISigService;
import com.jlj.service.ISignpublicparamService;



public class ParametersCmdFactory extends CmdFactoryBase implements ICmdParser{

	public static boolean setSuccess;
	final static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	final static ISigService sigService = (ISigService)ac.getBean("sigService");
	final static ISignpublicparamService signpublicparamService = (ISignpublicparamService)ac.getBean("signpublicparamService");
	final static IGreenconflictService greenconflictService = (IGreenconflictService)ac.getBean("greenconflictService");
	public ParametersCmdFactory(byte[] data){
		super(data);
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_PARAMETERS;
		//DataCacheFactory.Init();
	}
	
	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception{
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
	
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub
		//this.m_oData
		
		System.out.println("the 6 is"+this.m_oData[6]+"the 7 is"+this.m_oData[7]);
		
		if(this.m_oData[7]==0){
			Upload_fault(session,this.m_oData);
		}else if(this.m_oData[7]==1){
			Upload_parameters(session,this.m_oData);
		}else if(this.m_oData[7]==4){
			Upload_conflict(session,this.m_oData);
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
	
	private void Upload_parameters(IoSession session,byte[] data) throws Exception{
		//获取session中的IP
		String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		//获取信号机中的数据
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
		int countdownmode			= data[29];
		int xrfxtime 				= data[42];
		int cycle 					= data[43];			
		int  xyxr 					= data[44];
		int SigSpecialTime[][] 		= new int[24][2];
		for( int j =0 ;j < 24;j++){
			SigSpecialTime[j][0] 	= data[58+j*2] ;
			SigSpecialTime[j][1] 	= data[58+j*2+1] ;
		}
		//-----------------------数据库---------------------------
		//检查公共参数表是否有该ip地址：若无，插入新数据；若有，修改原数据
		Signpublicparam signpublicparam = signpublicparamService.getPublicparamByIp(clientIP);
		if(signpublicparam==null){
			System.out.println("-------------------------------signpublicparam add");
			signpublicparam = new Signpublicparam();
			signpublicparam.setIp(clientIP);
			signpublicparam.setQchdtime(Red_Clearance_Time);//清场红灯
			signpublicparam.setKjhstime(Yellow_Flash_Time);//开机黄闪
			signpublicparam.setNumber(String.valueOf(number));
			signpublicparam.setComparam(String.valueOf(comparam));
			signpublicparam.setCheckflow(checkflow);
			signpublicparam.setInnermark(String.valueOf(innermark));
			signpublicparam.setWorkingset(Workingset);
			signpublicparam.setMon(SigSunTime[0]);
			signpublicparam.setTue(SigSunTime[1]);
			signpublicparam.setWes(SigSunTime[2]);
			signpublicparam.setThir(SigSunTime[3]);
			signpublicparam.setFra(SigSunTime[4]);
			signpublicparam.setSata(SigSunTime[5]);
			signpublicparam.setSun(SigSunTime[6]);
			signpublicparam.setGmintime(gmintime);
			signpublicparam.setGmaxtime(gmaxtime);
			signpublicparam.setZdbctime(zdbctime);
			signpublicparam.setCountdownmode(countdownmode);//未插入
			signpublicparam.setXrfxtime(xrfxtime);
			signpublicparam.setCycle(cycle);
			signpublicparam.setXyxr(xyxr);
			signpublicparam.setSpecialmonth0(SigSpecialTime[0][0]);
			signpublicparam.setSpecialday0(SigSpecialTime[0][1]);
			signpublicparam.setSpecialmonth1(SigSpecialTime[1][0]);
			signpublicparam.setSpecialday1(SigSpecialTime[1][1]);
			signpublicparam.setSpecialmonth2(SigSpecialTime[2][0]);
			signpublicparam.setSpecialday2(SigSpecialTime[2][1]);
			signpublicparam.setSpecialmonth3(SigSpecialTime[3][0]);
			signpublicparam.setSpecialday3(SigSpecialTime[3][1]);
			signpublicparam.setSpecialmonth4(SigSpecialTime[4][0]);
			signpublicparam.setSpecialday4(SigSpecialTime[4][1]);
			signpublicparam.setSpecialmonth5(SigSpecialTime[5][0]);
			signpublicparam.setSpecialday5(SigSpecialTime[5][1]);
			signpublicparam.setSpecialmonth6(SigSpecialTime[6][0]);
			signpublicparam.setSpecialday6(SigSpecialTime[6][1]);
			signpublicparam.setSpecialmonth7(SigSpecialTime[7][0]);
			signpublicparam.setSpecialday7(SigSpecialTime[7][1]);
			signpublicparam.setSpecialmonth8(SigSpecialTime[8][0]);
			signpublicparam.setSpecialday8(SigSpecialTime[8][1]);
			signpublicparam.setSpecialmonth9(SigSpecialTime[9][0]);
			signpublicparam.setSpecialday9(SigSpecialTime[9][1]);
			signpublicparam.setSpecialmonth10(SigSpecialTime[10][0]);
			signpublicparam.setSpecialday10(SigSpecialTime[10][1]);
			signpublicparam.setSpecialmonth11(SigSpecialTime[11][0]);
			signpublicparam.setSpecialday11(SigSpecialTime[11][1]);
			signpublicparam.setSpecialmonth12(SigSpecialTime[12][0]);
			signpublicparam.setSpecialday12(SigSpecialTime[12][1]);
			signpublicparam.setSpecialmonth13(SigSpecialTime[13][0]);
			signpublicparam.setSpecialday13(SigSpecialTime[13][1]);
			signpublicparam.setSpecialmonth14(SigSpecialTime[14][0]);
			signpublicparam.setSpecialday14(SigSpecialTime[14][1]);
			signpublicparam.setSpecialmonth15(SigSpecialTime[15][0]);
			signpublicparam.setSpecialday15(SigSpecialTime[15][1]);
			signpublicparam.setSpecialmonth16(SigSpecialTime[16][0]);
			signpublicparam.setSpecialday16(SigSpecialTime[16][1]);
			signpublicparam.setSpecialmonth17(SigSpecialTime[17][0]);
			signpublicparam.setSpecialday17(SigSpecialTime[17][1]);
			signpublicparam.setSpecialmonth18(SigSpecialTime[18][0]);
			signpublicparam.setSpecialday18(SigSpecialTime[18][1]);
			signpublicparam.setSpecialmonth19(SigSpecialTime[19][0]);
			signpublicparam.setSpecialday19(SigSpecialTime[19][1]);
			signpublicparam.setSpecialmonth20(SigSpecialTime[20][0]);
			signpublicparam.setSpecialday20(SigSpecialTime[20][1]);
			signpublicparam.setSpecialmonth21(SigSpecialTime[21][0]);
			signpublicparam.setSpecialday21(SigSpecialTime[21][1]);
			signpublicparam.setSpecialmonth22(SigSpecialTime[22][0]);
			signpublicparam.setSpecialday22(SigSpecialTime[22][1]);
			signpublicparam.setSpecialmonth23(SigSpecialTime[23][0]);
			signpublicparam.setSpecialday23(SigSpecialTime[23][1]);
			signpublicparamService.add(signpublicparam);//保存公共参数

			System.out.println("-------------------------------signpublicparam add success");
		}else{
			System.out.println("-------------------------------signpublicparam update");	
			signpublicparamService.updateByPublicid(Red_Clearance_Time,Yellow_Flash_Time,number+"",
					comparam+"",checkflow,innermark,Workingset,
					SigSunTime[0],SigSunTime[1],SigSunTime[2],SigSunTime[3],SigSunTime[4],SigSunTime[5],SigSunTime[6],
					gmintime,gmaxtime,zdbctime,countdownmode,xrfxtime,cycle,xyxr,
					SigSpecialTime[0][0],SigSpecialTime[0][1],SigSpecialTime[1][0],SigSpecialTime[1][1],
					SigSpecialTime[2][0],SigSpecialTime[2][1],SigSpecialTime[3][0],SigSpecialTime[3][1],
					SigSpecialTime[4][0],SigSpecialTime[4][1],SigSpecialTime[5][0],SigSpecialTime[5][1],
					SigSpecialTime[6][0],SigSpecialTime[6][1],SigSpecialTime[7][0],SigSpecialTime[7][1],
					SigSpecialTime[8][0],SigSpecialTime[8][1],SigSpecialTime[9][0],SigSpecialTime[9][1],
					SigSpecialTime[10][0],SigSpecialTime[10][1],SigSpecialTime[11][0],SigSpecialTime[11][1],
					SigSpecialTime[12][0],SigSpecialTime[12][1],SigSpecialTime[13][0],SigSpecialTime[13][1],
					SigSpecialTime[14][0],SigSpecialTime[14][1],SigSpecialTime[15][0],SigSpecialTime[15][1],
					SigSpecialTime[16][0],SigSpecialTime[16][1],SigSpecialTime[17][0],SigSpecialTime[17][1],
					SigSpecialTime[18][0],SigSpecialTime[18][1],SigSpecialTime[19][0],SigSpecialTime[19][1],
					SigSpecialTime[20][0],SigSpecialTime[20][1],SigSpecialTime[21][0],SigSpecialTime[21][1],
					SigSpecialTime[22][0],SigSpecialTime[22][1],SigSpecialTime[23][0],SigSpecialTime[23][1],signpublicparam.getId());
			
			System.out.println("-------------------------------signpublicparam update success");		
		}
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		
		int conflict[][] = new int[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				conflict[i][j] = data[10+j+i*16];
			}
		}
		
	}
	
	/**
	 * @param session
	 * @param data
	 */
	private void Upload_conflict(IoSession session, byte[] data) {
		// TODO Auto-generated method stub
		int conflict[][] = new int[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				conflict[i][j] = data[10+j+i*16];
			}
		}
		//-----------------------数据库---------------------------
		//获取session中的IP
		String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		//检查公共参数表的冲突子表：若无，插入新数据；若有，修改原数据
		Sig sig = sigService.querySigByIpAddress(clientIP);
		if(sig!=null){
			Greenconflict greenconflict = sig.getGreenconflicts().get(0);
			if(greenconflict==null){
				//新增数据
				for (int i = 0; i < 16; i++) {
					greenconflict = new Greenconflict();
					greenconflict.setSig(sig);
					int j2=0;
					for (int j = 0; j < 16; j++) {
						j2=j;
						switch (j) {
						case 0:
							greenconflict.setL00(conflict[i][j]);
							break;
						case 1:
							greenconflict.setL01(conflict[i][j]);
							break;
						case 2:
							greenconflict.setL02(conflict[i][j]);
							break;
						case 3:
							greenconflict.setL03(conflict[i][j]);
							break;
						case 4:
							greenconflict.setL10(conflict[i][j]);
							break;
						case 5:
							greenconflict.setL11(conflict[i][j]);
							break;
						case 6:
							greenconflict.setL12(conflict[i][j]);
							break;
						case 7:
							greenconflict.setL13(conflict[i][j]);
							break;
						case 8:
							greenconflict.setL20(conflict[i][j]);
							break;
						case 9:
							greenconflict.setL21(conflict[i][j]);
							break;
						case 10:
							greenconflict.setL22(conflict[i][j]);
							break;
						case 11:
							greenconflict.setL23(conflict[i][j]);
							break;
						case 12:
							greenconflict.setL30(conflict[i][j]);
							break;
						case 13:
							greenconflict.setL31(conflict[i][j]);
							break;
						case 14:
							greenconflict.setL32(conflict[i][j]);
							break;
						case 15:
							greenconflict.setL33(conflict[i][j]);
							break;
						
						default:
							break;
						}
					}
					greenconflict.setName(i+""+j2);
					try {
						greenconflictService.add(greenconflict);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		}
	}
	
}
