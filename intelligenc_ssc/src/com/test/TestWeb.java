package com.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TestWeb {

	public static String getHTML(String pageURL, String encoding) {
		List<String> numList = new ArrayList<String>();
		StringBuilder pageHTML = new StringBuilder();
		try {
			URL url = new URL(pageURL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestProperty("User-Agent", "MSIE 7.0");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encoding));
			String line = "";

			while ((line = br.readLine()) != null
					&& line.indexOf("listIssue ") != -1) {
				pageHTML.append(line);
				numList.add(line);
				pageHTML.append("\r\n");
			}
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// "	"
		// String sss[] = numList.get(0).split("	");
		// System.out.println(numList.get(0));
		// System.out.println(sss.length);
		return pageHTML.toString();
	}

	public static void main(String args[]) {
		// http://video.shishicai.cn/haoma/cqssc/list/120.aspx
		System.out
				.println(getHTML(
						"http://video.shishicai.cn/haoma/cqssc/list/120.aspx",
						"UTF-8"));
		// System.out.println(getHTML("http://www.500wan.com/static/public/ssc/txt/opencode/29.txt",
		// "UTF-8"));
		// System.out.println(getHTML("http://baidu.lehecai.com/lottery/draw/view/200?phase=&agentId=5555",
		// "GBK"));
		// try{
		// testNetStream();
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		String code = getHtml("http://video.shishicai.cn/haoma/cqssc/list/120.aspx");
		System.out.println(code);
		String se = code.substring(21, code.length()-3);
		System.out.println(se);
		String ss[] = se.split("},");
		System.out.println(ss.length);
		System.out.println("===========");
		for(String s : ss){
//			System.out.println(s);
//			System.out.println(s.substring(61,66));
			System.out.println(s.substring(22,31)+"--"+s.substring(s.length()-13,s.length()-1)+"--"+s.substring(61,66));
		}
	}

	public static String getHtml(String address) {
		String result = "";
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
			conn.setRequestProperty("Accept-Language", "GB2312");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GB2312"));
			String str = br.readLine();
			while (str != null) {
				if (str.indexOf("listIssue ") != -1) {
					result += str;
				}
				str = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	

}
