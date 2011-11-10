package com.main;

import java.util.ArrayList;
import java.util.List;
import com.condition.Integration;
import com.util.SrcUtil;

public class Hou7 {

	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<Integer>();

		List<Integer> numList  = new ArrayList<Integer>();
		List<Integer> num4List = new ArrayList<Integer>();
		List<Integer> num5List = new ArrayList<Integer>();

		numList = SrcUtil.readFileSingle("src/cqssc.txt",4);
		num4List = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		num5List = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		
		resList = Integration.getResList(numList);

		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 10; i++) {

			int tvalue = -1;
			for (int j = 0; j < 1; j++) {
				tvalue += resList.get(i + j);
			}
			if (tvalue == -1) {
				count++;
			} else {
				cc++;
			}
		}

		System.out.println(cc + "------" + count);
	}

}
