package com.onlyted;

import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class Assembly {
	
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> resList1 = new ArrayList<Integer>();
		List<Integer> resList2 = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		
		int hit1 = 0;// hit
		int hit2 = 0;
		int nhit1 = 0;
		int nhit2 = 0;
		
		numList = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		resList1 = getSCHitList01(numList, 10, 6, 18, 1);
		resList2 = getSCHitList02(numList, 10, 6, 18, 1);
		
		for(int i = 0; i<resList1.size();i++){
			if (i < 20){
				resList.add(resList1.get(i));
			}else{
				hit1=ConditionUtil.getHitDepth(resList2.subList(i-15, i-1));
				nhit1 =ConditionUtil.getNotHitDepth(resList2.subList(i-15, i-1));
//				if (hit1 < 18 && hit1 > 0){
//					resList.add(resList2.get(i));
//				}else 
					if(nhit1 != 0){
					resList.add(resList1.get(i));
				}else{
					resList.add(resList2.get(i));
				}
			}
		}
		
		System.out.println(resList.size());
		System.out.println(0+"----"+getRate(resList, 0));
		System.out.println(1+"----"+getRate(resList, 1));
		System.out.println(2+"----"+getRate(resList, 2));
		System.out.println(3+"----"+getRate(resList, 3));
		System.out.println(4+"----"+getRate(resList, 4));
		System.out.println(5+"----"+getRate(resList, 5));
		System.out.println(6+"----"+getRate(resList, 6));
		System.out.println(7+"----"+getRate(resList, 7));
		System.out.println(8+"----"+getRate(resList, 8));
		System.out.println(9+"----"+getRate(resList, 9));
		System.out.println(10+"----"+getRate(resList, 10));
		System.out.println(11+"----"+getRate(resList, 11));
		System.out.println(12+"----"+getRate(resList, 12));
		System.out.println(13+"----"+getRate(resList, 13));
		System.out.println(14+"----"+getRate(resList, 14));
		
	}
		
		

	public static List<Integer> getSCHitList01(List<Integer> numList,
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
			tmplist = numList.subList(i - a, i - b);
			ssList = StatisticsUtil.statisticsSort(tmplist);
			

			if (ConditionUtil.getNotHitDepth(tmpRes) > fail_num) {
				tagList = ssList.subList(0, 5);
				
			} else {
				tagList = ssList.subList(5, 10);
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

	public static List<Integer> getSCHitList02(List<Integer> numList,
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


}
