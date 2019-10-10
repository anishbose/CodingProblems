/**
 * @(#)AdventOfCodeProblem24.java
 *
 *
 * @author 
 * @version 1.00 2015/12/23
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem24 {
        
    	static HashSet<ArrayList<Integer>> combinations = new HashSet<ArrayList<Integer>>();
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem24.txt"));
     		ArrayList<Integer> packages = new ArrayList<Integer>();
     		while(bab.hasNextLine())
     		{
     			int i = Integer.parseInt(bab.nextLine());
     			packages.add(i);
     		}
     		int totalWeight = 0;
     		for(int i = 0; i < packages.size(); i++)
     		{
     			totalWeight+=packages.get(i);
     		}
     		int goal = totalWeight/4;
			out.println(totalWeight);
			out.println(goal);
			// FINDS ALL COMBINATIONS OF ADDING TO 508
			for(int i = 0; i < packages.size(); i++)
			{
				out.println("trying starting at package " + i);
				ArrayList<Integer> current = new ArrayList<Integer>();
				findGoal(packages, i, goal, current);
			}
			out.println(combinations.size());
			int smallestSize = 28;
			// FINDS SMALLEST SET SIZE OF VALUES THAT ADD TO 508
			for(ArrayList<Integer> i : combinations)
			{
				if(i.size() < smallestSize)
				{
					smallestSize = i.size();
				}
			}
			out.println("smallest size = " + smallestSize);
			
			HashSet<ArrayList<Integer>> smallestSizeSets = new HashSet<ArrayList<Integer>>();
			ArrayList<Long> quantumEntanglement = new ArrayList<Long>();
			// ADDS ALL SETS OF SMALLEST SET SIZE TO NEW SET
			for(ArrayList<Integer> i : combinations)
			{
				if(i.size() == smallestSize)
				{
					smallestSizeSets.add(i);
				}
			}
			out.println(smallestSizeSets.size());
			// FINDS QE OF EACH SMALL SET
			long total = 1;
			for(ArrayList<Integer> i : smallestSizeSets)
			{
				total = 1;
				for(int j = 0; j < i.size(); j++)
				{
					total*=i.get(j);
				}
				quantumEntanglement.add(total);
			}
			
			// FINDS LOWEST QE OF ALL SETS
			long lowestQE = Long.MAX_VALUE;
			for(int i = 0; i < quantumEntanglement.size(); i++)
			{
				if(lowestQE > quantumEntanglement.get(i))
				{
					lowestQE = quantumEntanglement.get(i);
				}
			}
			out.println(lowestQE);
			bab.close();
    	}
    	
    	public static void findGoal(ArrayList<Integer> packages, int pos, int goal, ArrayList<Integer> current)
    	{
    		if(pos > -1 && pos < packages.size())
    		{
    			current.add(packages.get(pos));
    			if(sum(current) == goal)
    			{
    				Collections.sort(current);
    				combinations.add(current);
    			}
    			else if(sum(current) < goal)
    			{
    				for(int i = 1; pos+i < packages.size(); i++)
    				{
    					findGoal(packages, pos+i, goal, new ArrayList<Integer>(current));
    				}
    			}
    		}
    	}
    	
    	public static int sum(ArrayList<Integer> packages)
    	{
    		int sum = 0;
    		for(int i = 0; i < packages.size(); i++)
    		{
    			sum+=packages.get(i);
    		}
    		return sum;
    	}
    	
}