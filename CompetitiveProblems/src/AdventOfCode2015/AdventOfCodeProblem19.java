/**
 * @(#)AdventOfCodeProblem19.java
 *
 *
 * @author 
 * @version 1.00 2015/12/21
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem19 {
        
        static HashSet<String> attempts = new HashSet<String>();
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem19.txt"));
			
			ArrayList<String[]> replacements = new ArrayList<String[]>();
			HashMap<String, String> swap = new HashMap<String, String>();
			
			while (bab.hasNextLine())
			{
				String[] s = bab.nextLine().split(" ");
				if(s.length == 1)
				{
					break;
				}
				else
				{
					String[] input = new String[2];
					input[0] = s[0];
					input[1] = s[2];
					replacements.add(input);
					swap.put(input[1], input[0]);
				}
			}
			String str = bab.nextLine();
			String copy = str;
			// PART 1 CODE
			/*
			out.println(str);
			HashSet<String> combos = new HashSet<String>();
			for(int i = 0; i < replacements.size(); i++)
			{
				String initial = replacements.get(i)[0];
				int length = initial.length();
				String end = replacements.get(i)[1];
				for(int j = 0; j <= str.length() - length; j++)
				{
					if(str.substring(j, j+length).equals(initial))
					{
						str = str.substring(0, j) + end + str.substring(j+length);
						combos.add(str);
						str = copy;
					}
				}
			}
			out.println(combos.size());*/
			attempts.add(copy);
			int count = 0;
			out.println(str);
			out.println("starting recursive");
			recurse(str, copy, swap, count);
			out.println(attempts.size());
			bab.close();
    	}
    	
    	public static void recurse(String str, String copy, HashMap<String, String> swap, int count)
    	{
    		ArrayList<String> simulations = findSimulations(str, copy, swap);
    		if(simulations.size() > 0)
    		{
    			for(int i = 0; i < simulations.size(); i++)
    			{
    				String s = simulations.get(i);
    				if(!attempts.contains(s))
    				{
    					attempts.add(s);
    					int num = count+1;
	    				if(s.equals("e"))
	    				{
	    					out.println("HOLY SHIT IT WORKED");
	    					out.println(count);
	    					break;
	    				}
	    				else
	    				{
	    					copy = str;
	    					recurse(s, copy, swap, num);
	    				}
    				}
    			}
    		}
    	}
    	
    	public static ArrayList<String> findSimulations(String str, String copy, HashMap<String, String> swap)
    	{
    		ArrayList<String> simulations = new ArrayList<String>();
    		for(int i = 0; i < str.length(); i++)
    		{
    			for(int j = 1; j < 11; j++)
    			{
    				if(i+j <= str.length())
    				{
    					if(swap.containsKey(str.substring(i, i+j)))
    					{
							str = str.substring(0, i) + swap.get(str.substring(i, i+j)) + str.substring(i+j);
							simulations.add(str);
							str = copy;
    					}
    				}
    			}
    		}
    		return simulations;
    	}
    	
}