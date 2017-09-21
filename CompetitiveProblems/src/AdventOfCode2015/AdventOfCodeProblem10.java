/**
 * @(#)test.java
 *
 *
 * @author 
 * @version 1.00 2015/12/10
 */

public class AdventOfCodeProblem10 {
        
    	public static void main(String[] args){
			
     		String s = "3113322113";
     		int times = 0;
     		for(int i = 0; i < 50; i++)
     		{
     			StringBuilder sb = new StringBuilder();
     			int count = 0;
     			for(int j = 0; j < s.length(); j++)
     			{
     				count = 0;
     				char ch = s.charAt(j);
     				while(j < s.length() && s.charAt(j) == ch)
     				{
     					j++;
     					count++;
     				}
     				//out.print(count + " " + s.charAt(j - count) + "   ");
     				sb.append(count);
     				sb.append(s.charAt(j - count));
     				j--;
     			}
     			s = sb.toString();
     			System.out.println(++times + " " + s.length());
     		}
    	}
}