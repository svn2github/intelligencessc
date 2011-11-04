package com.condition;

import java.util.ArrayList;
import java.util.List;


public class Integration {
	
	public static List<Integer> getResList(List<Integer> numList) {
		
		List<Integer> resList1 = new ArrayList<Integer>();
		List<Integer> resList2 = new ArrayList<Integer>();
		
		resList1 = YLcondition.getYLHitList(numList);
		resList2 = StatisticsCondition.getSCHitList(numList);
		
		if (resList1.size() != resList2.size()){
			System.err.println("error");
		}
		
		
		return null;
	}
	
	//hit的深度0-..
	//
	private static int getHitDepth(List<Integer> numList){
		int res = 0;
		for(int i =0; i < numList.size() ; i++){
			res += numList.get(i);
			if(res < i+1){
				break;
			}
		}
		return res;
		
	}
	
	private static int getNotHitDepth(List<Integer> numList){
		int res = 0;
		for(int i =0; i < numList.size() ; i++){
			res += numList.get(i);
			if(res > 0){
				break;
			}
		}
		return res;
	}

}
