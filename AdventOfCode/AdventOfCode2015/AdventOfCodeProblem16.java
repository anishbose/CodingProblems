/**
 * @(#)AdventOfCodeProblem16.java
 *
 *
 * @author 
 * @version 1.00 2015/12/15
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem16 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem16.txt"));
			String[] realAunt = {"0", "3", "7", "2", "3", "0", "0", "5", "3", "2", "1"};
			ArrayList<String[]> aunts = new ArrayList<String[]>();
			while (bab.hasNextLine())
			{
				String[] aunt = new String[11];	
				Arrays.fill(aunt, "-1");
				String s[] = bab.nextLine().split(" ");
				s[3] = s[3].substring(0, s[3].length() - 1);
				s[5] = s[5].substring(0, s[5].length() - 1);
				aunt[0] = s[1].substring(0, s[1].length()-1);
				for(int i = 2; i < s.length; i+=2)
				{
					String info = s[i];
					if(info.equals("children:"))
					{
						aunt[1] = s[i+1];
					}
					else if(info.equals("cats:"))
					{
						aunt[2] = s[i+1];
					}
					else if(info.equals("samoyeds:"))
					{
						aunt[3] = s[i+1];
					}
					else if(info.equals("pomeranians:"))
					{
						aunt[4] = s[i+1];
					}
					else if(info.equals("akitas:"))
					{
						aunt[5] = s[i+1];
					}
					else if(info.equals("vizslas:"))
					{
						aunt[6] = s[i+1];
					}
					else if(info.equals("goldfish:"))
					{
						aunt[7] = s[i+1];
					}
					else if(info.equals("trees:"))
					{
						aunt[8] = s[i+1];
					}
					else if(info.equals("cars:"))
					{
						aunt[9] = s[i+1];
					}
					else if(info.equals("perfumes:"))
					{
						aunt[10] = s[i+1];
					}
				}
				aunts.add(aunt);
			}
			for(int i = 0; i < aunts.size(); i++)
			{
				int counter = 0;
				String[] check = aunts.get(i);
				for(int j = 1; j < check.length; j++)
				{
					if(j == 2)
					{
						if(Integer.parseInt(check[j]) != -1 && Integer.parseInt(check[j]) > Integer.parseInt(realAunt[j]))
						{
							counter++;
						}
					}
					else if(j == 4)
					{
						if(Integer.parseInt(check[j]) != -1 && Integer.parseInt(check[j]) < Integer.parseInt(realAunt[j]))
						{
							counter++;
						}
					}
					else if(j == 7)
					{
						if(Integer.parseInt(check[j]) != -1 && Integer.parseInt(check[j]) < Integer.parseInt(realAunt[j]))
						{
							counter++;
						}
					}
					else if(j == 8)
					{
						if(Integer.parseInt(check[j]) != -1 && Integer.parseInt(check[j]) > Integer.parseInt(realAunt[j]))
						{
							counter++;
						}
					}
					else
					{
						if(check[j].equals(realAunt[j]))
						{
							counter++;
						}
					}
				}
				if(counter == 3)
				{
					out.println(check[0]);
				}
				
			}
			bab.close();
    	}
}