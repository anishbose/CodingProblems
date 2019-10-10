/**
 * @(#)AdventOfCodeProblem3.java
 *
 *
 * @author 
 * @version 1.00 2015/12/4
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem3 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem3.txt"));
			
			String s = bab.nextLine();
			Set<String> houses = new TreeSet<String>();
			int xPos = 0;
			int yPos = 0;
			int x1Pos = 0;
			int y1Pos = 0;
			for(int i = 0; i < s.length(); i+=2)
			{
				char dir = s.charAt(i);
				String coords = "";
				if(dir == '^')
				{
					yPos++;
				}
				else if(dir == '>')
				{
					xPos++;
				}
				else if(dir == '<')
				{
					xPos--;
				}
				else yPos--;
				
				coords = xPos + " " + yPos;
				houses.add(coords);
			}
			for(int i = 1; i < s.length(); i+=2)
			{
				char dir = s.charAt(i);
				String coords = "";
				if(dir == '^')
				{
					y1Pos++;
				}
				else if(dir == '>')
				{
					x1Pos++;
				}
				else if(dir == '<')
				{
					x1Pos--;
				}
				else y1Pos--;
				
				coords = x1Pos + " " + y1Pos;
				houses.add(coords);
			}
			out.println(houses.size());
			bab.close();
    	}
}