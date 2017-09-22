package Leetcode;

public class ReverseBits {
	public int reverseBits(int n) {
        long answer = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                answer += 1;
            }
            answer= answer << 1;
            n = n >> 1;
        }
        answer = answer >> 1;
        return (int)answer;
    }
}
