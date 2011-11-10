package com.condition;

import java.util.ArrayList;
import java.util.List;
import com.util.StatisticsUtil;

public class StatisticsCondition {

	public static List<Integer> getSCHitList(List<Integer> numList) {
		List<Integer> tmplist = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();

		for (int i = 100; i < numList.size(); i++) {
			int num = numList.get(i);
			tmplist = numList.subList(i-26, i);
			tagList = StatisticsUtil.statisticsSort(tmplist);
			
			/*----取数 begin----------------------------------*/
			tagList = tagList.subList(2, 10);
			/*----取数 end----------------------------------*/

			if (ConditionUtil.checksuit(num, tagList)) {
				resList.add(1);
			} else {
				resList.add(0);
			}
		}

		return resList;
	}

	
}
