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
	// 按照时间升序
	// list 0 - 2011-10-01 -001
	// list 1 - 2011-10-02 -002 
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
        tempList = ListUtil.revertList(numList);
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
	
	
	public static void main(String[] args) {
        List <Integer> numList = new  ArrayList<Integer>();
        numList = readFile("src/test.txt");
        System.out.println(numList.get(0));
		
		
	}

}
