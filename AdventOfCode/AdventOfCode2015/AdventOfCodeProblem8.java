/**
 * @(#)AdventOfCodeProblem8.java
 *
 *
 * @author 
 * @version 1.00 2015/12/7
 */

import java.io.*;
import java.util.*;

public class AdventOfCodeProblem8 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem8.txt"));
			
			//int totalChars = 0;
			//int totalMemory = 0;
			int totalNewChars = 0;
			//int count = 3;
			while (bab.hasNextLine())
			{
				//count--;
				String s = bab.nextLine();
				//totalChars+=s.length();
				//int memCount = 0;
				int slashCount = 0;
				int quoteCount = 0;
				int extraQuotes = 4;
				for(int i = 1; i < s.length() - 1; i++)
				{
					String c = s.substring(i, i + 1);
					/*if(c.equals("\\"))
					{
						String next  = s.substring(i + 1, i + 2);
						if(next.equals("\"") || next.equals("\\"))
						{
							i+=1;
							memCount++;
						}
						else
						{
							memCount++;
							i+=3;
						}
					}
					else
					{
						memCount++;
					}*/
					if(c.equals(("\\")))
					{
						slashCount++;
					}
					if(c.equals("\""))
					{
						quoteCount++;
					}
				}
				totalNewChars+=(quoteCount + slashCount + extraQuotes);
				//totalMemory+=memCount;
			}
			System.out.println(totalNewChars);
			bab.close();
    	}
}