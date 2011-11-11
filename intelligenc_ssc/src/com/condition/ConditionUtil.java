package com.condition;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;

public class ConditionUtil {
	
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

	public static int getHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int count = 0;
		int res = 0;
		for (int i = 0; i < numList.size(); i++) {
			res += numList.get(i);
			if (res < i + 1) {
				break;
			}
			count++;
		}
		return count;

	}

	public static int getNotHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int rest = 0;
		int count = 0;
		for (int i = 0; i < numList.size(); i++) {
			rest += numList.get(i);
			
			if (rest > 0) {
				break;
			}
			count++;
		}
		return count;
	}

	
	public static void main(String[] args) {
		
		List <Integer> tlist = new ArrayList<Integer>();
		tlist.add(1);
		tlist.add(0);
		tlist.add(1);
		tlist.add(1);
		tlist.add(2);
		System.out.println("depth:"+getHitDepth(tlist));
		System.out.println("No depth:"+getNotHitDepth(tlist));
		
	}
}
