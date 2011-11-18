package com.test;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.util.ArrayList;
import java.util.List;
public class TestWeb {

	    public static String getHTML(String pageURL, String encoding) { 
	    	List<String> numList = new ArrayList<String>();
	        StringBuilder pageHTML = new StringBuilder(); 
	        try { 
	            URL url = new URL(pageURL); 
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
	            connection.setRequestProperty("User-Agent", "MSIE 7.0"); 
	            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding)); 
	            String line = null; 
	            while ((line = br.readLine()) != null) { 
	                pageHTML.append(line); 
	                numList.add(line);
	                pageHTML.append("\r\n"); 
	            } 
	            connection.disconnect(); 
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	        //"	"
	        String sss[] = numList.get(0).split("	");
	        System.out.println(numList.get(0));
	        System.out.println(sss.length);
	        return pageHTML.toString(); 
	    } 
	     
	    public static void main(String args[]){ 
	    	//http://video.shishicai.cn/haoma/cqssc/list/120.aspx
	    	getHTML("http://www.500wan.com/static/public/ssc/txt/opencode/29.txt", "UTF-8");
//	        System.out.println(getHTML("http://www.500wan.com/static/public/ssc/txt/opencode/29.txt", "UTF-8"));
//	        System.out.println(getHTML("http://video.shishicai.cn/haoma/cqssc/list/120.aspx", "GBK"));
	    } 
}
