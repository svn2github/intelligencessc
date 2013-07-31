package hou2;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;
import com.util.SrcUtil;

public class Hou2Main {

	// 按照时间升序
	// list 0 - 2011-10-01 -123
	// list 1 - 2011-10-02 -112
	public static void main(String[] args) {
		// List<Integer> testList = new ArrayList<Integer>();
		// testList.add(1);
		// testList.add(1);
		// testList.add(0);
		// testList.add(0);
		// List<Integer> r = new ArrayList<Integer>();
		// r = ylListSort(testList,10);
		// System.out.println(r);

		List<Integer> listn = new ArrayList<Integer>();//

		List<Integer> list3 = new ArrayList<Integer>();// 十
		List<Integer> list4 = new ArrayList<Integer>();// 个

		
		List<Integer> list2 = new ArrayList<Integer>();// 百
		
		list3 = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		List<Integer> list = new ArrayList<Integer>();
		int len = list3.size();

		for (int i = 0; i < len; i++) {
			int a = list3.get(i);
			int b = list4.get(i);
			int c = a * 10 + b;
			list.add(c);
		}

		int count = 0;

		List<Integer> retList = new ArrayList<Integer>();
		for (int i = 200; i < len - 1; i++) {

			List<Integer> tl3 = new ArrayList<Integer>();
			List<Integer> tl4 = new ArrayList<Integer>();

			tl3 = ylListSort(list3.subList(i - 30, i - 1), 10);
			tl4 = ylListSort(list4.subList(i - 30, i - 1), 10);

			int a3 = tl3.get(1);
			int a4 = tl4.get(1);

			int h3 = list3.get(i);
			int h4 = list4.get(i);

			boolean tag = false;
			
			if (h3 == 1 || h3 == 9||h3 == 0 || h3 == 6|| h3 == 2 || h3 == 4 || h3 == 8  ) {
				tag = true;
			}
			

			if (tag) {
				retList.add(1);
			} else {
				retList.add(0);
			}

		}
		System.out.println(retList);
		
		List<Integer> hList = new ArrayList<Integer>();
		List<Integer> proList = new ArrayList<Integer>();   //周期累计
		
		List<Integer> costList = new ArrayList<Integer>();  //周期累计
		proList.add(0);
		costList.add(0);
		for  (int i = 1; i < retList.size(); i ++){
			int a = retList.get(i);
			int pro = proList.get(i-1);
			int cost = costList.get(i-1);
			
			if (a == 0 ){
				if (pro > 0){
					proList.add(5);
				}
				
			}else if (a == 1){
				proList.add(5);
				costList.add(14);
			}
		}
		
		

	}
	
	
	public static double getOneS(double t) {
		double temp = t * 10;
		int it = (int) temp;
		double r = (double) it / 10;
		return r;
	}

	public static int getHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int count = 0;
		int res = 0;
		for (int i = 0; i < numList.size(); i++) {
			res += numList.get(i);
			if (res < i + 1) {
				break;
			}
			count++;
		}
		return count;

	}

	public static int getNotHitDepth(List<Integer> numList) {
		int rest = 0;
		int count = 0;
		for (int i = 0; i < numList.size(); i++) {
			rest += numList.get(i);

			if (rest > 0) {
				break;
			}
			count++;
		}
		return count;
	}

	//
	public static List<Integer> merger2(List<Integer> numList1,
			List<Integer> numList2) {
		List<Integer> retList = new ArrayList<Integer>();
		int len1 = numList1.size();
		int len2 = numList2.size();
		for (int i = 0; i < len1; i++) {
			int a = numList1.get(i);
			for (int j = 0; j < len2; j++) {
				int b = numList2.get(j);
				int c = a * 10 + b;
				retList.add(c);
			}
		}
		return retList;
	}

	// 按照遗漏顺序降序 //按照出现顺序排序 降序
	public static List<Integer> ylListSort(List<Integer> numList, int len) {
		int tmp;
		int tmp2;
		numList = ListUtil.revertList(numList);
		List<Integer> ylList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();

		for (int i = 0; i < len; i++) {
			ylList.add(getYLcount(i, numList));
		}

		for (int m = 0; m < len; m++) {
			taglist.add(m);
		}

		for (int i = 0; i < ylList.size(); i++)
			for (int j = 0; j < ylList.size() - i - 1; ++j) {
				if (ylList.get(j) >= ylList.get(j + 1)) {
					tmp = ylList.get(j);
					ylList.set(j, ylList.get(j + 1));
					ylList.set(j + 1, tmp);

					tmp2 = taglist.get(j);
					taglist.set(j, taglist.get(j + 1));
					taglist.set(j + 1, tmp2);
				}

			}

		return taglist;
	}

	public static int getYLcount(int a, List<Integer> numList) {
		int ylcs = 0;
		for (int m = 0; m < numList.size(); m++) {
			if (a != numList.get(m)) {
				ylcs++;
			} else {
				break;
			}
		}

		return ylcs;
	}

}
