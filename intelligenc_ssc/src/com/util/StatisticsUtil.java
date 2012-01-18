package com.util;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {

	// 统计0-9 在一段list中出现的次数.
	// 按出现次数排序降序
	public static List<Integer> statisticsSort(List<Integer> numList) {


		Integer tmps[]= new Integer[10];;
		List<Integer> taglist = new ArrayList<Integer>();

		// 统计0,9 在numlist中出现的次数.
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int tvalue : numList) {
				if (tvalue == i) {
					count++;
				}
			}
			tmps[i] = count;
			
		}

		System.out.println("===================");
		
		Integer tags[] = new Integer[10];
		for (int m = 0; m < 10; m++) {
			tags[m] = m;
		}

		// 按出现的次数排序.降序
		for (int i = 0; i < tmps.length; i++) {  
			   for (int j = i + 1; j < tmps.length; j++) {  
			    if (tmps[i] < tmps[j]) {  
			     int temp = tmps[i];  
			     tmps[i] = tmps[j];  
			     tmps[j] = temp;  
			     
			     int tag = tags[i];  
			     tags[i] = tags[j];  
			     tags[j] = tag;
			    }  
			    
			   }   
		}

		for(int s : tags)
			taglist.add(s);
			
				
		return taglist;

	}

	public static void main(String[] args) {
		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();
		tmpList.add(9);
		tmpList.add(9);
		tmpList.add(9);
		tmpList.add(0);
		tmpList.add(0);
		taglist = statisticsSort(tmpList);
		for (int i = 0; i < taglist.size(); i++) {
			System.out.println(i + "---" + taglist.get(i));
		}

	}

}
