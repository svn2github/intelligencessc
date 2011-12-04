/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.every;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
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

	// resList = numList - numlist2
	public static List<Integer> subList(List<Integer> numList,
			List<Integer> numList2) {
		List<Integer> resList = new ArrayList<Integer>();
		for (int vv : numList) {
			if (numList2.indexOf(vv) == -1) {
				resList.add(vv);
			}
		}

		return resList;
	}

	public static List<Integer> addList(List<Integer> alist, List<Integer> blist) {
		List<Integer> resList = new ArrayList<Integer>();
		for (int m : alist) {
			resList.add(m);
		}
		for (int n : blist) {
			resList.add(n);
		}

		return resList;

	}

        public static List<Integer> getRate(List<Integer> resList, int len) {
		List<Integer> tagList = new ArrayList<Integer>();
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 25; i++) {

			int tvalue = -1;
			for (int j = 0; j < len; j++) {
				tvalue += resList.get(i + j);
			}
			if (tvalue == -1) {
				count++;
			} else {
				cc++;
			}
		}

		tagList.add(cc);
		tagList.add(count);
		return tagList;
	}
        
}
