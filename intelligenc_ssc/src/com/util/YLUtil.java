package com.util;

import java.util.ArrayList;
import java.util.List;

public class YLUtil {

	public static int getYLcount(int a, List<Integer> numList) {
		int ylcs = 0;
		for (int m = 0; m < numList.size(); m++) {
			if (a != numList.get(m)) {
				ylcs++;
			} else {
				break;
			}
		}

		return ylcs;
	}

	// 按照遗漏顺序降序
	public static List<Integer> ylListSort(List<Integer> numList) {
		int tmp;
		int tmp2;
		numList = ListUtil.revertList(numList);
        System.out.println("revert :"+numList);
		List<Integer> ylList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();

		for (int i = 0; i <= 99; i++) {
			ylList.add(getYLcount(i, numList));
		}

		System.out.println("yllist"+ylList);
		for (int m = 0; m <= 99; m++) {
			taglist.add(m);
		}

		for (int i = 0; i < ylList.size(); i++)
			for (int j = 0; j < ylList.size() - i - 1; ++j) {
				if (ylList.get(j) >= ylList.get(j + 1)) {
					tmp = ylList.get(j);
					ylList.set(j, ylList.get(j + 1));
					ylList.set(j + 1, tmp);

					tmp2 = taglist.get(j);
					taglist.set(j, taglist.get(j + 1));
					taglist.set(j + 1, tmp2);
				}

			}

		return taglist;
	}

	public static void main(String[] args) {
		List<Integer> taglist = new ArrayList<Integer>();
		for (int i = 99; i >= 0; i--) {
			taglist.add(i);
		}
		taglist.set(98, 12);
		taglist.set(95, 12);
		System.out.println("taglist::"+taglist);
		System.out.println("yl::"+getYLcount(12, taglist));
		System.out.println(ylListSort(taglist));
		

	}

}
