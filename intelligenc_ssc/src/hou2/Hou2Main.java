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
//		List<Integer> testList = new ArrayList<Integer>();
//		testList.add(1);
//		testList.add(1);
//		testList.add(0);
//		testList.add(0);
//		List<Integer> r = new ArrayList<Integer>();
//		r = ylListSort(testList,10);
//		System.out.println(r);
		
		List<Integer> listn = new ArrayList<Integer>();//
		
		List<Integer> list3 = new ArrayList<Integer>();// 十
		List<Integer> list4 = new ArrayList<Integer>();// 个

		list3 = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		int len = list3.size();
		
		for (int i = 30;i < len -1; i ++){
			
			List<Integer> tl3 = new ArrayList<Integer>();
			List<Integer> tl4 = new ArrayList<Integer>();
			
			tl3 = ylListSort(list3.subList(i-25, i-1),10);
			tl4 = ylListSort(list4.subList(i-25, i-1),10);
			
			int a3 = tl3.get(9);
			int a4 = tl4.get(9);
			
			int h3 = list3.get(i);
			int h4 = list4.get(i);
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	// 按照遗漏顺序降序  //按照出现顺序排序 降序
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
