package com.every;

import java.util.ArrayList;
import java.util.List;

public class EMain {
	public static void main(String[] args) {
		List<Integer> beishu = new ArrayList<Integer>();

		
		List<Integer> tmlist = new ArrayList<Integer>();

		List<Integer> nums0 = new ArrayList<Integer>();
		List<Integer> nums1 = new ArrayList<Integer>();
		List<Integer> nums2 = new ArrayList<Integer>();
		List<Integer> nums3 = new ArrayList<Integer>();
		List<Integer> nums4 = new ArrayList<Integer>();
		List<Integer> reses = new ArrayList<Integer>();

		nums0 = GetSrc.readFileSingle(0);
		nums1 = GetSrc.readFileSingle(1);
		nums2 = GetSrc.readFileSingle(2);
		nums3 = GetSrc.readFileSingle(3);
		nums4 = GetSrc.readFileSingle(4);
		List<Omit> os = new ArrayList<Omit>();
		int len = nums0.size();
		int cc = 0;

		for (int i = 30; i < len - 1; i++) {

			Omit o0 = new Omit();
			Omit o1 = new Omit();
			Omit o2 = new Omit();
			Omit o3 = new Omit();
			Omit o4 = new Omit();

			o0 = OmitUtil.getOmitNum(nums0.subList(i - 26, i - 1), 5);
			o1 = OmitUtil.getOmitNum(nums1.subList(i - 26, i - 1), 5);
			o2 = OmitUtil.getOmitNum(nums2.subList(i - 26, i - 1), 5);
			o3 = OmitUtil.getOmitNum(nums3.subList(i - 26, i - 1), 5);
			o4 = OmitUtil.getOmitNum(nums4.subList(i - 26, i - 1), 5);

			int a0 = o0.getOmitnum();
			int a1 = o1.getOmitnum();
			int a2 = o2.getOmitnum();
			int a3 = o3.getOmitnum();
			int a4 = o4.getOmitnum();

			List<Integer> n0 = new ArrayList<Integer>();
			List<Integer> n1 = new ArrayList<Integer>();
			List<Integer> n2 = new ArrayList<Integer>();
			List<Integer> n3 = new ArrayList<Integer>();
			List<Integer> n4 = new ArrayList<Integer>();

			n0 = o0.getResList();
			n1 = o1.getResList();
			n2 = o2.getResList();
			n3 = o3.getResList();
			n4 = o4.getResList();

			int as[] = { a0, a1, a2, a3, a4 };
			// System.out.println(as[0]+","+as[1]+","+as[2]+","+as[3]+","+as[4]);
//			int a = getmax(as);
			if (a2 > 11) {
				os.add(o2);
				tmlist.add(nums2.get(i));
			}
			;

			// if (a > 10) {
			// if (a == a0) {
			// os.add(o0);
			// tmlist.add(nums0.get(i));
			// } else if (a == a1) {
			// os.add(o1);
			// tmlist.add(nums1.get(i));
			// }
			// else if (a == a2) {
			// os.add(o2);
			// tmlist.add(nums2.get(i));
			// }
			// else if (a == a3) {
			// os.add(o3);
			// tmlist.add(nums3.get(i));
			// }
			// else if (a == a4) {
			// os.add(o4);
			// tmlist.add(nums4.get(i));
			// }
			// }
			// System.out.println(a);

		}
		System.out.println(os.size() + "===" + tmlist.size());

		for (int j = 0; j < os.size(); j++) {
			List<Integer> j1 = new ArrayList<Integer>();
			j1 = os.get(j).getResList();
			int tm = tmlist.get(j);
			if (checksuit(tm, j1)) {
				reses.add(1);
			} else {
				reses.add(0);
			}

		}
		System.out.println(reses.size());
		System.out.println(reses);
		List<Integer> ml = new ArrayList<Integer>();
		ml.add(1);
		ml.add(2);
		for (int m = 2; m < reses.size(); m++) {
			int mm = reses.get(m - 1);
			int bs = ml.get(m - 1);
			if (mm == 1) {
				ml.add(get1(bs));
			} else {
				ml.add(get0(bs));
			}
		}

		System.out.println(ml.size() + "=================");
		System.out.println(ml);
		int qq = 0;
		for (int ss : ml) {
			if (ss > qq) {
				qq = ss;
			}
		}
		System.out.println("max:" + qq);
		float cost = 0;
		float pro = 0;
		for (int pp = 0; pp < ml.size(); pp++) {

			if (reses.get(pp) == 1) {
				pro += ml.get(pp) * 19;
			}
			cost += ml.get(pp) * 10;
		}
		System.out.println(cost + "================" + pro);
	}

	public static int get0(int a) {

		List<Integer> beishu = new ArrayList<Integer>();

		beishu.add(1);
		beishu.add(2);
		for (int mk = 2; mk < 30; mk++) {
			beishu.add(beishu.get(mk - 1) + beishu.get(mk - 2));
		}
		int mm = 1;

		for (int i = 0; i < beishu.size() - 1; i++) {
			if (a == beishu.get(i)) {
				mm = beishu.get(i + 1);
				break;
			}
		}
		return mm;

	}

	public static int get1(int a) {
		if (a == 1 || a == 2) {
			return 1;
		}

		List<Integer> beishu = new ArrayList<Integer>();

		beishu.add(1);
		beishu.add(2);
		for (int mk = 2; mk < 30; mk++) {
			beishu.add(beishu.get(mk - 1) + beishu.get(mk - 2));
		}
		int mm = 1;

		for (int i = 2; i < beishu.size() - 1; i++) {
			if (a == beishu.get(i)) {
				mm = beishu.get(i - 2);
				break;
			}
		}
		return mm;

	}

	public static int getmax(int as[]) {

		int a = 0;
		for (int i = 0; i < as.length; i++) {
			if (as[i] > a) {
				a = as[i];
			}
		}

		return a;
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

}
