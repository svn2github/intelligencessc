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

	public static List<Integer> getYLList(List<Integer> numList) {

		List<Integer> ylList = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			ylList.add(getYLcount(i, numList));
		}

		return ylList;
	}

	//升序
	//获得遗漏最大的七个数
	public static List<Integer> get7maYL(List<Integer> numList) {
		int tmp;
		int tmp2;
		List<Integer> taglist = new ArrayList<Integer>();
		for (int m = 0; m <= 9; m++) {
			taglist.add(m);
		}

		for (int i = 0; i < numList.size(); i++)
			for (int j = 0; j < numList.size() - i - 1; ++j) {
				if (numList.get(j) > numList.get(j + 1)) {
					tmp = numList.get(j);
					numList.set(j, numList.get(j + 1));
					numList.set(j + 1, tmp);
					
					tmp2 = taglist.get(j);
					taglist.set(j, taglist.get(j + 1));
					taglist.set(j + 1, tmp2);
				}

			}

		taglist = taglist.subList(0, 7);
		return taglist;
	}

	public static void main(String[] args) {
		List<Integer> taglist = new ArrayList<Integer>();
		for (int i = 9; i >= 0; i--) {
			taglist.add(i);
		}
		getYLcount(2,taglist);
		

	}

}
