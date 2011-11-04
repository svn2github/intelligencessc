package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SrcUtil {
	//Filename like "src/3D.txt"
	// return a int array list
	// 按照时间倒序,最新的数据在最上面
	public static List<Integer> readFile(String filename){
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
                int num = Integer.parseInt(temp3[4]);
                numList.add(num);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        int j = 0;
		for (int i = numList.size() - 1; i >= 0; i--) {
			tempList.add(j, numList.get(i));
			j++;
		}
		return tempList;
	}
	
	public static List<Integer> readFile2(String filename){
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
                int num = Integer.parseInt(temp3[3]);
                numList.add(num);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        int j = 0;
		for (int i = numList.size() - 1; i >= 0; i--) {
			tempList.add(j, numList.get(i));
			j++;
		}
		return tempList;
	}
	
	//zhong jiang :0
	public static List<Integer> gethou17maList(List <Integer> numList){
		List<Integer> tempList = new ArrayList<Integer>();
		List<Integer> tagList = new ArrayList<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		
		
		System.out.println(numList.size());
		
		 for(int i = 100 ;i < numList.size();i++){
			 int num = numList.get(i);
			 tempList = YLUtil.getYLList( numList.subList(i-10, i));
			 tagList = YLUtil.ylListSort(tempList);
			 if(checksuit(num,tagList)){
				 resList.add(1);
			 }else{
				 resList.add(0);
			 }
		 }
		 
		return resList;
	}
	
	public static boolean checksuit(int a , List<Integer> numlist){
		boolean tag =false;
		
		for (int i : numlist){
			if (a == i){
				tag =true;
			}
		}
		return tag;
	}
	public static void main(String[] args) {
		
		
	}

}
