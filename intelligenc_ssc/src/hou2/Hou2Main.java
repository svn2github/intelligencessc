package hou2;

import java.util.ArrayList;
import java.util.List;

import com.util.ListUtil;
import com.util.SrcUtil;

public class Hou2Main {

	// 按照时间升序
	// list 0 - 2011-10-01 -123
	// list 1 - 2011-10-02 -112
	public static void main(String[] args) {
		// List<Integer> testList = new ArrayList<Integer>();
		// testList.add(1);
		// testList.add(1);
		// testList.add(0);
		// testList.add(0);
		// List<Integer> r = new ArrayList<Integer>();
		// r = ylListSort(testList,10);
		// System.out.println(r);

		List<Integer> listn = new ArrayList<Integer>();//

		List<Integer> list3 = new ArrayList<Integer>();// 十
		List<Integer> list4 = new ArrayList<Integer>();// 个

		
		List<Integer> list2 = new ArrayList<Integer>();// 百
		
		list3 = SrcUtil.readFileSingle("src/cqssc.txt", 3);
		list4 = SrcUtil.readFileSingle("src/cqssc.txt", 4);
		List<Integer> list = new ArrayList<Integer>();
		int len = list3.size();

		for (int i = 0; i < len; i++) {
			int a = list3.get(i);
			int b = list4.get(i);
			int c = a * 10 + b;
			list.add(c);
		}

		int count = 0;

		List<Integer> retList = new ArrayList<Integer>();
		for (int i = 200; i < len - 1; i++) {

			List<Integer> tl3 = new ArrayList<Integer>();
			List<Integer> tl4 = new ArrayList<Integer>();

			tl3 = ylListSort(list3.subList(i - 30, i - 1), 10);
			tl4 = ylListSort(list4.subList(i - 30, i - 1), 10);

			int a3 = tl3.get(1);
			int a4 = tl4.get(1);

			int h3 = list3.get(i);
			int h4 = list4.get(i);

			boolean tag = false;
			
			if (h3 == 1 || h3 == 9||h3 == 0 || h3 == 6|| h3 == 2 || h3 == 4 || h3 == 8  ) {
				tag = true;
			}
			

			if (tag) {
				retList.add(1);
			} else {
				retList.add(0);
			}

		}
		List<Ret> Rets = new ArrayList<Ret>();
//		for (int a: retList) {
			
//			System.out.println(a);
//		}
		
		int t0 = retList.get(0);
		Ret rc0 = new Ret();
		rc0.setBs(1);
		rc0.setCost(14);
		rc0.setAllCost(14);
		
		rc0.setPro(0);
		rc0.setAllPro(0);
		
		Ret rc1 = new Ret();
		rc1.setBs(2);
		rc1.setCost(14);
		rc1.setAllCost(42);
		rc1.setPro(0);
		rc1.setAllPro(0);
		
		
		Rets.add(rc0);
		Rets.add(rc1);
		for(int i = 2 ; i < retList.size(); i ++) {
			Ret rci = new Ret();
			Ret rci1 = new Ret();
			Ret rci2 = new Ret();
			
			rci2 = Rets.get(i-2);
			int pp_bs = rci2.getBs();
			
			rci1 = Rets.get(i-1);
			int p_bs = rci1.getBs();
			int p_allcost =  rci1.getAllCost();
			int p_allPro = rci1.getAllPro();
			int p_all = p_allPro - p_allcost;
			
			int a = retList.get(i);
			int last_a = retList.get(i-1);
			int bs = getBS(p_bs,pp_bs,p_all,last_a);
			if (p_all < -100){
				bs = 1;
			}
			
			int cost = bs * 14;
			int allCost = 0;
			int pro = 0;
			int allPro = 0;
			
			if (a == 0) {
				if (p_all >= 0) {
					allCost = cost;
					if (bs != 1){
						allPro = p_allPro + pro;
					}else {
						allPro = 0;
					}
					
				}else {
					allCost = p_allcost + cost ;
					if (bs != 1){
						allPro = p_allPro + pro;
					}else {
						allPro = 0;
					}
				}
			}else if (a == 1){
				pro = bs * 19; 
				if (p_all >= 0) {
					allCost = cost;
					allPro = pro;
				}else {
					if (bs != 1){
						allCost= p_allcost + cost ;
						allPro = p_allPro + pro;
					}else {
						allCost = cost;
						allPro = pro;
					}
				
				}
			}
			
			System.out.println(a+" "+bs+" "+cost+" "+allCost+" "+pro + " " + allPro);
			
			rci.setAllCost(allCost);
			rci.setAllPro(allPro);
			rci.setBs(bs);
			rci.setCost(cost);
			rci.setPro(pro);
			Rets.add(rci);
		}
		
		
		Ret rd = new Ret();
		int rr = 0 ;
		int mk = 0 ;
		for(Ret r : Rets) {
			mk ++;
			int nn = r.getAllCost();
//			if (nn == 23444190){
//				System.out.println("mk:" + mk);
//			}
			if (mk > 56000 && mk < 56113){
				System.out.println("mk:" +r.getBs()+ "--"+ r.getAllCost() +"---"+ r.getAllPro());
			}
			if (nn > rr){
				rr= nn;
				rd = r;
			}
		}

		System.out.println(rd.getAllCost() +"---"+ rd.getAllPro());
	}
	
	
	
	//1,2,7,27,27,27   //	int p_all = p_allPro - p_allcost;
	public static int getBS (int p_bs,int pp_bs, int p_all,int last_a){
		int a = 0;
		int b =p_bs;
		int c = pp_bs;
		if (p_all >= 0){
			a = 1;
		}else {
			if (last_a == 1){
				a =p_bs ;
			}else {
				p_all = p_all - p_all*2 ;
				int p_pro = 0;
				if (p_all%2 ==0){
					p_pro = p_all/2 ;
				}else {
					p_pro = p_all/2+1;
				}
				if (p_pro % 5 ==0){
					a = p_pro / 5 ;
				}else {
					a = p_pro / 5 + 1;
				}
			}
		}
		return a;
	}
	
	
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

	//
	public static List<Integer> merger2(List<Integer> numList1,
			List<Integer> numList2) {
		List<Integer> retList = new ArrayList<Integer>();
		int len1 = numList1.size();
		int len2 = numList2.size();
		for (int i = 0; i < len1; i++) {
			int a = numList1.get(i);
			for (int j = 0; j < len2; j++) {
				int b = numList2.get(j);
				int c = a * 10 + b;
				retList.add(c);
			}
		}
		return retList;
	}

	// 按照遗漏顺序降序 //按照出现顺序排序 降序
	public static List<Integer> ylListSort(List<Integer> numList, int len) {
		int tmp;
		int tmp2;
		numList = ListUtil.revertList(numList);
		List<Integer> ylList = new ArrayList<Integer>();
		List<Integer> taglist = new ArrayList<Integer>();

		for (int i = 0; i < len; i++) {
			ylList.add(getYLcount(i, numList));
		}

		for (int m = 0; m < len; m++) {
			taglist.add(m);
		}

		for (int i = 0; i < ylList.size(); i++)
			for (int j = 0; j < ylList.size() - i - 1; ++j) {
				if (ylList.get(j) >= ylList.get(j + 1)) {
					tmp = ylList.get(j);
					ylList.set(j, ylList.get(j + 1));
					ylList.set(j + 1, tmp);

					tmp2 = taglist.get(j);
					taglist.set(j, taglist.get(j + 1));
					taglist.set(j + 1, tmp2);
				}

			}

		return taglist;
	}

	public static int getYLcount(int a, List<Integer> numList) {
		int ylcs = 0;
		for (int m = 0; m < numList.size(); m++) {
			if (a != numList.get(m)) {
				ylcs++;
			} else {
				break;
			}
		}

		return ylcs;
	}
	

}


class Ret {
	private int bs ;
	private int cost ;
	private int pro ;
	private int allCost ;
	private int allPro ;
	public int getBs() {
		return bs;
	}
	public void setBs(int bs) {
		this.bs = bs;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPro() {
		return pro;
	}
	public void setPro(int pro) {
		this.pro = pro;
	}
	public int getAllCost() {
		return allCost;
	}
	public void setAllCost(int allCost) {
		this.allCost = allCost;
	}
	public int getAllPro() {
		return allPro;
	}
	public void setAllPro(int allPro) {
		this.allPro = allPro;
	}
	
}