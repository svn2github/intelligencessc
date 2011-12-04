package com.every;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;

public class GetSrc {
	public static List<Integer> readFileSingle(int position){
		String filename = "src/cqssc.txt";
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
	
	public static void main(String[] args) {
		System.out.println(readFileSingle(4));
	}

}
