package com.jlj.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AbocPayUtil {
//	private String requestid;
//	private String openid;
//	private int amount;
//	private String param;
//	private int type;
//	private String redirect;
//	private String sign;
	private static String key="1234567890";
	/**
	 * 目前需传递进来三个参数：amount、redirect
	 * @param requestid
	 * @param openid
	 * @param amount
	 * @param param
	 * @param type
	 * @param redirect
	 * @return
	 * @throws Exception
	 */
	
	public static Boolean abocPay(String requestid,String openid,int amount,String param,int type, String redirect) throws Exception{
		//默认测试63
		openid="63";
		
		//requestid=必填（ON+时间戳+随机数）
		requestid="ON"+getTimeStamp()+"_"+(int)(Math.random()*100);
		
		//type=必填，0：请求移动版支付、1：请求PC版支付
		type=0;
		//redirect=必填（urlencode后全转成大写）
		redirect = URLEncoder.encode(redirect, "utf-8").toUpperCase();
		
		//签名（sign）参数的生成：md5（requestid+openid+amount+param+type+redirect+key)
		String sign= ToolkitUtil.generatePassword(requestid+openid+amount+param+type+redirect+key);
		
		
		
		//组装请求地址
		String abocurl = "http://www.1paper.org/portal.php?mod=happyfarm&op=happyfarm&requestid="+requestid+"&openid="+openid+"&amount="+amount+"&param="+param+"&type="+type+"&redirect="+redirect+"&sign="+sign;
		//String abocurl = "http://www.1paper.org/portal.php?mod=happyfarm&op=happyfarm&requestid=ON20150313163121624_15&openid=63&amount=1&param=&type=0&redirect=HTTP%3A%2F%2F127.0.0.1%2FFARM%2FINTERFACE%2FPAY%2F0&sign=b9b884d51b2c7ed93838d208d5e802a2";
		System.out.println("=================="+abocurl);
		//发送请求
		URL getUrl = new URL(abocurl); 

        // 根据拼凑的URL，打开连接，URL.openConnection()函数会根据 URL的类型，返回不同的URLConnection子类的对象，在这里我们的URL是一个http，因此它实际上返回的是HttpURLConnection 

        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); 

        // 建立与服务器的连接，并未发送数据 

        connection.connect(); 

        // 发送数据到服务器并使用Reader读取返回的数据 

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 

        System.out.println(" ============================= "); 

        System.out.println(" Contents of get request "); 

        System.out.println(" ============================= "); 

        String lines; 

        while ((lines = reader.readLine()) != null) { 

                System.out.println(lines); 

        } 

        reader.close(); 

        // 断开连接 

        connection.disconnect(); 

        System.out.println(" ============================= "); 

        System.out.println(" Contents of get request ends "); 

        System.out.println(" ============================= "); 
		return true;
	}
	
	public static String getTimeStamp(){  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
        return sdf.format(new Date());  
    }  
	
	public static void main(String[] args) {
		try {
			Boolean bool = AbocPayUtil.abocPay("", "", 1, "", 0, "");
			System.out.println(bool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
