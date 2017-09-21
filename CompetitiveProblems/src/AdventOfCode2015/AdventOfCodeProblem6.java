/**
 * @(#)AdventOfCodeProblem6.java
 *
 *
 * @author 
 * @version 1.00 2015/12/6
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem6 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem6.txt"));
			
			int[][] grid = new int[1000][1000];
			//int count = 2;
			while (bab.hasNextLine())
			{
				//count--;
				String[] s = bab.nextLine().split(" ");
				String situation = "";
				if(s.length == 4)
				{
					situation = "toggle";
				}
				else if(s[1].equals("off"))
				{
					situation = "off";
				}
				else situation = "on";
				int startX = 0;
				int startY = 0;
				int endX = 0;
				int endY = 0;
				if(situation.equals("toggle"))
				{
					String[] start = s[1].split(",");
					String[] end = s[3].split(",");
					startX = Integer.parseInt(start[0]);
					startY = Integer.parseInt(start[1]);
					endX = Integer.parseInt(end[0]);
					endY = Integer.parseInt(end[1]);
					
				}
				else{
					String[] start = s[2].split(",");
					String[] end = s[4].split(",");
					startX = Integer.parseInt(start[0]);
					startY = Integer.parseInt(start[1]);
					endX = Integer.parseInt(end[0]);
					endY = Integer.parseInt(end[1]);
				}
				//out.println(startX + " " + startY + " " + endX + " " + endY);
				/*
				for(int i = startY; i <= endY; i++)
				{
					for(int j = startX; j <= endX; j++)
					{
						if(situation.equals("toggle"))
						{
							grid[i][j] = (grid[i][j] + 1) % 2;
						}
						else if(situation.equals("on"))
						{
							grid[i][j] = 1;
						}
						else grid[i][j] = 0;
							
					}
				}*/
				
				for(int i = startY; i <= endY; i++)
				{
					for(int j = startX; j <= endX; j++)
					{
						if(situation.equals("toggle"))
						{
							grid[i][j]+=2;
						}
						else if(situation.equals("on"))
						{
							grid[i][j]+=1;
						}
						else
						{
							 if(grid[i][j] == 0)
							 {
							 	
							 }
							 else grid[i][j]-=1;
							 
						}
					}
				}
				
				
			}
			int total = 0;
			for(int i = 0; i < grid.length; i++)
			{
				for(int j = 0; j < grid.length; j++)
				{
					total+=grid[i][j];
				}
			}
			out.println(total);
			bab.close();
    	}
}