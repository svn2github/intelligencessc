package com.every;

import java.util.ArrayList;
import java.util.List;

//7 码 滚钱
public class Emain2 {
	public static void main(String[] args) {
		List<Integer> beishu = new ArrayList<Integer>();

		List<Integer> tmlist = new ArrayList<Integer>();

		List<Integer> nums0 = new ArrayList<Integer>();
		List<Integer> reses = new ArrayList<Integer>();

		nums0 = GetSrc.readFileSingle(4);
		List<Omit> os = new ArrayList<Omit>();
		int len = nums0.size();
		for (int i = 30; i < len - 30; i++) {

			Omit o0 = new Omit();

			// 七码
			o0 = OmitUtil.getOmitNum(nums0.subList(i - 26, i - 1), 3);
//			System.out.println(o0.getResList());

			int a0 = o0.getOmitnum();
//			System.out.println(a0);
//			System.out.print(nums0.get(i));

			if (a0 > 2) {
				Omit ot = new Omit();
				ot = OmitUtil.getOmitNum(nums0.subList(i - 27, i - 2), 3);
				List<Integer> yllist1 = new ArrayList<Integer>();
				yllist1 = ot.getResList();
//				System.out.println(yllist1);
				
				List<Integer> yllist = new ArrayList<Integer>();

				List<Integer> numlist = new ArrayList<Integer>();

				yllist = o0.getResList();
				
				numlist = nums0.subList(i, i + 30);
				
//				if(checksame(yllist,yllist1) && checksuit(nums0.get(i),yllist)){
//					reses.add(1);
//				}else {
					
					reses.add(getDoubleHit(yllist, numlist));
//				}



			}

		}
		// System.out.println(reses);
		int p = 0;
		for (int s : reses) {
			if (s > p) {
				p = s;
			}
		}

		System.out.println(reses);
		System.out.println(p);

	}

	// =======================================================

	public static int getDoubleHit(List<Integer> yllist, List<Integer> numlist) {

		int count = 0;
		for (int i = 0; i < numlist.size() - 1; i++) {
			count++;
			if (checksuit(numlist.get(i), yllist)
					&& checksuit(numlist.get(i + 1), yllist)) {
				break;
			}

		}
		count++;

		return count;
	}

	public static int getB(int cn) {

		List<Integer> s = new ArrayList<Integer>();
		s.add(1);
		s.add(2);
		s.add(2);
		s.add(7);
		s.add(7);
		s.add(26);
		s.add(26);
		s.add(96);
		s.add(96);
		s.add(354);
		s.add(354);
		s.add(1300);
		s.add(1300);

		return cn;

	}

	public static boolean checksuit(int a, List<Integer> numlist) {

		boolean tag = false;
		for (int i : numlist) {
			if (a == i) {
				tag = true;
				break;
			}
		}
		return tag;
	}

	// 列表相等
	public static boolean checksame(List<Integer> l1, List<Integer> l2) {
		int len = l1.size();
		boolean tag = true;
		for (int i = 0; i < len; i++) {
			if (l1.get(i) != l2.get(i)) {
				tag = false;
				break;
			}
		}
		return tag;
	}

}
