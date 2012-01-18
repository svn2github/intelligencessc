package com.onlyted;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.condition.ConditionUtil;
import com.util.ListUtil;

public class SevenFunction {
 public static final List<String> SLIST = pick5();

 public static void main(String[] args) {
  List<Integer> numlist_src = readFileSingle("src/cqssc.txt", 4);
  int cc = 0;
  for (int failnum = 0; failnum < 12; failnum++)
//   for (int a = 15; a < 51; a++)
    for (int m = 0; m < 252; m++)
     for (int n = 0; n < 252; n++)
    {
     cc++;
//     if(cc < 4668){
//      continue;
//     }
     System.out.print(cc + ".");
     if (cc % 500 == 0) {
      System.out.println();
     }
     List<Integer> numList = new ArrayList<Integer>(numlist_src);
     List<Integer> resList1 = new ArrayList<Integer>();
     resList1 = getSCHitList01(numList, failnum, m, n);
     if (getRate(resList1, 12).get(1) == 0) {
      System.out.println();
      System.out.println(failnum +  "===" + m
        + "====" + n);
      System.out.println(1 + "----" + getRate(resList1, 1));
      System.out.println(6 + "----" + getRate(resList1, 10));
      System.out.println(7 + "----" + getRate(resList1, 11));
      System.out.println(8 + "----" + getRate(resList1, 12));
      System.out.println(9 + "----" + getRate(resList1, 13));
     }
    }

  long endTime = System.nanoTime();
  System.out.println("end time :" + endTime);
 }

 public static List<Integer> getSCHitList01(List<Integer> numList,
   int fail_num1,  int m, int n) {
//  List<Integer> tmplist = new ArrayList<Integer>();
  List<Integer> resList = new ArrayList<Integer>();
  for (int i = 200; i < numList.size(); i++) {
   List<Integer> tagList = new ArrayList<Integer>();

   List<Integer> ssList = new ArrayList<Integer>();
   List<Integer> tmpRes = new ArrayList<Integer>();
   int res_len = resList.size();

   if (res_len > 16) {

    tmpRes = resList.subList(res_len - 13, res_len);
    // break;
   }

   int num = numList.get(i);
//   tmplist = numList.subList(i - a, i - 1);
//   ssList = StatisticsUtil.statisticsSort(tmplist);
   int cptmp = ConditionUtil.getNotHitDepth(tmpRes);

    if (cptmp > fail_num1) {
    String s = SLIST.get(m);
    int a1 = Integer.valueOf(s.split(",")[0]);
    int a2 = Integer.valueOf(s.split(",")[1]);
    int a3 = Integer.valueOf(s.split(",")[2]);
    int a4 = Integer.valueOf(s.split(",")[3]);
    int a5 = Integer.valueOf(s.split(",")[4]);
       
    tagList.add(a1);
    tagList.add(a2);
    tagList.add(a3);
    tagList.add(a4);
    tagList.add(a5);

    } else {
    String s = SLIST.get(n);
    int a1 = Integer.valueOf(s.split(",")[0]);
    int a2 = Integer.valueOf(s.split(",")[1]);
    int a3 = Integer.valueOf(s.split(",")[2]);
    int a4 = Integer.valueOf(s.split(",")[3]);
    int a5 = Integer.valueOf(s.split(",")[4]);
    
    tagList.add(a1);
    tagList.add(a2);
    tagList.add(a3);
    tagList.add(a4);
    tagList.add(a5);
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

 public static List<Integer> readFileSingle(String filename, int position) {
  File file = new File(filename);
  BufferedReader reader = null;
  List<Integer> numList = new ArrayList<Integer>();
  List<Integer> tempList = new ArrayList<Integer>();
  try {
   reader = new BufferedReader(new FileReader(file));
   String tempString = null;
   while ((tempString = reader.readLine()) != null) {
    // System.out.println( tempString);
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
  for (int i = 0; i < resList.size() - 15; i++) {

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

 public static List<String> pick5() {
  List<String> slist = new ArrayList<String>();
  for (int a = 0; a < 10; a++)
   for (int b = 1; b < 10; b++)
    for (int c = 2; c < 10; c++)
     for (int d = 2; d < 10; d++)
      for (int e = 2; e < 10; e++) {
         String s = "";
         if (a < b & b < c & c < d & d < e ) {
          s = String.valueOf(a) + ","
            + String.valueOf(b) + ","
            + String.valueOf(c) + ","
            + String.valueOf(d) + ","
            + String.valueOf(e);
          slist.add(s);
         }

        }

  return slist;
 }
}


 