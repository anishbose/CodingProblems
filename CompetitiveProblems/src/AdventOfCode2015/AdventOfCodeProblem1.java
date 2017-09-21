/**
 * @(#)AdventOfCodeProblem1.java
 *
 *
 * @author 
 * @version 1.00 2015/12/4
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem1 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem1.txt"));
			
			String s = bab.nextLine();
			int count = 0;
			int position = 0;
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) == '(')
				{
					count++;
				}
				else
				{
					count--;
				}
				
				if(count == -1)
				{
					position = i;
					break;
				}
			}
			
			out.println(count);
			out.println(position + 1);
			bab.close();
    	}
}