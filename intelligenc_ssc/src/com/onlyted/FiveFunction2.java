package com.onlyted;

import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.ListUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class FiveFunction2 {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> multiList = new ArrayList<Integer>();
		numList = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		resList = getSCHitList_ted(numList, 10, 13, 29, 1);
		tagList = getRate(resList, 14);

		
		System.out.println(tagList);

	}


	public static List<Integer> getRate(List<Integer> resList, int len) {
		List<Integer> tagList = new ArrayList<Integer>();
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 20; i++) {

			int tvalue = -1;
			for (int j = 0; j < len; j++) {
				tvalue += resList.get(i + j);
			}
			if (tvalue == -1) {
				count++;
			} else {
				cc++;
			}
		}

		tagList.add(cc);
		tagList.add(count);
		return tagList;
	}

	/*
	 * from begin to end
	 */
	public static List<Integer> getSCHitList_ted(List<Integer> numList,
			int sucess_num, int fail_num, int a, int b) {
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
		List<Integer> tmplist = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		for (int i = 200; i < numList.size(); i++) {
			List<Integer> tagList = new ArrayList<Integer>();

			List<Integer> ssList = new ArrayList<Integer>();
			List<Integer> tmpRes = new ArrayList<Integer>();
			int res_len = resList.size();

			if (res_len > 10) {

				tmpRes = resList.subList(res_len - 10, res_len);
				// break;
			}

			int num = numList.get(i);
			// int snum = numList.get(i - 1);
			tmplist = numList.subList(i - a, i - b);
			ssList = StatisticsUtil.statisticsSort(tmplist);

			if (ConditionUtil.getNotHitDepth(tmpRes) > fail_num) {
				tagList = 	ListUtil.subList(s1, ListUtil.getMaxFive(tmplist));
//				
			} else {
				tagList = ListUtil.getMaxFive(tmplist);
				tagList = 	ListUtil.subList(s1, ListUtil.getMaxFive(tmplist));
			}

			if (tagList.size() > 0) {

				if (ConditionUtil.checksuit(num, tagList)) {
					resList.add(1);
				} else {
					resList.add(0);
				}
			}
		}
		return resList;
	}
}
