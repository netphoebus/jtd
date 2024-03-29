package com.jlj.util;

import java.util.List;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;



public class Commands {
	
	public final static String cmd_dy     = "FF FF FF FF 01 F0 90 00 00 08 01 89";//调阅实时状态                                                     命令编号 0
	public final static String cmd_tzdy   = "FF FF FF FF 01 F0 90 01 00 08 01 8A";//停止调阅实时状态											命令编号 1
	public final static String cmd_dysy   = "FF FF FF FF 01 F0 92 00 00 08 01 8B";//调阅所有参数 												命令编号 2
	public final static String cmd_dygz   = "FF FF FF FF 01 F0 92 02 00 08 01 8D";//调阅故障记录	 											命令编号 3
	public final static String cmd_hfmr   = "FF FF FF FF 01 F0 82 03 00 08 01 7E";//恢复默认设置 												命令编号 4
	public final static String cmd_dygg   = "FF FF FF FF 01 F0 92 01 00 08 01 8C"; //调阅公共参数											     命令编号 5
	public final static String cmd_dypt1  = "FF FF FF FF 01 F0 93 00 00 08 01 8C"; //调阅普通时间段0-7 										命令编号 6
	public final static String cmd_dypt2  = "FF FF FF FF 01 F0 93 01 00 08 01 8D"; //调阅普通时间段8-15 										命令编号 7
	public final static String cmd_dyzr1  = "FF FF FF FF 01 F0 94 00 00 08 01 8D"; //调阅周日时间段0-7 										命令编号 8
	public final static String cmd_dyzr2  = "FF FF FF FF 01 F0 94 01 00 08 01 8E"; //调阅周日时间段8-15										命令编号 9
	public final static String cmd_dyts1  = "FF FF FF FF 01 F0 95 00 00 08 01 8E"; //调阅特殊时间段0-7 										命令编号 10
	public final static String cmd_dyts2  = "FF FF FF FF 01 F0 95 01 00 08 01 8F"; //调阅特殊时间段8-15									    命令编号 11
	public final static String cmd_dyxw16 = "FF FF FF FF 01 F0 96 00 00 08 01 8F"; //调阅相位序列16	命令编号 12
	public final static String cmd_dyxw17 = "FF FF FF FF 01 F0 96 01 00 08 01 90"; //调阅相位序列17	命令编号 13
	public final static String cmd_dyxw18 = "FF FF FF FF 01 F0 96 02 00 08 01 91"; //调阅相位序列18	命令编号 14
	public final static String cmd_dyxw19 = "FF FF FF FF 01 F0 96 03 00 08 01 92"; //调阅相位序列19	命令编号 15
	public final static String cmd_dyxw20 = "FF FF FF FF 01 F0 96 04 00 08 01 93"; //调阅相位序列20	命令编号 16
	public final static String cmd_dyxw21 = "FF FF FF FF 01 F0 96 05 00 08 01 94"; //调阅相位序列21	命令编号 17
	public final static String cmd_dyxw22 = "FF FF FF FF 01 F0 96 06 00 08 01 95"; //调阅相位序列22	命令编号 18
	public final static String cmd_dyxw23 = "FF FF FF FF 01 F0 96 07 00 08 01 96"; //调阅相位序列23	命令编号 19
	public final static String cmd_dyxw24 = "FF FF FF FF 01 F0 96 08 00 08 01 97"; //调阅相位序列24	命令编号 20
	public final static String cmd_dyxw25 = "FF FF FF FF 01 F0 96 09 00 08 01 98"; //调阅相位序列25	命令编号 21
	public final static String cmd_dyxw26 = "FF FF FF FF 01 F0 96 0A 00 08 01 99"; //调阅相位序列26	命令编号 22
	public final static String cmd_dyxw27 = "FF FF FF FF 01 F0 96 0B 00 08 01 9A"; //调阅相位序列27	命令编号 23
	public final static String cmd_dyxw28 = "FF FF FF FF 01 F0 96 0C 00 08 01 9B"; //调阅相位序列28	命令编号 24
	public final static String cmd_dyxw29 = "FF FF FF FF 01 F0 96 0D 00 08 01 9C"; //调阅相位序列29	命令编号 25
	public final static String cmd_dyxw30 = "FF FF FF FF 01 F0 96 0E 00 08 01 9D"; //调阅相位序列30	命令编号 26
	public final static String cmd_dyxw31 = "FF FF FF FF 01 F0 96 0F 00 08 01 9E"; //调阅相位序列31	命令编号 27
	public final static String cmd_dyjs   = "FF FF FF FF 01 F0 81 00 00 10 0C 04 15 06 10 1E 03 00 01 DE"; //校时(12年4月21日星期六16点30分03秒)	 命令编号 28
	public final static String cmd_hx     = "FF FF FF FF 01 F0 A2 0A 00 08 01 A5"; //发送手动黄闪命令	 命令编号 29
	public final static String cmd_gd     = "FF FF FF FF 01 F0 A2 0B 00 08 01 A6"; //发送手动关灯命令   命令编号 30
	public final static String cmd_qh     = "FF FF FF FF 01 F0 A2 0C 00 08 01 A7"; //发送手动全红命令	 命令编号 31
	public final static String cmd_sdhxw  = "FF FF FF FF 01 F0 A2 0D 00 08 01 A8"; //发送手动换相位命令  命令编号 32
	public final static String cmd_hfkz   = "FF FF FF FF 01 F0 A2 0E 00 08 01 A9"; //发送恢复信号机控制命令	  命令编号 33 自动
	public final static String cmd_qcll   = "FF FF FF FF 01 F0 A2 0F 00 08 01 AA"; //发送清除累计流量命令  命令编号 34
	public final static String cmd_dylct  = "FF FF FF FF 01 F0 92 04 00 08 01 8F"; //35
	public final static String cmd_update = "FF FF FF FF 01 F0 A2 17 00 0A 00 15 01 c9" ;//36
	public final static String cmd_qkll     = "FF FF FF FF 01 F0 A2 0F 00 08 01 AA"; //37  清空累计流量
	public static String getCommandStr(int i)
	{
		switch (i) {
		case 0:
			return cmd_dy;
		case 1:
			return cmd_tzdy;
		case 2:
			return cmd_dysy;	
		case 3:
			return cmd_dygz;
		case 4:
			return cmd_hfmr;
		case 5:
			return cmd_dygg;
		case 6:
			return cmd_dypt1;
		case 7:
			return cmd_dypt2;
		case 8:
			return cmd_dyzr1;
		case 9:
			return cmd_dyzr2;
		case 10:
			return cmd_dyts1;
		case 11:
			return cmd_dyts2;
		case 12:
			return cmd_dyxw16;
		case 13:
			return cmd_dyxw17;
		case 14:
			return cmd_dyxw18;
		case 15:
			return cmd_dyxw19;
		case 16:
			return cmd_dyxw20;
		case 17:
			return cmd_dyxw21;
		case 18:
			return cmd_dyxw22;
		case 19:
			return cmd_dyxw23;
		case 20:
			return cmd_dyxw24;
		case 21:
			return cmd_dyxw25;
		case 22:
			return cmd_dyxw26;
		case 23:
			return cmd_dyxw27;
		case 24:
			return cmd_dyxw28;
		case 25:
			return cmd_dyxw29;
		case 26:
			return cmd_dyxw30;
		case 27:
			return cmd_dyxw31;
		case 28:
			return cmd_dyjs;
		case 29:
			return cmd_hx;
		case 30:
			return cmd_gd;
		case 31:
			return cmd_qh;
		case 32:
			return cmd_sdhxw;
		case 33:
			return cmd_hfkz;
		case 34:
			return cmd_qcll;
		case 35:
			return cmd_dylct;
		case 36:
			return cmd_update;
		case 37:
			return cmd_qkll;
		default:
			break;
		}
		return "";
	}
	
	public static byte[] handleCommand(int index)
	{
		String[] cmds = getCommandStr(index).split(" ");
        byte[] aaa = new byte[cmds.length];
        int i = 0;
        for (String b : cmds) {
            if (b.equals("FF")) {
                aaa[i++] = -1;
            } else {
                aaa[i++] = Integer.valueOf(b, 16).byteValue();;
            }
        }
        return aaa;
	}
	public static void executeCommand(int i, String curruntSigNumber, List<IoSession> list)
	{
		for(int j=0;j<list.size();j++)
		{
			/*if(list.get(j).getRemoteAddress().toString().contains(curruntSigIp))
			{
				list.get(j).write(IoBuffer.wrap(handleCommand(i)));
			}*/
			if(list.get(j).getAttribute("number").equals(curruntSigNumber))
			{
				list.get(j).write(IoBuffer.wrap(handleCommand(i)));
			}
		}
	}
	
	public static void executeCommand(int commandId, IoSession currentSession)
	{
		currentSession.write(IoBuffer.wrap(handleCommand(commandId)));
	}

}
