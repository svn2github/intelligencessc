package com.main;

import java.util.ArrayList;
import java.util.List;

import com.condition.Integration;
import com.util.SrcUtil;

public class Hou7 {
	
	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> numList = new ArrayList<Integer>();

		numList = SrcUtil.readFile("src/cqssc.txt");
		resList = Integration.getResList(numList);

		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 10; i++) {
			cc ++;
			int tvalue = -1;
			for (int j = 0; j < 3; j++) {
				tvalue += resList.get(i + j);
			}
			if (tvalue == -1) {
				count++;
			}
		}

		System.out.println(cc + "------" + count);
	}

}
