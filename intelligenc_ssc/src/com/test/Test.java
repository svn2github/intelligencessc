package com.test;

import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;

public class Test {
	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> scList = new ArrayList<Integer>();
		resList.add(1);
		resList.add(1);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(1);
		resList.add(0);
		scList = getMulti(resList);
		System.out.println(scList);
	}

	public static List<Integer> getMulti(List<Integer> resList) {
		List<Integer> multiList = new ArrayList<Integer>();
		int depth1 = 0;// hit
		int depth2 = 0;

		multiList.add(1);
		multiList.add(1);
		for (int i = 2; i < resList.size(); i++) {
			
			depth1 = ConditionUtil.getHitDepth(resList.subList(0, i - 1));
			depth2 = ConditionUtil.getNotHitDepth(resList.subList(0, i - 1));
			
			if (resList.size() < 20) {
				if (depth1 > 0) {
					if (depth1 >= 2) {
						multiList.add(1);
					} else if (depth1 == 1) {
						multiList.add(multiList.get(i - 1));
					}
				} else {

					if (depth2 == 0){
						multiList.add(1);
					}
					else if (depth2 == 1) {

						int m = multiList.get(i - 1);
						if (m == 1) {
							multiList.add(2);
						} else if (m == 2) {
							multiList.add(4);
						} else if (m == 3) {
							multiList.add(8);
						} else if (m == 4) {
							multiList.add(12);
						} else if (m >= 5) {
							multiList.add(20);
						}

					} else if (depth2 == 2) {
						if (multiList.get(i - 1) == 2) {
							multiList.add(4);
						} else {
							multiList.add(2);
						}
					} else if (depth2 == 3) {
						if (multiList.get(i - 1) == 4) {
							multiList.add(8);
						} else {
							multiList.add(4);
						}
					} else if (depth2 == 4) {
						if (multiList.get(i - 1) == 8) {
							multiList.add(12);
						} else {
							multiList.add(8);
						}
					} else if (depth2 == 5) {
						if (multiList.get(i - 1) == 12) {
							multiList.add(20);
						} else {
							multiList.add(12);
						}
					} else if (depth2 > 5) {
						multiList.add(20);
					}
				}

			} else {

			}

		}

		return multiList;
	}

}
