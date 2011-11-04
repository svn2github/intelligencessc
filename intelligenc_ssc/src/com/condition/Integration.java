package com.condition;

import java.util.ArrayList;
import java.util.List;

public class Integration {

	public static List<Integer> getResList(List<Integer> numList) {

		List<Integer> resList = new ArrayList<Integer>();

		List<Integer> resList1 = new ArrayList<Integer>();
		List<Integer> resList2 = new ArrayList<Integer>();

		int hit1 = 0;
		int hit2 = 0;
		resList1 = YLcondition.getYLHitList(numList);
		resList2 = StatisticsCondition.getSCHitList(numList);

		int len = resList1.size();

		if (resList1.size() != resList2.size()) {
			System.err.println("error");
		}

		for (int i = 120; i < len; i++) {
			List<Integer> tmplist1 = new ArrayList<Integer>();
			List<Integer> tmplist2 = new ArrayList<Integer>();
			tmplist1 = resList1.subList(i - 30, i);
			tmplist2 = resList2.subList(i - 30, i);
			hit1=ConditionUtil.getHitDepth(tmplist1);
			hit2=ConditionUtil.getHitDepth(tmplist2);
			if(hit1 <= hit2){
				resList.add(resList2.get(i));
			}else{
				resList.add(resList1.get(i));
			}

		}

		return resList;
	}

}
