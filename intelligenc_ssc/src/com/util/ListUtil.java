package com.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	// list 逆序
	public static List<Integer> revertList(List<Integer> numList) {
		List<Integer> tempList = new ArrayList<Integer>();
		int j = 0;
		for (int i = numList.size() - 1; i >= 0; i--) {
			tempList.add(j, numList.get(i));
			j++;
		}
		return tempList;
	}

}
