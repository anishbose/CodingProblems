import java.util.*;
public class TopXInListOfY {

	public static void main(String[] args) {
		int size = 20 + (int)(Math.random()*100);
		int[] nums = new int[size];
		for(int i = 0; i < size; i++) {
			nums[i] = (int)(Math.random()*10000);
		}
		
		int topX = 1 + (int)(Math.random() * 20);
		System.out.println(size + " " + topX);
		int[] topXNums = getTopNums(nums, topX);
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(topXNums));
	}
	
	public static int[] getTopNums(int[] nums, int topX) {
		Comparator<Integer> compare = new TopNumComparator();
		PriorityQueue<Integer> topNums = new PriorityQueue<Integer>(topX, compare);
		for(int i = 0; i < topX; i++) {
			topNums.add(nums[i]);
		}
		for(int i = topX; i < nums.length; i++) {
			if(topNums.peek() < nums[topX]) {
				topNums.poll();
				topNums.add(nums[topX]);
			}
		}
		int[] topXNums = new int[topX];
		for(int i = 0; i < topX; i++) {
			topXNums[i] = topNums.poll();
		}
		
		return topXNums;
		
		
	}

}

class TopNumComparator implements Comparator<Integer> {
	public int compare(Integer x, Integer y) {
		if(x > y) return -1;
		if(y > x) return 1;
		return 0;
	}

}