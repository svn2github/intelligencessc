package com.onlyted;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.ListUtil;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class Assembly {

	 public static final List<Integer> NUMLIST = readFileSingle("src/cqssc.txt", 4);
	public static void main(String[] args) {
		long startTime=System.nanoTime();   
		System.out.println("start time :" +startTime );
		Assembly ass = new Assembly();
		List<Integer> numList1 = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();

		int hit1 = 0;// hit
		int hit2 = 0;
		int nhit1 = 0;
		int nhit2 = 0;

		// numList2 = numList1;
//		numList1 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		int i = 0;
		for(int a = 1;a < 7;a++)
			for(int ai = a+1;ai <10;ai++)
		     for (int b = 20; b < 50; b++) 
			for (int m = 0; m <= 5; m++)
				for (int n = 0; n <= 5; n++) 
				for(int o=0;o<=5;o++){
					List<Integer> numList2 = new ArrayList<Integer>(NUMLIST);
					List<Integer> resList1 = new ArrayList<Integer>();
					resList1 = ass.getSCHitList01(numList2, a,ai, b, m, n,o);
					System.out.print("." + i + ".");
					if (i % 100 == 0) {
						System.out.println();
					}
					i++;
					if (getRate(resList1, 13).get(1) == 0) {
						System.out.println(a + "===" + ai+"===" + b + "===" + m + "===="+ n+ "==="+o );
						System.out.println(10 + "----" + getRate(resList1, 10));
						System.out.println(11 + "----" + getRate(resList1, 11));
						System.out.println(12 + "----" + getRate(resList1, 12));
						System.out.println(13 + "----" + getRate(resList1, 13));
						System.out.println(14 + "----" + getRate(resList1, 14));
						System.out.println(15 + "----" + getRate(resList1, 15));
					}
		}
		
		long endTime=System.nanoTime();
		System.out.println("end time :" + endTime);
//		numList1 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
//		List<Integer> resList1 = new ArrayList<Integer>();
//		List<Integer> resList2 = new ArrayList<Integer>();
//		resList1 = ass.getSCHitList01(numList1, 5, 1, 1, 1);
//		resList2 = ass.getSCHitList01(numList1, 5, 1, 1, 1);
//		System.out.println(12 + "----" + getRate(resList1, 1));
//		System.out.println(12 + "----" + getRate(resList2, 1));
		
//		 for(int i = 0; i<resList1.size();i++){
//		 if (i < 20){
//		 resList.add(resList1.get(i));
//		 }else{
//		 nhit1=ConditionUtil.getHitDepth(resList1.subList(i-15, i-1));
//		 nhit2 =ConditionUtil.getNotHitDepth(resList2.subList(i-15, i-1));
//		 // if (hit1 < 18 && hit1 > 0){
//		 // resList.add(resList2.get(i));
//		 // }else
//		 if(nhit1 != 0 ){
//		 resList.add(resList2.get(i));
//		 }else {
//		 resList.add(resList1.get(i));
//		 }
//		 }
//		 }

}
	// 失败次数,范围,
	// fail_num2>fail_num1
	public List<Integer> getSCHitList01(List<Integer> numList, int fail_num1,
			int fail_num2,int a, int m, int n,int o) {
		List<Integer> tmplist = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		for (int i = 200; i < numList.size(); i++) {
			List<Integer> tagList = new ArrayList<Integer>();

			List<Integer> ssList = new ArrayList<Integer>();
			List<Integer> tmpRes = new ArrayList<Integer>();
			int res_len = resList.size();

			if (res_len > 10) {

				tmpRes = resList.subList(res_len - 10, res_len);
				// break;
			}

			int num = numList.get(i);
			tmplist = numList.subList(i - a, i - 1);
			ssList = StatisticsUtil.statisticsSort(tmplist);
			int cptmp = ConditionUtil.getNotHitDepth(tmpRes);

			
			if ( cptmp > fail_num1 && cptmp <= fail_num2) {
				tagList = ssList.subList(m, m + 5);

			} else if(cptmp > fail_num2) {
				tagList = ssList.subList(n, n + 5);
				
			}else {
				tagList = ssList.subList(o, o + 5);
			}

			if (tagList.size() > 0) {

				if (ConditionUtil.checksuit(num, tagList)) {
					resList.add(1);
				} else {
					resList.add(0);
				}
			}
		}
		return resList;
	}

	public static  List<Integer>  readFileSingle(String filename,int position){
		File file = new File(filename);
        BufferedReader reader = null;
        List <Integer> numList = new  ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();
		try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
//                System.out.println( tempString);
                String[] temp = tempString.split(" ");
                String temp2 = temp[1];
                String[] temp3 = temp2.split(",");
                int num = Integer.parseInt(temp3[position]);
                numList.add(num);
            }
            reader.close();
        } catch (IOException e) {
        	System.err.println("read file error!!!");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        tempList = ListUtil.revertList(numList);
		return tempList;
	}
	

	public static List<Integer> getRate(List<Integer> resList, int len) {
		List<Integer> tagList = new ArrayList<Integer>();
		int count = 0;
		int cc = 0;
		for (int i = 0; i < resList.size() - 20; i++) {

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
