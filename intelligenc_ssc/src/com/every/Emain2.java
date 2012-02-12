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

		nums0 = GetSrc.readFileSingle(0);
		List<Omit> os = new ArrayList<Omit>();
		int len = nums0.size();
		for (int i = 30; i < len - 1; i++) {

			Omit o0 = new Omit();

			//七码
			o0 = OmitUtil.getOmitNum(nums0.subList(i - 26, i - 1), 3);

			int a0 = o0.getOmitnum();


			if (a0 > 4) {
				os.add(o0);// 遗漏数,遗漏表
				tmlist.add(nums0.get(i));//奖号
			}


		}
		System.out.println("os size:" +os.size() + "==all size:" + len);

		
		
		
		//遗漏表对应的中奖状况
		for (int j = 0; j < os.size(); j++) {
			
			List<Integer> j1 = new ArrayList<Integer>();
			j1 = os.get(j).getResList();// 遗漏的列表
			
			int tm = tmlist.get(j); // 奖号
			if (checksuit(tm, j1)) {
				reses.add(1);
//				System.out.println(tm+"==" + j1+"==="+1);
			} else {
				reses.add(0);
//				System.out.println(tm+"==" + j1+"==="+0);
			}

		}
		
		System.out.println("=================================");
		//reses : 结果表
		//os : 遗漏
		
		int len1 = reses.size();
		int tag = 0;
		while(tag < len1-30){
			int cost = 0;
			int pro = 0;
			int tt = 0;
			int res = reses.get(tag);
			//遗漏表
			List<Integer> la = new ArrayList<Integer>();
			la = os.get(tag).getResList();
			
			int cn = 0;
			while(true){
				tag++;
				List<Integer> tmp = new ArrayList<Integer>();
				tmp = os.get(tag).getResList();
				if(checksame(la,tmp)){
					cn ++;
				}else{
					break;
				}
				
			}
			
			System.out.println(cn);
			
			
			
		}
	}
	
	
	
	
	
	//=======================================================
	
	public static int getDoubleHit(List<Integer> yllist,List<Integer> numlist){
		
		int count=0;
		for(int i=0;i<numlist.size()-1;i++){
			count++;
			if(checksuit(numlist.get(i),yllist) && checksuit(numlist.get(i+1),yllist)){
				break;
			}
			
		}
		count++;
		
		
		
		return count;
	}
	
	
	
	
	public static int  getB(int cn){
		
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
	
	
	
	//列表相等
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
