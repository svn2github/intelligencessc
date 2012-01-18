package autoTest;

import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class Hi7 {
	public static void main(String[] args) {
		List<Integer> tmlist = new ArrayList<Integer>();
		tmlist.add(1);
		tmlist.add(2);
		tmlist.add(4);
		tmlist.add(10);
		tmlist.add(20);
		// for (int m = 1;m<50;m++ ){
		// tmlist.add(20);
		// }
		//
		System.out.println(tmlist);
		List<Integer> testlist = new ArrayList<Integer>();
		testlist.add(1);
		testlist.add(3);
		testlist.add(5);
		testlist.add(7);
		testlist.add(9);
		testlist.add(0);
		testlist.add(2);

		List<Integer> listm = new ArrayList<Integer>();
		List<Integer> reslist = new ArrayList<Integer>();
		listm = SrcUtil.readFileSingle("src/cqssc.txt", 2);

		for (int num : listm) {
			if (ConditionUtil.checksuit(num, testlist)) {
				reslist.add(1);
			} else {
				reslist.add(0);
			}
		}

		System.out.println(reslist);

		List<Integer> bslist = new ArrayList<Integer>();
		bslist.add(1);

		bslist.add(2);
		

		for (int i = 3; i < reslist.size(); i++) {
			int snum = reslist.get(i - 1);
			int bs1 = bslist.get(i-1);
			//为中
			if (snum == 0) {
//				bslist.add(bslist.get(i-1));
				getbs(bs1,tmlist);
			} else {
				bslist.add(bs1);
			}

		}
		System.out.println(bslist);

		int cost = 0;
		int re = 0;
		for (int jj = 0; jj < bslist.size(); jj++) {
			int m = reslist.get(jj);
			int n = bslist.get(jj);

			cost += 10 * n;
			if (m == 1) {
				re += n * 19;
			}

		}

		int cc = 0;
		for (int mk : bslist) {
			if (mk > cc)
				cc = mk;
		}
		System.err.println(cc);
		System.out.println(cost + "====" + re);

	}

	public static int getbs(int bs, List<Integer> numList) {

		int tm = 0;
		for (int i = 0; i < numList.size() - 1; i++) {
			if (bs == numList.get(i)) {
				tm = numList.get(i + 1);
				break;
			}
		}
		return tm;

	}

	public static int getbs_2(int bs, List<Integer> numList) {

		int tm = 0;
		for (int i = 2; i < numList.size() - 1; i++) {
			if (bs == numList.get(i)) {
				tm = numList.get(i - 1);
				break;
			}
		}
		return tm;

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

			if (res_len > 30) {

				tmpRes = resList.subList(res_len - 30, res_len);
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



}
