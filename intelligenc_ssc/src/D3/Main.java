package D3;

import java.util.ArrayList;
import java.util.List;
import com.util.SrcUtil;
import com.util.StatisticsUtil;

public class Main {
	
	public static final int QS = 6; //qishu
	public static final double PF = 19; //profit

	public static void main(String[] args) {
		
		List<Integer> alist = new ArrayList<Integer>();
		List<Integer> blist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		
		alist = SrcUtil.readFileSingle("src/cqssc.txt", 0);
		blist = SrcUtil.readFileSingle("src/cqssc.txt", 1);
		clist = SrcUtil.readFileSingle("src/cqssc.txt", 2);
		
		int len = alist.size();
		
		System.out.println("len:"+ len );
//		StatisticsUtil.statisticsSort(alist);
		int pro = 0 ;
		int cost = 0;
		
		for (int i = 20; i < len ; i ++){
			List<Integer> tempalist = new ArrayList<Integer>();
			List<Integer> tempblist = new ArrayList<Integer>();
			List<Integer> tempclist = new ArrayList<Integer>();
			
			tempalist = alist.subList(i-20, i-1);
			tempblist = blist.subList(i-20, i-1);
			tempclist = clist.subList(i-20, i-1);
			
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(tempalist);
			l.addAll(tempblist);
			l.addAll(tempclist);
			
			
			List<Integer> res = new ArrayList<Integer>();
			
			res = StatisticsUtil.statisticsSort(l);
			
			int r1 = res.get(0);
			int r2 = res.get(9);
			int r3 = res.get(1);
			int r4 = res.get(8);
			
			int a = alist.get(i);
			int b = blist.get(i);
			int c = clist.get(i);
			String s1 = String.valueOf(r1) + String.valueOf(r2) + String.valueOf(r3) +String.valueOf(r4);
			cost += 20;
			if (a != b && a !=c  & b!= c){
				if (s1.indexOf(String.valueOf(a)) != -1 && s1.indexOf(String.valueOf(b)) != -1 && s1.indexOf(String.valueOf(c)) != -1){
					pro += 280;
				}
			}else if (a ==b && b == c ){
				
			}else if (a == b && b!= c){
				if (s1.indexOf(String.valueOf(a)) != -1 && s1.indexOf(String.valueOf(b)) != -1 ){
					pro += 570;
				}
			}else if (a == c && a!= b){
				if (s1.indexOf(String.valueOf(a)) != -1 && s1.indexOf(String.valueOf(c)) != -1 ){
					pro += 570;
				}
			}else if (b == c && a != b ){
				if (s1.indexOf(String.valueOf(b)) != -1 && s1.indexOf(String.valueOf(c)) != -1 ){
					pro += 570;
				}
			}
			
		}
		
		
		System.out.println("cost:"+ cost );
		System.out.println("pro:"+ pro );
		
	}
	

}
