package com.condition;

import java.util.ArrayList;
import java.util.List;
import com.util.YLUtil;


public class YLcondition {

	public static List<Integer> getYLHitList(List<Integer> numList) {
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();

		tagList = YLUtil.ylListSort(numList);
		
		/*----取数 begin----------------------------------*/
		tagList = tagList.subList(3, 10);
		/*----取数 end----------------------------------*/

		
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
