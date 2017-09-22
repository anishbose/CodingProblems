package Codeforces;

import java.util.*;
public class ToySum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numNums = sc.nextInt();
		
		HashSet<Integer> teacherNums = new HashSet<Integer>();
		
		int sum = 0;
		while(numNums-- > 0) {
			int i = sc.nextInt();
			sum += (i - 1);
			teacherNums.add(i);
		}
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(10-numNums);
		int[] nums = new int[10-numNums];
		for(int i = 0; i < 10; i++) {
			if(!teacherNums.contains(i)) {
				numbers.add(i);
			}
		}
		System.out.println(numbers.toString());
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int total = 0;
		int togo = sum-total;
		//System.out.println(total);
		//System.out.println(togo);
		//System.out.println("--------");
		while(total != sum) {
			togo = sum-total;
			//System.out.println(total);
			//System.out.println(togo);
			while(Collections.binarySearch(numbers, togo) == -1) {
				togo--;
			}
			int pos = Collections.binarySearch(numbers, togo);
			//System.out.println(pos);
			total += numbers.get(pos);
			ans.add(numbers.get(pos));
		}
		if(sum == 0) {
			System.out.println("1");
			System.out.println("1000000");
		} else {
			System.out.println(ans.size());
			for(Integer n : ans) {
				System.out.print(n + " ");
			}
		}
	}

}
