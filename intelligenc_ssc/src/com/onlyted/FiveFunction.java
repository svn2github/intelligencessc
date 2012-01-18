package com.onlyted;

import java.util.ArrayList;
import java.util.List;
import com.condition.ConditionUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class FiveFunction {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> multiList = new ArrayList<Integer>();
		numList = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		resList = getSCHitList_ted(numList, 10, 6, 16, 1);
		tagList = getRate(resList, 1);
//		int pro = 0;
//		int cost = 0;
//		
//		multiList = getMulti(resList);
//
//		for (int i = 0; i < resList.size(); i++) {
//			int m = resList.get(i);
//			int n = multiList.get(i);
//				cost += 10 * n;
//				if (m == 1) {
//					pro += 20 * n;
//				
//			}
//		}
		
		System.out.println(tagList);
//		System.out.println(cost + "---" + pro);

	}

	/* 3
	 * 7
	 * 15
	 * 34
	 * 77
	 * 173
	 * 389
	 */
	public static List<Integer> getMulti(List<Integer> resList) {
		List<Integer> multiList = new ArrayList<Integer>();
		int depth1 = 0;// hit
		int depth2 = 0;

		multiList.add(1);
		multiList.add(1);
		for (int i = 2; i < resList.size(); i++) {

			if (i < 11) {
				depth1 = ConditionUtil.getHitDepth(resList.subList(0, i));
				depth2 = ConditionUtil.getNotHitDepth(resList.subList(0, i));
			} else {
				depth1 = ConditionUtil.getHitDepth(resList.subList(i - 10, i));
				depth2 = ConditionUtil.getNotHitDepth(resList
						.subList(i - 10, i));
			}

			if (depth1 > 0) {
				multiList.add(3);
			} else if(depth2 >0){
				if(depth2 == 1){
					multiList.add(7);
				}else if(depth2 == 2){
					multiList.add(15);
				}else if(depth2 == 3){
					multiList.add(34);
				}else if(depth2 == 4){
					multiList.add(77);
				}else if(depth2 == 5){
					multiList.add(0);
				}else if(depth2 == 6){
					multiList.add(0);
				}else if(depth2 == 7){
					multiList.add(0);
				}else if(depth2 == 8){
					multiList.add(0);
				}else if(depth2 == 9){
					multiList.add(0);
				}else if(depth2 == 10){
					multiList.add(0);
				}else if(depth2 == 11){
					multiList.add(0);
				}else if(depth2 == 12){
					multiList.add(0);
				}else if(depth2 == 13){
					multiList.add(0);
				}else if(depth2 > 14){
					multiList.add(0);
				}

				
			}

		}

		return multiList;
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
				tagList = ssList.subList(5, 10);
				
			} else {
				tagList = ssList.subList(0, 5);
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
