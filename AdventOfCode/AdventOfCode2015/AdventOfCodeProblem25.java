/**
 * @(#)AdventOfCodeProblem25.java
 *
 *
 * @author 
 * @version 1.00 2015/12/24
 */

import java.io.*;
import static java.lang.System.*;

public class AdventOfCodeProblem25 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		int row = 2981;
     		int col = 3075;
     		int triNum = row-1+col;
			int triangleNumber = findTri(triNum);
			int iterations = triangleNumber - (triNum-col) - 1;
			out.println(iterations);
			long old = 20151125;
			long cur = 20151125;
			for(int i = 0; i < iterations; i++)
			{
				cur = (old*252533) % 33554393;
				old = cur;
			}
			out.println(cur);
    	}
    	
    	public static int findTri(int num)
    	{
    		int count = 0;
    		int separation = 1;
    		for(int i = 1; i <= num; i++)
    		{
    			count+=separation;
    			separation++;
    		}
    		return count;
    	}
}