package com.every;

import java.util.ArrayList;
import java.util.List;

public class OmitUtil {

	public static Omit getOmitNum(List<Integer> alist, int len) {
		Omit o = new Omit();

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

		int cc = 0;
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();

		numList = ListUtil.revertList(alist);

		for (int i = 0; i < numList.size(); i++) {
			cc++;
			int tp = numList.get(i);
			if (tmpList.indexOf(tp) == -1 && tmpList.size() < len) {
				tmpList.add(tp);
			} else if (tmpList.indexOf(tp) != -1 && tmpList.size() == len) {

			} else if (tmpList.size() == len) {
				break;
			}

		}

		// for (int i : numList) {
		// cc++;
		// if ((tmpList.indexOf(i) == -1 && tmpList.size() < len)||(i.)) {
		//
		// tmpList.add(i);
		// }else if (tmpList.size() == len){
		// break;
		// }
		// }

		resList = ListUtil.subList(s1, tmpList);
		o.setOmitnum(cc - 1);
		o.setResList(resList);
		return o;

	}

	public static void main(String args[]) {
		Omit o = new Omit();
		List<Integer> s1 = new ArrayList<Integer>();
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(1);
		s1.add(0);
		s1.add(5);
		s1.add(1);
		s1.add(6);
		s1.add(9);
		s1.add(9);
		s1.add(8);
		o = getOmitNum(s1, 7);
		System.out.println(o.getOmitnum());
		System.out.println(o.getResList());
	}
}
