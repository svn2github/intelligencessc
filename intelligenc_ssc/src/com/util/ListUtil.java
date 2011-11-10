package com.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	// list 逆序
	public static List<Integer> revertList(List<Integer> numList) {
		List<Integer> tempList = new ArrayList<Integer>();
		int j = 0;
		for (int i = numList.size() - 1; i >= 0; i--) {
			tempList.add(j, numList.get(i));
			j++;
		}
		return tempList;
	}
	
	
	//resList = numList - numlist2
	public static List<Integer> subList(List<Integer> numList,List<Integer> numList2) {
		List<Integer> resList = new ArrayList<Integer>(); 
		for(int vv : numList){
			if ( numList2.indexOf(vv) == -1){
				resList.add(vv);
			}
		}

		return resList;
	}
	
	public static List<Integer> addList(List<Integer> alist,List<Integer> blist){
		List<Integer> resList = new ArrayList<Integer>();
		for(int m :alist){
			resList.add(m);
		}
		for(int n :blist){
			resList.add(n);
		}
		
		return resList;
		
	}
	
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		List<Integer> s1 = new ArrayList<Integer>();
		s1.add(1);
		s1.add(11);
		s1.add(1);
		s1.add(1);
		
		List<Integer> s2 = new ArrayList<Integer>();
		s2.add(1);
		s2.add(11);
		s2.add(3);
		s2.add(1);
		s = subList(s1,s2);
		
		System.out.println(s);
	}

}
