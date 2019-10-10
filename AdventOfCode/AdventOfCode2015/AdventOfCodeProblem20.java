/**
 * @(#)AdventOfCodeProblem20.java
 *
 *
 * @author 
 * @version 1.00 2015/12/20
 */

import static java.lang.System.*;

public class AdventOfCodeProblem20 {
        
    	public static void main(String[] args){
			
     		int num = 36000000;
     		int sum = 0;
     		int number = 1;
     		int max = Integer.MIN_VALUE;
     		
     		while(sum < num/11)
     		{
     			sum = 0;
     			for(int i = 1; i <= number/2; i++)
     			{
     				if((number % i == 0) && ((number / i) < 51))
     				{
     					sum+=i;
     				}
     			}
     			sum+=number;
     			if(max < sum)
     			{
     				max = sum;
     				out.println("New max: " + sum + " at " + number);
     			}
     			number++;
     		}
     		out.println(--number);
     			
    	}
}