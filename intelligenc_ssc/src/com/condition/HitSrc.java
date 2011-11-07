package com.condition;

import java.util.ArrayList;
import java.util.List;

public class HitSrc {
	
	public static final List<Integer> NUMLIST1=initialList(0,1,2,3,4,8,9);
	public static final List<Integer> NUMLIST2=initialList(0,3,4,5,4,7,9);
	public static final List<Integer> NUMLIST3=initialList(0,1,5,6,7,8,9);
	public static final List<Integer> NUMLIST4=initialList(1,2,3,4,5,6,7);
	public static final List<Integer> NUMLIST5=initialList(0,2,4,5,6,7,8);
	public static final List<Integer> NUMLIST6=initialList(2,3,4,6,7,8,9);
	
	
	public static List<Integer> initialList(int a1,int a2,int a3,int a4,int a5,int a6,int a7){
		
		List <Integer> tmpList = new ArrayList<Integer>();
		
		tmpList.add(a1);
		tmpList.add(a2);
		tmpList.add(a3);
		tmpList.add(a4);
		tmpList.add(a5);
		tmpList.add(a6);
		tmpList.add(a7);
		
		return null;
	}

}
