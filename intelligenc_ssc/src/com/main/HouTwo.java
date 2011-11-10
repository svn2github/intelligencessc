package com.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.ListUtil;
import com.util.SrcUtil;
import com.util.YLUtil;

public class HouTwo {
	public static void main(String[] args) {
		
		List<Integer> slist = new ArrayList<Integer>();
		slist.add(0);
		slist.add(11);
		slist.add(22);
		slist.add(33);
		slist.add(44);
		slist.add(55);
		slist.add(66);
		slist.add(77);
		slist.add(88);
		slist.add(99);
   
		List<Integer> resList = new ArrayList<Integer>();

		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> num4List = new ArrayList<Integer>();
		List<Integer> num5List = new ArrayList<Integer>();

		System.out.println("begin==========");
		numList = SrcUtil.readFile("src/cqssc.txt");
		num4List = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		num5List = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		System.out.println("end============");

		int len = numList.size();

		
		for (int i = 120; i < len; i++) {

			List<Integer> tmp4list = new ArrayList<Integer>();
			List<Integer> tmp5list = new ArrayList<Integer>();
			List<Integer> yllist = new ArrayList<Integer>();
			List<Integer> taglist = new ArrayList<Integer>();
			List<Integer> tmplist = new ArrayList<Integer>();
			List<Integer> tlist = new ArrayList<Integer>();
			
			tmp4list = YLUtil.ylListSort(num4List.subList(i - 20, i - 1), 10).subList(1, 10);
			tmp5list = YLUtil.ylListSort(num5List.subList(i - 20, i - 1), 10).subList(1, 10);

			for (int m = 0; m < tmp4list.size(); m++)
				for (int n = 0; n < tmp4list.size(); n++) {
					tmplist.add(Integer.parseInt(String
							.valueOf(tmp4list.get(m))
							+ String.valueOf(tmp5list.get(n))));
				}

			yllist = YLUtil.ylListSort(numList, 100).subList(97, 100);
			tlist = ListUtil.subList(tmplist, yllist);
			taglist = ListUtil.subList(tlist, slist);
			System.out.println(taglist.size());
			
			if (ConditionUtil.checksuit(numList.get(i), taglist) == true) {
				resList.add(1);
			} else {
				resList.add(0);
			}
			System.out.println(i+"----------");

		}
		
		try {
			FileWriter writer = new FileWriter("src/res3.txt", true);
			for(int i : resList){
				writer.write(String.valueOf(i)+"\n");
			}
			writer.close();  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		System.out.println("change");
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 10; i++) {

			int tvalue = -1;
			for (int j = 0; j < 4; j++) {
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
