/**
 * @(#)AdventOfCodeProblem11.java
 *
 *
 * @author 
 * @version 1.00 2015/12/11
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem12 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem12.txt"));
			
			String s = bab.nextLine();
			StringBuilder sb = new StringBuilder(s);
			for(int i = 0; i < sb.length() - 2; i++)
			{
				char c = sb.charAt(i);
				if(!isNum(c))
				{
					String red = sb.substring(i, i+3);
					if(!red.equals("red"))
					{
						sb.deleteCharAt(i);
						i--;
					}
					else
					{
						i+=2;
					}
				}
			}
			
			for(int i = 0; i < sb.length()-2; i++)
			{
				String red = sb.substring(i, i+3);
				if(red.equals("red"))
				{
					int brackets = 0;
					int braces = 0;
					int left = 0;
					int right = 0;
					for(int spot = i; spot > 0; spot--)
					{
						char c = sb.charAt(spot);
						
						if(c == '[')
						{
							brackets++;
						}
						if(c == ']')
						{
							brackets--;
						}
						if(c == '{')
						{
							braces++;
						}
						if(c == '}')
						{
							braces--;
						}
						if(c == '[' && brackets == 1)
						{
							break;
						}
						if(c == '{' && braces == 1)
						{
							left = spot;
							braces = 0;
							brackets = 0;
							for(int j = left+1; j < sb.length(); j++)
							{
								char b = sb.charAt(j);
								
								if(b == '{')
								{
									braces--;
								}
								if(b == '}')
								{
									braces++;
								}
								if(b == '}' && braces == 1)
								{
									right = j;
									break;
								}
							}
							sb.delete(left+1, right);
							i = left;
							spot = 0;
						}
					}
				}
			}
			
			
			String fin = sb.toString();
			int total = 0;
			int pos = 0;
			String current = "";
			while (pos < fin.length())
			{
				current = fin.substring(pos, pos + 1);
				if(isNumber(current))
				{
					int[] answers = solve(current, fin, pos);
					total+=answers[0];
					pos+=answers[1];
				}
				else
				{
					pos++;
				}
			}
			out.println(total);
			bab.close();
    	}
    	
    	
    	public static boolean isNum(char c)
    	{
    		if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || c == '-' || c == ']' || c == '[' || c == '}' || c == '{' || c == ',')
    		{
    			return true;
    		}
    		return false;
    	}
    	
    	
    	public static boolean isNumber(String s)
	    {
	    	if(s.contains("-") || s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9"))
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	    
	    
	    public static int[] solve(String letter, String input, int pos)
	    {
	    	int[] info = new int[2];
	    	String num = "";
	    	int begin = pos;
	    	while(isNumber(input.substring(pos, pos + 1)))
	    	{
	    		String s = input.substring(pos, pos + 1);
	    		num += s;
	    		pos++;
	    	}
	    	info[0] = Integer.parseInt(num);
	    	info[1] = pos - begin;
	    	return info;
	    }
}