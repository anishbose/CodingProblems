package Leetcode;
import java.util.*;
public class MaximumSubarray {
	    public int maxSubArray(int[] nums) {
	        if(nums.length == 1) return nums[0];
	        int[] sums = new int[nums.length];
	        sums[0] = nums[0];
	        for(int i = 1; i < sums.length; i++) {
	            sums[i] = sums[i-1] + nums[i];
	        }
	        int maxSum = nums[0];
	        int lowest = Math.min(nums[0], 0);
	        for(int i = 1; i < sums.length; i++) {
	            maxSum = Math.max(maxSum, sums[i] - lowest);
	            lowest = Math.min(lowest, sums[i]);
	        }
	        return maxSum;
	    }
}
