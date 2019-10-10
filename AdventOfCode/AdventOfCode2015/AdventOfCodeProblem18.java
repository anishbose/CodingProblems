/**
 * @(#)AdventOfCodeProblem18.java
 *
 *
 * @author 
 * @version 1.00 2015/12/20
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem18 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem18.txt"));
			
			char[][] grid = new char[102][102];
			char[][] oldGrid = new char[100][100];
			char[][] extraGrid = new char[102][102];
			int line = 0;
			while (bab.hasNextLine())
			{
				oldGrid[line] = bab.nextLine().toCharArray();
				line++;
			}
			oldGrid[0][0] = '#';
			oldGrid[0][99] = '#';
			oldGrid[99][0] = '#';
			oldGrid[99][99] = '#';
			for(int i = 1; i < 101; i++)
			{
				for(int j = 1; j < 101; j++)
				{
					grid[i][j] = oldGrid[i-1][j-1];
				}
			}
			for(int i = 1; i < 101; i++)
			{
				for(int j = 1; j < 101; j++)
				{
					extraGrid[i][j] = grid[i][j];
				}
			}
			
			for(int a = 0; a < 100; a++)
			{
				for(int i = 1; i < 101; i++)
				{
					for(int j = 1; j < 101; j++)
					{
						
						if(grid[i][j] == '#')
						{
							if(getCount(i, j, grid) != 2 && getCount(i, j, grid) != 3)
							{
								extraGrid[i][j] = '.';
							}
						}
						else{
							if(getCount(i, j, grid) == 3)
							{
								extraGrid[i][j] = '#';
							}
						}
					}
				}
				extraGrid[1][1] = '#';
				extraGrid[1][100] = '#';
				extraGrid[100][1] = '#';
				extraGrid[100][100] = '#';
				for(int i = 1; i < 101; i++)
				{
					for(int j = 1; j < 101; j++)
					{
						grid[i][j] = extraGrid[i][j];
					}
				}
				
			}
			int total = 0;
			for(int i = 1; i < 101; i++)
			{
				for(int j = 1; j < 101; j++)
				{
					if(grid[i][j] == '#')
					{
						total++;
					}
				}
			}
			out.println(total);
			bab.close();
    	}
    	
    	public static int getCount(int i, int j, char[][] grid)
    	{
    		int count = 0;
    		if(grid[i+1][j+1] == '#')
    		{
    			count++;
    		}
    		if(grid[i+1][j] == '#')
    		{
    			count++;
    		}
    		if(grid[i+1][j-1] == '#')
    		{
    			count++;
    		}
    		if(grid[i][j+1] == '#')
    		{
    			count++;
    		}
    		if(grid[i][j-1] == '#')
    		{
    			count++;
    		}
    		if(grid[i-1][j-1] == '#')
    		{
    			count++;
    		}
    		if(grid[i-1][j] == '#')
    		{
    			count++;
    		}
    		if(grid[i-1][j+1] == '#')
    		{
    			count++;
    		}
    		return count;
    	}
}