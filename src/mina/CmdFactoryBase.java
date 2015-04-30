package mina;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import protocpl.CommandDiaoyue;
import protocpl.CommandParam;
import protocpl.ParametersCmdFactory;
import protocpl.diaoyueCmdFactory;

import mina.ICmdParser;




public class CmdFactoryBase implements ICmdParser {
	private static final Logger log = LoggerFactory.getLogger(CmdFactoryBase.class);
	public static final String SESSION_PARAM_CMD_FACTORY = "cmd_factory";
	public enum MONITOR_CMD_TYPE{
		UNKNOWN_CMD(-1),
		MONITOR_CMD_DIAOYUE(0),
		MONITOR_CMD_UPLOAD(1),
		MONITOR_CMD_COMMON_PARAMETERS(2),
		MONITOR_CMD_HEART_BEAT(3),
		MONITOR_CMD_SWITCH_INFO(4),

		MONITOR_CMD_MSG_PUSH_TEXT(6),
		MONITOR_CMD_MSG_PUSH_TEXT_REPORT(7),
		MONITOR_CMD_IMG_UPLOAD(8),
		MONITOR_CMD_SYN_PARAM(9),
		
		FIRMWARE_UPDATE_NOTIFY(10),
		FIRMWARE_UPDATE_REQ(11),
		FIRMWARE_UPDATE_TRANS(12),
		
		WEB_FIRMWARE_UPDATE_NOTIFY(64),
		
		MONITOR_CMD_BYE(255);
		
		
		private final int _val;
		private MONITOR_CMD_TYPE(int val)
		{
			_val = val;
		}
		
		public int getValue()
		{
			return this._val;
		}
		
		
		
		public static MONITOR_CMD_TYPE valueOf(int val){
			switch(val)
			{
			case 0:
				return MONITOR_CMD_DIAOYUE;
			case 1:
				return MONITOR_CMD_UPLOAD;
			case 2:
				return MONITOR_CMD_COMMON_PARAMETERS;
			case 3:
				return MONITOR_CMD_HEART_BEAT;
			case 4:
				return MONITOR_CMD_SWITCH_INFO;
			case 6:
				return MONITOR_CMD_MSG_PUSH_TEXT;
			case 7:
				return MONITOR_CMD_MSG_PUSH_TEXT_REPORT;
			case 8:
				return MONITOR_CMD_IMG_UPLOAD;
			case 9:
				return MONITOR_CMD_SYN_PARAM;
			case 10:
				return FIRMWARE_UPDATE_NOTIFY;
			case 11:
				return FIRMWARE_UPDATE_REQ;
			case 12:
				return FIRMWARE_UPDATE_TRANS;
			case 64:
				return WEB_FIRMWARE_UPDATE_NOTIFY;
			case 255:
				return MONITOR_CMD_BYE;
			default:
				return UNKNOWN_CMD;
				
			}
		}
	}
	
	
	public static MONITOR_CMD_TYPE getCommandType(byte[] data) {
		
		//int command = data[7] & 0xFF;
		int sum = 0;
		for(int i = 0;i<4;i++){
			if(data[i] == -1)
				sum++;
		}
		
		if(sum == 4){
			int command = data[6];
			return MONITOR_CMD_TYPE.valueOf(command);
		}else{
			return MONITOR_CMD_TYPE.valueOf(-1);
		}
		
	}
	
	public static CmdFactoryBase SelectCmdFactory(IoSession session, Object message)
	{
		CmdFactoryBase factory = null;
		byte[] data = DataConvertor.toByteArray(message);
		System.out.println(">>>>>>>>recv"+data);
		MONITOR_CMD_TYPE eCmdType = getCommandType(data);
		if(MONITOR_CMD_TYPE.UNKNOWN_CMD == eCmdType){
			
				//log.debug("Not expected first cmd type");
				return null;
		}
		switch(eCmdType){
		case MONITOR_CMD_DIAOYUE:
			//log.debug("login factory");
			factory = new diaoyueCmdFactory(data); 
			break;	
		case MONITOR_CMD_UPLOAD:
			break;
			
		case 	MONITOR_CMD_COMMON_PARAMETERS:
			factory = new ParametersCmdFactory(data); 
			break;
		case MONITOR_CMD_SWITCH_INFO:
			//log.debug("switch factory");
			//factory = new SwitchCmdFactory(data);
			break;
			
		case MONITOR_CMD_HEART_BEAT:
			//log.debug("heart beat factory");
			//factory = new HeartBeatCmdFactory(data);
			break;
			
		case MONITOR_CMD_MSG_PUSH_TEXT_REPORT:
			//log.debug("msg push ack factory");
			//factory = new MsgPushReportFactory(data);
			break;
			
		case MONITOR_CMD_IMG_UPLOAD:
			//log.debug("img upload factory");
			//factory = new ImgUploadFactory(data);
			break;
			
		case MONITOR_CMD_SYN_PARAM:
			//log.debug("Syn Param cmd factory");
			//factory = new SynParamCmdFactory(data);
			break;
		case WEB_FIRMWARE_UPDATE_NOTIFY:
			//log.debug("rpc FmUpdate Notify factory");
			//factory = new Rpc_FmUpdateNotifyFactory(data);
			break;
		case FIRMWARE_UPDATE_REQ:
			//log.debug("firmware update trans factory");
			//factory = new FirmwareUpdateFactory(data);
			break;
		}

		
		
		return factory;
	}
	
	public CmdFactoryBase(byte[] data)
	{
		m_oData = data;
	}
	
	protected byte[] m_oData = null;
	protected MONITOR_CMD_TYPE expected_cmd;
	
	public void Process(IoSession session, CommandBase cmd){
//		cmd.Parse(session, m_oData);
	}
	
	public  CommandBase CreateCommand(IoSession session, Object message)
	{

		m_oData = DataConvertor.toByteArray(message);
		CommandBase cmd = null;
				
			MONITOR_CMD_TYPE eCmdType = getCommandType(m_oData);
			
			switch(eCmdType){
			case MONITOR_CMD_DIAOYUE:
				log.debug("CMD_LOGIN");
				cmd = new CommandDiaoyue(this, m_oData);
				break;	
			case MONITOR_CMD_UPLOAD:
				log.debug("CMD_BYE");
				//cmd = new CommandBye(this, m_oData);
				break;	
			case MONITOR_CMD_COMMON_PARAMETERS:
				cmd = new CommandParam(this, m_oData);
				break;
			}
		return cmd;
	}

	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
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

	public void TaskDispose() {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
