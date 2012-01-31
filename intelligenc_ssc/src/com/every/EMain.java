package com.every;

import java.util.ArrayList;
import java.util.List;

public class EMain {
	public static void main(String[] args) {
        List<Integer> nums0 = new ArrayList<Integer>();
        List<Integer> nums1 = new ArrayList<Integer>();
        List<Integer> nums2 = new ArrayList<Integer>();
        List<Integer> nums3 = new ArrayList<Integer>();
        List<Integer> nums4 = new ArrayList<Integer>();
        List<Integer> reses = new ArrayList<Integer>();
        
        nums0= GetSrc.readFileSingle(0);
        nums1= GetSrc.readFileSingle(1);
        nums2= GetSrc.readFileSingle(2);
        nums3= GetSrc.readFileSingle(3);
        nums4= GetSrc.readFileSingle(4);
        
        int len = nums0.size();
        int cc =0;
        for(int i =30;i<len;i++){
//        	System.out.println(cc++);
//        	List<Integer> numss0 = new ArrayList<Integer>(nums0);
//            List<Integer> numss1 = new ArrayList<Integer>(nums1);
//            List<Integer> numss2 = new ArrayList<Integer>(nums2);
//            List<Integer> numss3 = new ArrayList<Integer>(nums3);
//            List<Integer> numss4 = new ArrayList<Integer>(nums4);
//            List<Integer> resess = new ArrayList<Integer>();
        	
        	Omit o0 = new Omit();
        	Omit o1 = new Omit();
        	Omit o2 = new Omit();
        	Omit o3 = new Omit();
        	Omit o4 = new Omit();
        	
        	o0 = OmitUtil.getOmitNum(nums0.subList(i-26, i-1), 8);
        	o1 = OmitUtil.getOmitNum(nums1.subList(i-26, i-1), 8);
        	o2 = OmitUtil.getOmitNum(nums2.subList(i-26, i-1), 8);
        	o3 = OmitUtil.getOmitNum(nums3.subList(i-26, i-1), 8);
        	o4 = OmitUtil.getOmitNum(nums4.subList(i-26, i-1), 8);
        	
        	int a0=o0.getOmitnum();
        	int a1=o1.getOmitnum();
        	int a2=o2.getOmitnum();
        	int a3=o3.getOmitnum();
        	int a4=o4.getOmitnum();
        	int as[]={a0,a1,a2,a3,a4};
//        	System.out.println(as[0]+","+as[1]+","+as[2]+","+as[3]+","+as[4]);
        	int a = getmax(as);
//        	System.out.println(a);
        	if(a > 18){
        		System.out.println(cc++);
        		System.out.println("====");
        	}
//        	
        	if(a > 9){
        		
        	
        	
        	if(a == a0){
        		int num = nums0.get(i);
//        		System.out.println(o0.getResList());
        		if(o0.getResList().indexOf(num) != -1){
        			reses.add(1);
        		}else{
        			reses.add(0);
        		}
        		
        	}
        	else if(a == a1){
        		int num = nums1.get(i);
        		if(o1.getResList().indexOf(num) != -1){
        			reses.add(1);
        		}else{
        			reses.add(0);
        		}
        	}
        	else if(a == a2){
        		int num = nums2.get(i);
        		if(o2.getResList().indexOf(num) != -1){
        			reses.add(1);
        		}else{
        			reses.add(0);
        		}
        		
        	}
        	else if(a == a3){
        		int num = nums3.get(i);
        		if(o3.getResList().indexOf(num) != -1){
        			reses.add(1);
        		}else{
        			reses.add(0);
        		}
        	}
        	else if(a == a4){
        		int num = nums4.get(i);
        		if(o4.getResList().indexOf(num) != -1){
        			reses.add(1);
        		}else{
        			reses.add(0);
        		}
        	}
        	}
        }
        
        System.out.println(ListUtil.getRate(reses, 0));
        System.out.println(ListUtil.getRate(reses, 1));
        System.out.println(ListUtil.getRate(reses, 2));
        System.out.println(ListUtil.getRate(reses, 3));//9
        System.out.println(ListUtil.getRate(reses, 4));//10
        System.out.println(ListUtil.getRate(reses, 5));//11
        System.out.println(ListUtil.getRate(reses, 6));//12
        System.out.println(ListUtil.getRate(reses, 7));//13
        System.out.println(ListUtil.getRate(reses, 12));
        System.out.println("len:"+reses.size());
	}
	
	public static int getmax(int as[]){
		
		int a =0;
		for(int i=0;i<as.length;i++){
			if(as[i]>a){
				a =as[i];
			}
		}
		
		return a;
	}

}
