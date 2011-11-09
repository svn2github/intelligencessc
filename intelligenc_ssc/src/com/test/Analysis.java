package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
	public static void main(String[] args) {
		File file = new File("src/res.txt");
        BufferedReader reader = null;
        List <Integer> numList = new  ArrayList<Integer>();
        try{
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        while ((tempString = reader.readLine()) != null) {
            int num = Integer.parseInt(tempString);
            numList.add(num);
        }
        reader.close();
        }catch(IOException e){
        	
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        int count = 0;
		int cc = 0;
		for (int i = 0; i < numList.size() - 8; i++) {

			int tvalue = -1;
			for (int j = 0; j < 6; j++) {
				tvalue += numList.get(i + j);
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
