package protocpl;

import java.net.InetSocketAddress;
import java.util.List;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.ICmdParser;

import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlj.model.Commontime;
import com.jlj.model.Signpublicparam;
import com.jlj.model.Sigordinarytime;
import com.jlj.service.ICommontimeService;
import com.jlj.service.ISignpublicparamService;
import com.jlj.service.ISigordinarytimeService;
import com.jlj.service.imp.CommontimeServiceImp;

public class CommonTimeCmdFactory extends CmdFactoryBase implements ICmdParser{

	final static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	final static ISignpublicparamService signpublicparamService = (ISignpublicparamService)ac.getBean("signpublicparamService");
	final static ISigordinarytimeService sigordinarytimeService = (ISigordinarytimeService)ac.getBean("sigordinarytimeService");
	final static ICommontimeService commontimeService = (ICommontimeService)ac.getBean("commontimeService");
	public CommonTimeCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_COMMON_TIME;
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
	
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		//this.m_oData
		//----------------------数据库-------------------------
		//1-查询公共参数表，然后把这些commontime的列表与父表对应
		String clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		Signpublicparam signpublicparam = signpublicparamService.getPublicparamByIp(clientIP);
		Sigordinarytime sigordinarytime = null;
		if(signpublicparam!=null){
			sigordinarytime = signpublicparam.getSigordinarytimes().get(0);
		}
		
		if(this.m_oData[7]==0){
			Upload_CommonTimeHead(session,this.m_oData,sigordinarytime);
		}else if(this.m_oData[7]==1){
			Upload_CommonTimeTail(session,this.m_oData,sigordinarytime);
		}
		return false;
	}

	private void Upload_CommonTimeTail(IoSession session, byte[] data,Sigordinarytime sigordinarytime) {
		// TODO Auto-generated method stub
//		ArrayList<Commontime> commtimelist = new ArrayList<Commontime>();
		
		List<Commontime> commontimes = sigordinarytime.getCommontimes();
		//查询是否数据库中普通参数的公共参数为空，如果为空，新插入；如果不为空，更新所有数据；
		if(commontimes==null||commontimes.size()==0){
			for(int i = 0;i<8;i++){
				Commontime commontime = new Commontime();
				commontime.setHour((int)data[10+i*40]);
				commontime.setMinute((int)data[11+i*40]);		
				commontime.setSeconds((int)data[12+i*40]);;
				commontime.setWorkingway((int)data[13+i*40]);
				commontime.setWorkingprogram((int)data[14+i*40]);
				commontime.setLstime((int)data[15+i*40]);
				commontime.setHdtime((int)data[16+i*40]);
				commontime.setQchdtime((int)data[17+i*40]) ;
				commontime.setOrderid(i+8);
				commontime.setSigordinarytime(sigordinarytime);
				int worktime[] = new int[32];
				for(int j=0;j<32;j++){
					worktime[j] = data[18+j+i*40];
				}
				try {
					commontimeService.add(commontime);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			for(int i = 0;i<8;i++){
				int hour = (int)data[10+i*40];
				int minute = (int)data[11+i*40];
				int seconds = (int)data[12+i*40];
				int workingway = (int)data[13+i*40];
				int workingprogram = (int)data[14+i*40];
				int lstime = (int)data[15+i*40];
				int hdtime = (int)data[16+i*40];
				int qchdtime = (int)data[17+i*40];
				int orderid = i+8;
				commontimeService.updateByConditionOrdinaryid(hour,minute,seconds,workingway,workingprogram,lstime,hdtime,qchdtime,orderid,sigordinarytime.getId());
			}
		}
		
	}

	private void Upload_CommonTimeHead(IoSession session, byte[] data,Sigordinarytime sigordinarytime) {
		// TODO Auto-generated method stub
//		ArrayList<Commontime> commtimelist = new ArrayList<Commontime>();
		List<Commontime> commontimes = sigordinarytime.getCommontimes();
		//查询是否数据库中普通参数的公共参数为空，如果为空，新插入；如果不为空，更新所有数据；
		if(commontimes==null||commontimes.size()==0){
			for(int i = 0;i<8;i++){
				Commontime commontime = new Commontime();
				commontime.setHour((int)data[10+i*40]);
				commontime.setMinute((int)data[11+i*40]);		
				commontime.setSeconds((int)data[12+i*40]);;
				commontime.setWorkingway((int)data[13+i*40]);
				commontime.setWorkingprogram((int)data[14+i*40]);
				commontime.setLstime((int)data[15+i*40]);
				commontime.setHdtime((int)data[16+i*40]);
				commontime.setOrderid(i);
				commontime.setQchdtime((int)data[17+i*40]) ;
				commontime.setSigordinarytime(sigordinarytime);
				int worktime[] = new int[32];
				for(int j=0;j<32;j++){
					worktime[j] = data[18+j+i*40];
				}
				try {
					commontimeService.add(commontime);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			for(int i = 0;i<8;i++){
				int hour = (int)data[10+i*40];
				int minute = (int)data[11+i*40];
				int seconds = (int)data[12+i*40];
				int workingway = (int)data[13+i*40];
				int workingprogram = (int)data[14+i*40];
				int lstime = (int)data[15+i*40];
				int hdtime = (int)data[16+i*40];
				int qchdtime = (int)data[17+i*40];
				int orderid = i;
				commontimeService.updateByConditionOrdinaryid(hour,minute,seconds,workingway,workingprogram,lstime,hdtime,qchdtime,orderid,sigordinarytime.getId());
			}
		}
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
	

