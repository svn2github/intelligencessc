package hou2;

import java.util.ArrayList;
import java.util.List;

import com.util.SrcUtil;

public class Hou2Main {
	
	// 按照时间升序
	// list 0 - 2011-10-01 -123
	// list 1 - 2011-10-02 -112 
	public static void main(String[] args) {
		
		List<Integer> listn = new ArrayList<Integer>();//
		
		List<Integer> list3 = new ArrayList<Integer>();// 十
		List<Integer> list4 = new ArrayList<Integer>();// 个

		list3 = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		
		
		List<Integer> tslist0 = new ArrayList<Integer>();
		List<Integer> tslist1 = new ArrayList<Integer>();
		List<Integer> tslist2 = new ArrayList<Integer>();
		List<Integer> tslist3 = new ArrayList<Integer>();
		List<Integer> tslist4 = new ArrayList<Integer>();
		
		
		
		
	}

}
