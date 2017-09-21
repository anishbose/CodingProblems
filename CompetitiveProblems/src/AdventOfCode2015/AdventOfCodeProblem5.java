/**
 * @(#)AdventOfCodeProblem5.java
 *
 *
 * @author 
 * @version 1.00 2015/12/5
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem5 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem5.txt"));
			int count = 0;
			while (bab.hasNextLine())
			{
				//int vowels = 0;
				String s = bab.nextLine();
				/*if(s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy"))
				{
					
				}
				else{
					for(int i = 0; i < s.length(); i++)
					{
						char c = s.charAt(i);
						if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
						{
							vowels++;
						}
						
					}
					if(vowels >= 3)
					{
						boolean doubleLetter = false;
						for(int i = 0; i < s.length() - 1; i++)
						{
							if(s.charAt(i) == s.charAt(i + 1))
							{
								doubleLetter = true;
							}
						}
						if(doubleLetter)
						{
							count++;
						}
					}*/
					boolean pairs = false;
					for(int i = 0; i < s.length() - 3; i++)
					{
						String pair = s.substring(i, i+2);
						for(int j = i+2; j < s.length() - 1; j++)
						{
							String pairCheck = s.substring(j, j+2);
							if(pair.equals(pairCheck))
							{
								pairs = true;
							}
						}
					}
					if(pairs)
					{
						for(int i = 0; i < s.length() - 2; i++)
						{
							if(s.charAt(i) == s.charAt(i+2))
							{
								count++;
								break;
							}
						}
					}
				}
				out.println(count);
				bab.close();
			}
		}