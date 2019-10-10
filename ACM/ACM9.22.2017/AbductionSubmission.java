import java.io.*;
import java.util.*;
import java.lang.Math;

public class AbductionSubmission {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++){
            int N = scan.nextInt();
            int K = scan.nextInt();
            
            long[] nums = new long[N];
            
            long maxinit = 0;
            
            
            for(int j = 0; j < K; j++){
                nums[j] = scan.nextLong();
            }
            long finMax = 0;
            for(int j = K; j < N; j++){
                long x = scan.nextLong();
                nums[j] = x;
                //System.out.println(Arrays.toString(nums));
                //System.out.println(j-K + " " + (j-K-K+1));
                long max = 0;
                for(int a = j-K; a >= j-K-K+1; a--) {
                    if(a < 0) break;
                    max = Math.max(max, nums[a]);
                }
                nums[j] = x + max;
                finMax = Math.max(finMax, nums[j]);
            }
            System.out.println(finMax);
            //System.out.println(nums[N - 1]);
        }
    }
}