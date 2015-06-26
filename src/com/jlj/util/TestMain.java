package com.jlj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		  	String dateStr = "";   
		  	Date date = new Date();   
	        //format的格式可以任意   
	        DateFormat sdf = new SimpleDateFormat("yy/MM/dd/HH/mm/ss");   
	        try {   
	            dateStr = sdf.format(date);   
	            String[] dates = dateStr.split("/");
	            List<Integer> dateNumber = new ArrayList<Integer>();
	            for(int i=0;i<dates.length;i++)
	            {
	            	dateNumber.add(Integer.parseInt(dates[i]));
	            }
	            for(int i=0;i<dateNumber.size();i++)
	            {
	            	System.out.println(dateNumber.get(i));
	            }
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
	        
	}

}
