package com.test;

import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;

public class Test2 {
	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> scList = new ArrayList<Integer>();
		resList.add(1);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		scList = getMulti(resList);
		System.out.println(scList);
	}

	public static List<Integer> getMulti(List<Integer> resList) {
		List<Integer> multiList = new ArrayList<Integer>();
		int depth1 = 0;// hit
		int depth2 = 0;

		multiList.add(1);
		multiList.add(1);
		for (int i = 2; i < resList.size(); i++) {

			if (i < 20) {
				depth1 = ConditionUtil.getHitDepth(resList.subList(0, i));
				depth2 = ConditionUtil.getNotHitDepth(resList.subList(0, i));
			} else {
				depth1 = ConditionUtil.getHitDepth(resList.subList(i - 19, i));
				depth2 = ConditionUtil.getNotHitDepth(resList
						.subList(i - 19, i));
			}

			if (depth1 > 0) {
				multiList.add(3);
			} else if(depth2 >0){
				if(depth2 == 1){
					multiList.add(7);
				}else if(depth2 == 2){
					multiList.add(15);
				}else if(depth2 == 3){
					multiList.add(34);
				}else if(depth2 == 4){
					multiList.add(77);
				}else if(depth2 == 5){
					multiList.add(173);
				}else if(depth2 == 6){
					multiList.add(389);
				}else if(depth2 == 7){
					multiList.add(3);
				}else if(depth2 == 8){
					multiList.add(7);
				}else if(depth2 == 9){
					multiList.add(15);
				}else if(depth2 == 10){
					multiList.add(34);
				}else if(depth2 == 11){
					multiList.add(77);
				}else if(depth2 == 12){
					multiList.add(173);
				}else if(depth2 == 13){
					multiList.add(389);
				}else if(depth2 == 14){
					multiList.add(389);
				}

				
			}

		}

		return multiList;
	}

}
