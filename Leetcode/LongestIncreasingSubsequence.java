package Leetcode;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            max = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }
        
        int LIS = 0;
        for(int i = 0; i < dp.length; i++) {
            LIS = Math.max(LIS, dp[i]);
        }
        
        return LIS;
        
    }
}
