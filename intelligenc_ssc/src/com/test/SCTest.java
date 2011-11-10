package com.test;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;
import com.util.SrcUtil;

public class SCTest {
	public static void main(String[] args) {
		List<Integer> numList  = new ArrayList<Integer>();
		List<Integer> num4List = new ArrayList<Integer>();
		List<Integer> num5List = new ArrayList<Integer>();
		num4List = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		num5List = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		numList = ListUtil.addList(num4List, num5List);
	}

}
