package translocation;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;
import com.util.SrcUtil;

public class Main {

	public static void main(String[] args) {
		// double y = 9.999999;
		//
		// System.out.println(getOneS(y));

		List<Integer> list4 = new ArrayList<Integer>();// 个
		// 01-...
		// 02-...
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		System.out.println(list4.size());

		List<Integer> resa = new ArrayList<Integer>();
		List<Integer> resb = new ArrayList<Integer>();

		List<Integer> s1 = new ArrayList<Integer>();
		List<Integer> s2 = new ArrayList<Integer>();

		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(5);
		s1.add(7);
		s2.add(0);
		s2.add(4);
		s2.add(6);
		s2.add(8);
		s2.add(9);

		for (int i = 0; i < list4.size(); i++) {
			resa.add(checksuit(list4.get(i), s1));
			resb.add(checksuit(list4.get(i), s2));
		}


		List<Double> res = new ArrayList<Double>();
		int count = 0;

		int tag = 120;
		for (int j = 0; j < resa.size(); j += tag) {
			count++;
			double cost = 2.0;
			double pro = 1.9;
			for (int m = j + 1; m < j + tag; m++) {
				if(m > resa.size()-1 ){
					break;
				}
				int a0 = resa.get(m - 1);
				int a1 = resa.get(m);

				if (a0 == 1) {

					if (a1 == 1) {
						pro = pro * 1.9;
						pro = getOneS(pro);
						cost += 1.0;
					} else if (a1 == 0) {
						pro = 1.9;
						cost += 1.0;
					}

				} else if (a0 == 0) {

					if (a1 == 1) {
						pro = 1.9;
						cost += 1.0;
					} else if (a1 == 0) {
						cost += 1.0;
						pro = pro * 1.9;
						pro = getOneS(pro);
						
					}

				}
				if (pro / cost > 2 && pro-cost > 13) {
					res.add(pro - cost);
					break;
				}

			}
			res.add(pro - cost);
		}
		
		System.out.println(res);
		List<Integer> fi = new ArrayList<Integer>();

		double li = 0.0;
		for (int l = 0; l < res.size(); l++) {
			li += res.get(l);
			if (res.get(l) > 0 ){
				fi.add(1);
			}else {
				fi.add(0);
			}
		}
		
		List<Integer> hi = new ArrayList<Integer>();
		for(int mm=20;mm<fi.size();mm++){
			List<Integer> templ = new ArrayList<Integer>();
			templ=fi.subList(mm-20, mm-1);
			hi.add(getNotHitDepth(templ));
		}
		
		int max = 0;
		for(int m : hi){
			if(m > max){
				max = m;
			}
		}
		System.out.println("==:"+max);
		System.out.println("pro=:"+getOneS(li));
		System.out.println("count=:"+count);
		System.out.println(hi);

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

	// 保留一位小数
	public static double getOneS(double t) {
		double temp = t * 10;
		int it = (int) temp;
		double r = (double) it / 10;
		return r;
	}

	public static int getHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int count = 0;
		int res = 0;
		for (int i = 0; i < numList.size(); i++) {
			res += numList.get(i);
			if (res < i + 1) {
				break;
			}
			count++;
		}
		return count;

	}

	public static int getNotHitDepth(List<Integer> numList) {
		numList = ListUtil.revertList(numList);
		int rest = 0;
		int count = 0;
		for (int i = 0; i < numList.size(); i++) {
			rest += numList.get(i);
			
			if (rest > 0) {
				break;
			}
			count++;
		}
		return count;
	}

	
}
