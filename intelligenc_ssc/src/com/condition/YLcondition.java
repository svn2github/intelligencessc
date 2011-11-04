package com.condition;

import java.util.ArrayList;
import java.util.List;
import com.util.YLUtil;


public class YLcondition {

	public static List<Integer> getYLHitList(List<Integer> numList) {
		List<Integer> tempList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();

		System.out.println(numList.size());

		for (int i = 100; i < numList.size(); i++) {
			int num = numList.get(i);

			tagList = YLUtil.ylListSort(tempList);

			/*----取数 begin----------------------------------*/
			tagList = tagList.subList(3, 7);
			/*----取数 end----------------------------------*/

			if (checksuit(num, tagList)) {
				resList.add(1);
			} else {
				resList.add(0);
			}
		}

		return resList;
	}

	private static boolean checksuit(int a, List<Integer> numlist) {
		boolean tag = false;

		for (int i : numlist) {
			if (a == i) {
				tag = true;
			}
		}
		return tag;
	}

}
