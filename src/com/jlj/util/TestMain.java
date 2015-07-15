package com.jlj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.registry.infomodel.User;

import com.jlj.model.Usero;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * test greenroad getUsefulPhase
		 */
		/*String s = "0_1_0.5";
		String phaseString = "20,0,20";
		if(phaseString.substring(0, 1)!=null&&!phaseString.substring(0, 1).equals("0"))
		{
			int firstIndex = phaseString.indexOf(",0");
			if(firstIndex!=-1)
			{
				phaseString = phaseString.substring(0,firstIndex);
			}
			String[] usefulPhase = phaseString.split(",");
			for(int i=0;i<usefulPhase.length;i++)
			{
				System.out.println(usefulPhase[i]);
			}
		}*/
		
		
		//System.out.println(3689/3600);
		  /*
		   */
//		Object obj = null;
//		obj.equals(""); 
		
		int a = 0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString1=sdf.format(new Date());
		System.out.println(dateString1);
		List<Usero> useros = new ArrayList<Usero>();
		for (int i = 0; i < 300000; i++) {
			Usero usero = new Usero();
			usero.setId(i);
			usero.setUsername("asd");
			usero.setPassword("asd");
			usero.setUlimit(1);
			usero.setUip("192.168.1.21");
			useros.add(usero);
		}
		for (int i = 0; i < useros.size(); i++) {
			a  = a + useros.get(i).getId();
		}
		System.out.println(a);
		String dateString2=sdf.format(new Date());
		System.out.println(dateString2);
	}

}
