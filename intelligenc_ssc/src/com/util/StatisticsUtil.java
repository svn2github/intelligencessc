package com.util;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {
	
	
	// 统计0-9 在一段list中出现的次数.
	public static List<Integer> getStatistics(List<Integer> numList) {
		List<Integer> tmpList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int tvalue : numList) {
				if (tvalue == i) {
					count ++;
				}
			}
			tmpList.add(count);
			System.out.println(i+"--"+count);
		}
		return tmpList;
	}
	
	
	public static void main(String[] args) {
		List<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(0);tmpList.add(2);tmpList.add(2);tmpList.add(2);
		getStatistics(tmpList);
		
	}

}
