/**
 * @(#)AdventOfCodeProblem11.java
 *
 *
 * @author 
 * @version 1.00 2015/12/10
 */

import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem11 {
        
    	public static void main(String[] args)
    	{
     		String s = "hepxxzaa";
     		int i = 0;
     		int j = 0;
			while(!condition(s))
			{
				j = i;
				s = increment(s);
				i = s.charAt(3);
				if(j != i)
				{
					out.println(s);
				}
			}
			out.println(s);
    	}
    	
		public static boolean condition(String s)
		{
			int count = 0;
			for(int i = 0; i < s.length()-2; i++)
			{
				String consec = s.substring(i, i+3);
				if(consec.charAt(0) + 1 == consec.charAt(1) && consec.charAt(1) + 1 == consec.charAt(2))
				{
					count++;
					break;
				}
			}
			if(s.contains("i") || s.contains("o") || s.contains("l"))
			{
				
			}
			else count++;
			
			if(thirdCheck(s))
			{
				count++;
			}
			if(count == 3)
			{
				return true;
			}
			return false;
		}
		
		public static String increment(String s)
		{
			//97 = a, 122 = z
			char[] letters = new char[s.length()];
			for(int i = 0; i < letters.length; i++)
			{
				letters[i] = s.charAt(i);
			}
			letters[letters.length - 1]++;
			for(int i = letters.length - 1; i > 0; i--)
			{
				if(letters[i] > 122)
				{
					letters[i] = 97;
					letters[i - 1]++;
				}
			}
			String fin = "";
			for(int i = 0; i < letters.length; i++)
			{
				fin+=letters[i];
			}
			return fin;
		}
		
		public static boolean thirdCheck(String s)
		{
			Set<String> dub = new HashSet<String>();
			String d = "";
			for(int i = 0; i < s.length() - 1; i++)
			{
				d = s.substring(i, i + 2);
				if(d.charAt(0) == d.charAt(1))
				{
					dub.add(d);
				}
			}
			if(dub.size() > 1)
			{
				return true;
			}
			return false;
		}
		    	
}