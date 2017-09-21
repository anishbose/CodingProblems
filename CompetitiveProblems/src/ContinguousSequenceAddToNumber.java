import java.util.*;
public class ContinguousSequenceAddToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int[] nums = new int[s.length];
		for(int i = 0 ; i < s.length; i++) {
			nums[i] = Integer.parseInt(s[i]);
		}
		int target = sc.nextInt();
		
		/*int beg = 0;
		int end = 0;
		int sum = nums[0];
		if(sum == target) {
			System.out.println("Found");
		}
		
		while(end < nums.length) {
			while(sum < target && end < nums.length -1) {
				end++;
				sum+=nums[end];
			}
			if(sum == target) {
				System.out.println("Found");
				break;
			} else {
				while (sum > target && beg <= end) {
					sum-=nums[beg];
					beg++;
				}
			}
			if(sum == target) {
				System.out.println("Found");
				break;
			} else if (end == nums.length - 1 && sum != target) {
				System.out.println("Not found");
				break;
			}
		}*/
		
		int totalSum = 0;
		HashSet<Integer> runningSum = new HashSet<Integer>();
		runningSum.add(0);
		for(int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
			runningSum.add(totalSum);
			if(runningSum.contains(totalSum - target)) {
				System.out.println("Found it");
			}
		}
		System.out.println("None");

	}

}
