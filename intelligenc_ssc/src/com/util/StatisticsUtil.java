package com.util;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {

	// 统计0-9 在一段list中出现的次数.
	// 按出现次数排序降序
	public static List<Integer> statisticsSort(List<Integer> numList) {

		int tmp;
		int tmp2;

		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int tvalue : numList) {
				if (tvalue == i) {
					count++;
				}
			}
			tmpList.add(count);
		}

		for (int m = 0; m < 10; m++) {
			taglist.add(m);
		}

		for (int i = 0; i < tmpList.size(); i++)
			for (int j = 0; j < tmpList.size() - i - 1; ++j) {
				if (tmpList.get(j) > tmpList.get(j + 1)) {

					tmp = tmpList.get(j);
					System.out.println(j);
					tmpList.set(j, tmpList.get(j + 1));
					numList.set(j + 1, tmp);

					tmp2 = taglist.get(j);
					taglist.set(j, taglist.get(j + 1));
					taglist.set(j + 1, tmp2);
				}

			}

		return taglist;

	}

	public static void main(String[] args) {
		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();
		tmpList.add(0);
		tmpList.add(2);
		tmpList.add(2);
		tmpList.add(2);
		taglist = statisticsSort(tmpList);
		for (int i = 0; i < taglist.size(); i++) {
			System.out.println(i + "---" + taglist.get(i));
		}

	}

}
