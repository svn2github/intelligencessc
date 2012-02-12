package com.every;

import java.util.ArrayList;
import java.util.List;

public class TestEmain2 {
	
	public static void main(String[] args) {
		List<Integer> yllist = new ArrayList<Integer>();
		List<Integer> numlist = new ArrayList<Integer>();
		yllist.add(0);
		yllist.add(1);
		numlist.add(2);
		numlist.add(1);
		numlist.add(2);
		numlist.add(2);
		numlist.add(1);
		numlist.add(1);
		
		
		System.out.println(Emain2.getDoubleHit(yllist,numlist));
		
		
		
		
		
	}

}
