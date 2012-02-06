package com.every;

import java.util.ArrayList;
import java.util.List;

public class Emain2 {
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

			o0 = OmitUtil.getOmitNum(nums0.subList(i - 26, i - 1), 3);
			o1 = OmitUtil.getOmitNum(nums1.subList(i - 26, i - 1), 3);
			o2 = OmitUtil.getOmitNum(nums2.subList(i - 26, i - 1), 3);
			o3 = OmitUtil.getOmitNum(nums3.subList(i - 26, i - 1), 3);
			o4 = OmitUtil.getOmitNum(nums4.subList(i - 26, i - 1), 3);

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
			if (a0 > 4) {
				os.add(o0);
				tmlist.add(nums0.get(i));
			}


		}
		System.out.println("os size:" +os.size() + "==all size:" + len);

		for (int j = 0; j < os.size(); j++) {
			List<Integer> j1 = new ArrayList<Integer>();
			j1 = os.get(j).getResList();
			int tm = tmlist.get(j);
			if (checksuit(tm, j1)) {
				reses.add(1);
//				System.out.println(tm+"==" + j1+"==="+1);
			} else {
				reses.add(0);
//				System.out.println(tm+"==" + j1+"==="+0);
			}

		}
		//reses : 结果表
		//os : 遗漏
		
		int len1 = reses.size();
		int tag = 0;
		while(tag < len1){
			int cost = 0;
			int pro = 0;
			int tt = 0;
			int re = reses.get(tag);
			List<Integer> la = new ArrayList<Integer>();
			la = os.get(tag).getResList();
			
			
		}
//		System.out.println(cost+"==="+pro);
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
	
	public static boolean checksame(List<Integer> l1,List<Integer> l2){
		int len = l1.size();
		boolean tag = true;
		for(int i = 0; i< len; i++){
			if(l1.get(i)!=l2.get(i)){
				tag = false;
				break;
			}
		}
		return tag;
	}

}
