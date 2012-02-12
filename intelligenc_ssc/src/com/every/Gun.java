package com.every;

import java.util.ArrayList;
import java.util.List;

public class Gun {
	
	public static void main (String args[]){
		
		List<Integer> nums3 = new ArrayList<Integer>();
		List<Integer> nums4 = new ArrayList<Integer>();
		
		nums3 = GetSrc.readFileSingle(3);
		nums4 = GetSrc.readFileSingle(4);
		
		List<Integer> numslist = new ArrayList<Integer>();
		for(int mk = 0 ;  mk < nums3.size();mk++){
			
			int s = nums3.get(mk)*10+nums4.get(mk);
			numslist.add(s);
		}
		
		
		for(int i = 50 ; i < numslist.size(); i ++){
			
			List<Integer> nlist = new ArrayList<Integer>();
			
			Omit o3 = new Omit();
			o3 = OmitUtil.getOmitNum(nums3.subList(i - 49, i ), 9);
			
			Omit o4 = new Omit();
			o4 = OmitUtil.getOmitNum(nums4.subList(i - 49, i), 9);
			
			int a3 = o3.getResList().get(0);
			int a4 = o4.getResList().get(0);
			System.out.println(a3+"'"+a4);
			
		}
		
	}
}
