package com.condition;

import java.util.List;

import com.util.ListUtil;

public class ConditionUtil {
	public static boolean checksuit(int a, List<Integer> numlist) {
		numlist = ListUtil.revertList(numlist);
		boolean tag = false;
		for (int i : numlist) {
			if (a == i) {
				tag = true;
			}
		}
		return tag;
	}

	public static int getHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int count = 0;
		int res = 0;
		for (int i = 0; i < numList.size(); i++) {
			res += numList.get(i);
			if (res < i + 1) {
				break;
			}
			count++;
		}
		return count;

	}

	public static int getNotHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int rest = 0;
		int count = 0;
		for (int i = 0; i < numList.size(); i++) {
			rest += numList.get(i);
			
			if (rest > 0) {
				break;
			}
			count++;
		}
		return count;
	}

}
