package com.condition;

import java.util.List;

public class ConditionUtil {
	public static boolean checksuit(int a, List<Integer> numlist) {
		boolean tag = false;
		for (int i : numlist) {
			if (a == i) {
				tag = true;
			}
		}
		return tag;
	}
	
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
