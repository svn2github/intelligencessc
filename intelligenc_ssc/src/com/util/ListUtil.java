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

	// resList = numList - numlist2
	public static List<Integer> subList(List<Integer> numList,
			List<Integer> numList2) {
		List<Integer> resList = new ArrayList<Integer>();
		for (int vv : numList) {
			if (numList2.indexOf(vv) == -1) {
				resList.add(vv);
			}
		}

		return resList;
	}

	public static List<Integer> addList(List<Integer> alist, List<Integer> blist) {
		List<Integer> resList = new ArrayList<Integer>();
		for (int m : alist) {
			resList.add(m);
		}
		for (int n : blist) {
			resList.add(n);
		}

		return resList;

	}

	// 找出最近的五个不相同的数,remove 掉

	public static List<Integer> getMaxFive(List<Integer> alist) {
		List<Integer> s1 = new ArrayList<Integer>();
		s1.add(0);
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(8);
		s1.add(9);

		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		numList = revertList(alist);
		for (int i : numList) {
			if (tmpList.indexOf(i) == -1 && tmpList.size() < 5) {
				tmpList.add(i);
			}

		}
		
		resList = subList(s1, tmpList);
		System.out.println(tmpList);
		System.out.println(resList);
		return resList;
	}

	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		List<Integer> s1 = new ArrayList<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(2);
		s1.add(2);
		s1.add(2);
		s1.add(3);
		s1.add(4);

		getMaxFive(s1);

		List<Integer> s2 = new ArrayList<Integer>();
		s2.add(1);
		s2.add(11);
		s2.add(3);
		s2.add(1);
		s = subList(s1, s2);

		// System.out.println(s);
	}

}
