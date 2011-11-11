package com.onlyted;

import java.util.ArrayList;
import java.util.List;
import com.condition.ConditionUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class OneFun {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> multiList = new ArrayList<Integer>();
		numList = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		resList = getSCHitList_ted(numList, 10, 5, 50, 1);
		tagList = getRate(resList, 8);
		int pro = 0;
		int cost = 0;

		for (int i = 10; i < resList.size(); i++) {
			List<Integer> tmpList = new ArrayList<Integer>();
			int depth1 = 0;// hit
			int depth2 = 0;// no
			tmpList = resList.subList(i - 9, i - 1);
			int num = resList.get(i);
			int ssnum = resList.get(i);
			depth1 = ConditionUtil.getHitDepth(tmpList);
			depth2 = ConditionUtil.getNotHitDepth(tmpList);
			
			if (depth1 == 1) {
				multiList.add(multiList.get(i-1));
			}
			else if (depth1 >= 2) {
				multiList.add(1);

			}else if(depth2 == 1) {
				multiList.add(2);
			}
			else if(depth2 == 2) {
				multiList.add(4);
			}
			else if(depth2 == 3) {
				multiList.add(8);
			}
			else if(depth2 == 4) {
				multiList.add(12);
			}
			else if(depth2 == 5) {
				multiList.add(20);
			}
			else if(depth2 > 5) {
				multiList.add(20);
			}

		}

		System.out.println(cost +"---"+pro);

	}
	
	public static List<Integer> getMulti(List<Integer> resList){
		List<Integer> multiList = new ArrayList<Integer>();
		int depth1 = 0;// hit
		int depth2 = 0;
		
		depth1 = ConditionUtil.getHitDepth(resList);
		depth2 = ConditionUtil.getNotHitDepth(resList);
		
		multiList.add(1);
		
		for(int i = 1; i<resList.size();i++){
			if(multiList.size()<10){
				if(depth1 > 0){
					if(depth1 >= 3){
						multiList.add(1);
					}else if(depth1 == 1){
						multiList.add(multiList.get(i-1));
					}else if(depth1 == 2){
						multiList.add(multiList.get(i-1));
					}
				}else{
					if(depth2 == 1 ){
						if(multiList.get(i-1) == 1){
							multiList.add(2);
						}else{
							multiList.add(multiList.get(i-1));
						}
						
					}
					else if(depth2 == 2){
						if(multiList.get(i-1) == 2){
							multiList.add(4);
						}else{
							multiList.add(2);
						}
					}
					else if(depth2 == 3){
						if(multiList.get(i-1) == 4){
							multiList.add(8);
						}else{
							multiList.add(4);
						}
					}
					else if(depth2 == 4){
						if(multiList.get(i-1) == 8){
							multiList.add(12);
						}else{
							multiList.add(8);
						}
					}
					else if(depth2 == 5){
						if(multiList.get(i-1) == 12){
							multiList.add(20);
						}else{
							multiList.add(12);
						}
					}
					else if(depth2 > 5){
							multiList.add(20);
					}
				}
				
			}else{
				
			}
			
		}
		
		
		
		return null;
	}

	public static List<Integer> getRate(List<Integer> resList, int len) {
		List<Integer> tagList = new ArrayList<Integer>();
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 10; i++) {

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
			// if (ConditionUtil.getHitDepth(tmpRes) > sucess_num) {
			//				
			//
			// // tagList = ssList.subList(3, 10);
			// } else

			if (ConditionUtil.getNotHitDepth(tmpRes) > fail_num) {
				tagList = ssList.subList(0, 7);
				// i += 2;
				// continue;
				// for (int n = 0; n < 10; n++) {
				//
				// if ((snum + a) % 10 != n && (snum + b) % 10 != n
				// && (snum + c) % 10 != n) {
				// tagList.add(n);
				// }
				//
				// }
			} else {
				tagList = ssList.subList(3, 10);
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
