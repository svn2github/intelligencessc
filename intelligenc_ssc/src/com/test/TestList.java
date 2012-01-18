package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
public static void main(String[] args) {
	List<Integer> resList = new ArrayList<Integer>();
	List<Integer> scList2 = new ArrayList<Integer>();
	List<Integer> scList1 = new ArrayList<Integer>();
	for(int i = 0; i <30;i++){
		resList.add(i);
	}
	scList1 = resList.subList(0, 10);
	System.out.println(resList);
	System.out.println(scList1);
	scList2 = resList.subList(0, 10);
	System.out.println(resList);
	System.out.println(scList2);
}

}
