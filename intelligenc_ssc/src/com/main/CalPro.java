package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;

public class CalPro {
	public static void main(String[] args) {
		
		/*----------------------read file begin-------------------------*/
		File file = new File("src/res2.txt");
		BufferedReader reader = null;
		List<Integer> numList = new ArrayList<Integer>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				int num = Integer.parseInt(tempString);
				numList.add(num);
			}
			reader.close();
		} catch (IOException e) {

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		/*----------------------read file end-------------------------*/
		
		

		double allcost = 0;
		double allbonus = 0;
		double maxcost = 0;
		int  hd = 0;
		int nh = 0;
		for (int i = 12; i < numList.size() - 10; i++) {
			List<Integer> tmplist = new ArrayList<Integer>();
			tmplist = numList.subList(i-10, i-1);
			hd = ConditionUtil.getHitDepth(tmplist);
			nh = ConditionUtil.getNotHitDepth(tmplist);
			if(true){
			}
		}


	}

}
