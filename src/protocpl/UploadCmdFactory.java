package protocpl;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import mina.CmdFactoryBase;
import mina.CommandBase;
import mina.DataConvertor;
import mina.ICmdParser;
import mina.CmdFactoryBase.MONITOR_CMD_TYPE;

public class UploadCmdFactory extends CmdFactoryBase implements ICmdParser{

	public UploadCmdFactory(byte[] data) {
		super(data);
		// TODO Auto-generated constructor stub
		this.expected_cmd = MONITOR_CMD_TYPE.MONITOR_CMD_UPLOAD;
	}

	@Override
	public void Process(IoSession session, CommandBase cmd) throws Exception {
		// TODO Auto-generated method stub
		super.Process(session, cmd);
		if(cmd.getCmdType() == this.expected_cmd)
		{
			OnAfter_Ack(session, cmd);
		}
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
	
	public int GetByeAckFlag(CommandBase cmd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean OnAfter_Ack(IoSession session, CommandBase cmd) {
		// TODO Auto-generated method stub
		//this.m_oData
		
		if(this.m_oData[7]==1){
			Upload_time(session,this.m_oData);
		}else if(this.m_oData[7]==2){
			Upload_fault(session,this.m_oData);
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
	
	private void Upload_time(IoSession session,byte[] data){
		int year;
		int month;
		int day;
		int weak;
		int hour;
		int minute;
		int second;
		
		// 对应data[10]开始 7个字节
		
		
		
	}
	
	private void Upload_fault(IoSession session,byte[] data){
		int error = data[10]>>7;        //如果大于0 发生故障   等于0 排除故障
		int year = (data[10]&0x7F);     //  年
        int mounth = data[11];
        int day = data[12];
        int hour = data[13];
        int minute = data[14];
        int secound = data[15];	        
        int error_code = data[16];  
        
        System.out.println("故障代码是"+(error_code&0x7f));
    
	}
}
