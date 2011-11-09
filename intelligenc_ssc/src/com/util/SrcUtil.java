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
	// list 0 - 2011-10-01 -123
	// list 1 - 2011-10-02 -112 
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
                int num1 = Integer.parseInt(temp3[3]);
                int num2 =  Integer.parseInt(temp3[4]);
        		String tmp = String.valueOf(num1) + String.valueOf(num2);
        		int num = Integer.parseInt(tmp);
                numList.add(num);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("read file error!!!");
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
	
	public static List<Integer> readFileSingle(String filename,int position){
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
	
	
	public static void main(String[] args) {
        List <Integer> numList = new  ArrayList<Integer>();
        numList = readFile("src/test.txt");
        System.out.println(numList.get(0));
		
		
	}

}
