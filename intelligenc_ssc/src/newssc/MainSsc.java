package newssc;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;
import com.util.SrcUtil;

public class MainSsc {

	public static void main(String[] args) {

		List<Integer> listn = new ArrayList<Integer>();//

		List<Integer> list0 = new ArrayList<Integer>();// 万
		List<Integer> list1 = new ArrayList<Integer>();// 千
		List<Integer> list2 = new ArrayList<Integer>();// 百
		List<Integer> list3 = new ArrayList<Integer>();// 十
		List<Integer> list4 = new ArrayList<Integer>();// 个

		list0 = SrcUtil.readFileSingle("src/cqssc.txt", 0);
		list1 = SrcUtil.readFileSingle("src/cqssc.txt", 1);
		list2 = SrcUtil.readFileSingle("src/cqssc.txt", 2);
		list3 = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);

		int len = list0.size();

		// 万,千,百,十,个
		for (int i = 0; i < len; i++) {
			listn.add(list0.get(i));
			listn.add(list1.get(i));
			listn.add(list2.get(i));
			listn.add(list3.get(i));
			listn.add(list4.get(i));

		}
		System.out.println(listn.size());

		List<Integer> tlist = new ArrayList<Integer>();
		for (int j = 30; j < listn.size(); j += 5) {
			List<Integer> li = new ArrayList<Integer>();
			li = listn.subList(j - 30, j);

			List<Integer> tmpl = new ArrayList<Integer>();
			
			tmpl = statisticsSort(li);

			int tmpn = tmpl.get(9);
//            int tmpn =0;
			int mm = 0;

			if (tmpn == listn.get(j)) {
				mm++;
			}
			if (tmpn == listn.get(j + 1)) {
				mm++;
			}
			if (tmpn == listn.get(j + 2)) {

				mm++;
			}
			if (tmpn == listn.get(j + 3)) {
				mm++;
			}
			if (tmpn == listn.get(j + 4)) {
				mm++;
			}

				tlist.add(mm);
			

		}

		List<Integer> tslist = new ArrayList<Integer>();
		tslist = getRate(tlist, 21);
		
		System.out.println(tslist);
		int tmpc = 0;
		for (int ss : tlist) {
			tmpc += ss;
		}
		
		System.out.println(tlist);

		System.out.println(tmpc + "------------------" + tlist.size());

	}

	public static List<Integer> getRate(List<Integer> resList, int len) {
		List<Integer> tagList = new ArrayList<Integer>();
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 25; i++) {

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

	// 统计0-9 在一段list中出现的次数.
	// 按出现次数排序降序
	public static List<Integer> statisticsSort(List<Integer> numList) {

		Integer tmps[] = new Integer[10];
		;
		List<Integer> taglist = new ArrayList<Integer>();

		// 统计0,9 在numlist中出现的次数.
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int tvalue : numList) {
				if (tvalue == i) {
					count++;
				}
			}
			tmps[i] = count;

		}

		Integer tags[] = new Integer[10];
		for (int m = 0; m < 10; m++) {
			tags[m] = m;
		}

		// 按出现的次数排序.降序
		for (int i = 0; i < tmps.length; i++) {
			for (int j = i + 1; j < tmps.length; j++) {
				if (tmps[i] < tmps[j]) {
					int temp = tmps[i];
					tmps[i] = tmps[j];
					tmps[j] = temp;

					int tag = tags[i];
					tags[i] = tags[j];
					tags[j] = tag;
				}

			}
		}

		for (int s : tags)
			taglist.add(s);

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

	// 按照遗漏顺序降序
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

}
