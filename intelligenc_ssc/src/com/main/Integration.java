package com.main;

import java.util.ArrayList;
import java.util.List;

import com.condition.StatisticsCondition;
import com.condition.YLcondition;

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
	private static int getHitDepth(List<Integer> numList){
		
		return 0;
	}
	
	private static int getNotHitDepth(List<Integer> numList){
		
		return 0;
	}

}
