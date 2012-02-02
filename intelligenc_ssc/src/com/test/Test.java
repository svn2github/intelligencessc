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
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(1);
		resList.add(1);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		resList.add(0);
		resList.add(0);
		resList.add(1);
		scList = getMulti(resList);
		System.out.println(scList);
	}

	/*
	 * 1     1    14   18      4
	 * 2     3    42   36     -6
	 * 4     7    98   72    -26
	 * 8     15   210  144   -66
	 * 12    27   378  216   -162
	 * 20    47   658  360   -298
	 */
	public static List<Integer> getMulti(List<Integer> resList) {
		List<Integer> multiList = new ArrayList<Integer>();
		List<Integer> proList = new ArrayList<Integer>();
		int depth1 = 0;// hit
		int depth2 = 0;
		int pro;

		multiList.add(1);
		multiList.add(1);
		proList.add(4);
		proList.add(4);
		for (int i = 2; i < resList.size(); i++) {
			
//			if(i < 11){
				depth1 = ConditionUtil.getHitDepth(resList.subList(0, i));
				depth2 = ConditionUtil.getNotHitDepth(resList.subList(0, i));
//			}
//			else{
//				depth1 = ConditionUtil.getHitDepth(resList.subList(i-10, i));
//				depth2 = ConditionUtil.getNotHitDepth(resList.subList(i-10, i));
//			}

			if (depth1 > 0) {
				if (depth1 >= 2) {
					multiList.add(1);
				} else if (depth1 == 1) {
					multiList.add(multiList.get(i - 1));
				}
			} else {

				if (depth2 == 0) {
					multiList.add(1);
				} else if (depth2 == 1) {

					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(1);
					}

				} else if (depth2 == 2) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(1);
					}

				} else if (depth2 == 3) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(1);
					}

				} else if (depth2 == 4) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(1);
					}

				} else if (depth2 == 5) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(1);
					}

				} else if (depth2 > 5) {
					multiList.add(1);
				}
			}

		}

		return multiList;
	}

}
