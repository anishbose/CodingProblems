import java.util.*;
public class TopXInListOfY {

	public static void main(String[] args) {
		int size = 20 + (int)(Math.random()*100);
		int[] nums = new int[size];
		for(int i = 0; i < size; i++) {
			nums[i] = (int)(Math.random()*10000);
		}
		
		int topX = 1 + (int)(Math.random() * 20);
		
		int[] topXNums = getTopNums(nums, topX);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(topXNums));
	}
	
	public static int[] getTopNums(int[] nums, int topX) {
		Comparator<Integer> compare = new TopNumComparator();
		PriorityQueue<Integer> topNums = new PriorityQueue<Integer>(10, compare);
		for(int i = 0; i < nums.length; i++) {
			topNums.add(nums[i]);
		}
		int[] topXNums = new int[topX];
		for(int i = 0; i < topX; i++) {
			topXNums[i] = topNums.poll();
			topNums.remove(topXNums[i]);
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