package translocation;

import java.util.ArrayList;
import java.util.List;

import com.util.SrcUtil;

public class New1 {
	
	
	
	public static final int QS = 30;
	public static final double PF = 1.90;
	
	
	
	public static void main(String args[]){
		List<Integer> list4 = new ArrayList<Integer>();// 个
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		
		
		System.out.println("list size:"+list4.size());
//
		List<Integer> resa = new ArrayList<Integer>();
		List<Integer> resb = new ArrayList<Integer>();

		List<Integer> s1 = new ArrayList<Integer>();
		List<Integer> s2 = new ArrayList<Integer>();
		
		List<Integer> sa = new ArrayList<Integer>();
		List<Integer> sb = new ArrayList<Integer>();
		
		s1.add(0);
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		s2.add(8);
		s2.add(9);
		
		sa.add(0);
		sa.add(2);
		sa.add(3);
		sa.add(5);
		sa.add(7);
		sb.add(1);
		sb.add(4);
		sb.add(6);
		sb.add(8);
		sb.add(9);

		for (int i = 0; i < list4.size(); i++) {
			resa.add(checksuit(list4.get(i), s1));
			resb.add(checksuit(list4.get(i), sa));
		}
		
		System.out.println("resa:"+resa);
		System.out.println("resb:"+resb);

		
		
	}
	
	
	
	public static int checksuit(int a, List<Integer> numlist) {

		int tag = 0;
		for (int i : numlist) {
			if (a == i) {
				tag = 1;
				break;
			}
		}
		return tag;
	}

}
