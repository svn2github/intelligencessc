package com.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.util.SrcUtil;

public class Test {
	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<Integer>();
		resList = SrcUtil.readFile("src/cqssc.txt");
		try {
			FileWriter writer = new FileWriter("src/res.txt", true);
			writer.write("ssss\n");
			writer.write("ssss");
			for(int i : resList){
				writer.write(String.valueOf(i)+"\n");
			}
			writer.close();  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
