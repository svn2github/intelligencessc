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
//		int pro = 0;
//		int cost = 0;
//		
//		multiList = getMulti(resList);
//
//		for (int i = 10; i < resList.size(); i++) {
//			int m = resList.get(i);
//			int n = multiList.get(i);
//			if(n!=20 && n!=12 && n!=10 && n!=8 && n!=4){
//				cost += 14 * n;
//				if (m == 1) {
//					pro += 18 * n;
//				}
//				
//			}
//		}
		
		System.out.println(tagList);
//		System.out.println(cost + "---" + pro);

	}

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
//						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(20);
					}

				} else if (depth2 == 2) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
//						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(20);
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
						multiList.add(20);
					}

				} else if (depth2 == 4) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
//						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(20);
					}

				} else if (depth2 == 5) {
					int m = multiList.get(i - 1);
					if (m == 1) {
						multiList.add(2);
					} else if (m == 2) {
						multiList.add(4);
					} else if (m == 4) {
//						System.out.println(i);
						multiList.add(8);
					} else if (m == 8) {
						multiList.add(12);
					} else if (m == 12) {
						multiList.add(20);
					} else if (m == 20) {
						multiList.add(20);
					}

				} else if (depth2 > 5) {
					multiList.add(20);
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
			// if (ConditionUtil.getHitDepth(tmpRes) > sucess_num) {
			//
			//
			// // tagList = ssList.subList(3, 10);
			// } else

			if (ConditionUtil.getNotHitDepth(tmpRes) > fail_num) {
//				tagList = ssList.subList(0, 5);
//				tagList = ListUtil.getMaxFive(tmplist);
				tagList = 	ListUtil.subList(s1, ListUtil.getMaxFive(tmplist));
//				tagList = ListUtil.getMaxFive(tmplist);
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
//				tagList = ssList.subList(5, 10);
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
