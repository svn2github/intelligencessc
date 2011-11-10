package com.condition;

import java.util.ArrayList;
import java.util.List;

public class Integration {

	public static List<Integer> getResList(List<Integer> numList) {

		int hit1 = 0;
		int hit2 = 0;
		int nhit1 = 0;
		int nhit2 = 0;

		List<Integer> resList = new ArrayList<Integer>();
		
		List<Integer> resList1 = new ArrayList<Integer>();
		List<Integer> resList2 = new ArrayList<Integer>();

		resList1 = YLcondition.getYLHitList(numList);
		resList2 = StatisticsCondition.getSCHitList(numList);
		

		int len = resList1.size();

		if (resList1.size() != resList2.size()) {
			System.err.println("error");
		}
		
		int nh1 = 0;
		int nh2 = 0;
		for (int i = 120; i < len; i++) {
			System.out.println(resList1.get(i)+"-------"+resList2.get(i));
			List<Integer> tmplist1 = new ArrayList<Integer>();
			List<Integer> tmplist2 = new ArrayList<Integer>();

			tmplist1 = resList1.subList(i - 11, i-1);
			tmplist2 = resList2.subList(i - 11, i-1);

			hit1 = ConditionUtil.getHitDepth(tmplist1);
			hit2 = ConditionUtil.getHitDepth(tmplist2);
			
			nhit1 = ConditionUtil.getNotHitDepth(tmplist1);
			nhit2 = ConditionUtil.getNotHitDepth(tmplist2);
			
			if (nhit1 > 11) {
				nh1++;
			}
			if (nhit2 > 11) {
				nh2++;
			}
			
//			if((hit1+hit2)%2 == 0){
//				resList.add(resList2.get(i));
//			}else{
//				resList.add(resList1.get(i));
//			}

			if (hit1 > hit2 ) {
				resList.add(resList1.get(i));
//				System.out.println(nhit1 + "****" + nhit2+"========="+resList2.get(i));
			} else if (hit2 > hit1  ) {
				resList.add(resList2.get(i));
//				System.out.println(nhit1 + "****" + nhit2+"========="+resList1.get(i));
			} else if (nhit1 < nhit2 ) {
				resList.add(resList2.get(i));
			} else if (nhit2 > nhit1 ) {
				resList.add(resList1.get(i));
			}
			 else if (i % 2 == 0) {
				resList.add(resList1.get(i));
			} else {
				resList.add(resList2.get(i));
			}

		}

		System.out.println(nh1+"-------"+nh2);
		return resList;
	}

}
