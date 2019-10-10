/**
 * @(#)AdventOfCodeProblem2.java
 *
 *
 * @author 
 * @version 1.00 2015/12/4
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem2 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem2.txt"));
			
			int total = 0;
			int ribbonTotal = 0;
			while (bab.hasNextLine())
			{
				String[] s = bab.nextLine().split("x");
				
				int s1 = Integer.parseInt(s[0]);
				int s2 = Integer.parseInt(s[1]);
				int s3 = Integer.parseInt(s[2]);
				
				int surfaceArea = 2*s1*s2 + 2*s1*s3 + 2*s2*s3;
				
				ArrayList<Integer> nums = new ArrayList<Integer>();
				nums.add(s1);
				nums.add(s2);
				nums.add(s3);
				Collections.sort(nums);
				System.out.println(nums.get(0));
				
				surfaceArea += (nums.get(0) * nums.get(1));
				
				total += surfaceArea;
				
				ribbonTotal += s1*s2*s3;
				ribbonTotal += 2 * (nums.get(0) + nums.get(1));
				
			}
			out.println(total);
			out.println(ribbonTotal);
			bab.close();
    	}
}