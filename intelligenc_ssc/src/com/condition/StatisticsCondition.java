package com.condition;

import java.util.ArrayList;
import java.util.List;
import com.util.StatisticsUtil;

public class StatisticsCondition {

	public static List<Integer> getSCHitList(List<Integer> numList) {
		
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		tagList = StatisticsUtil.statisticsSort(numList);
		
		/*----取数 begin----------------------------------*/
		tagList = tagList.subList(3, 10);
		/*----取数 end----------------------------------*/
       System.out.println(tagList.size()+"sc"+tagList.get(0));

		for (int i = 100; i < numList.size(); i++) {
			int num = numList.get(i);


			if (ConditionUtil.checksuit(num, tagList)) {
				resList.add(1);
			} else {
				resList.add(0);
			}
		}

		return resList;
	}

	
}
