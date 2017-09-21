/**
 * @(#)AdventOfCodeProblem15.java
 *
 *
 * @author 
 * @version 1.00 2015/12/14
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem15 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem15.txt"));
			
			ArrayList<String[]> ingredients = new ArrayList<String[]>();
			
			while (bab.hasNextLine())
			{
				String[] c = bab.nextLine().split(" ");
				String[] cookie = new String[6];
				cookie[0] = c[0];
				cookie[1] = c[2].substring(0, c[2].length()-1);
				cookie[2] = c[4].substring(0, c[4].length()-1);
				cookie[3] = c[6].substring(0, c[6].length()-1);
				cookie[4] = c[8].substring(0, c[8].length()-1);
				cookie[5] = c[10];
				ingredients.add(cookie);
			}
			// a, b, c, d indicate the amount of each ingredient
			ArrayList<int[]> combos = new ArrayList<int[]>();
			for(int a = 0; a < 101; a++)
			{
				for(int b = 0; b < 101; b++)
				{
					for(int c = 0; c < 101; c++)
					{
						for(int d = 0; d < 101; d++)
						{
							int calCount = 0;
							calCount = (a*(Integer.parseInt(ingredients.get(0)[5]))) + (b*(Integer.parseInt(ingredients.get(1)[5]))) + (c*(Integer.parseInt(ingredients.get(2)[5]))) + (d*(Integer.parseInt(ingredients.get(3)[5])));
							if(a+b+c+d == 100 && calCount == 500)
							{
								//out.println(a + " " + b + " " + c + " " + d + " equals 100");
								int[] stats = new int[4];
								// each array position = diff properties
								stats[0] = (a*(Integer.parseInt(ingredients.get(0)[1]))) + (b*(Integer.parseInt(ingredients.get(1)[1]))) + (c*(Integer.parseInt(ingredients.get(2)[1]))) + (d*(Integer.parseInt(ingredients.get(3)[1])));
								stats[1] = (a*(Integer.parseInt(ingredients.get(0)[2]))) + (b*(Integer.parseInt(ingredients.get(1)[2]))) + (c*(Integer.parseInt(ingredients.get(2)[2]))) + (d*(Integer.parseInt(ingredients.get(3)[2])));
								stats[2] = (a*(Integer.parseInt(ingredients.get(0)[3]))) + (b*(Integer.parseInt(ingredients.get(1)[3]))) + (c*(Integer.parseInt(ingredients.get(2)[3]))) + (d*(Integer.parseInt(ingredients.get(3)[3])));
								stats[3] = (a*(Integer.parseInt(ingredients.get(0)[4]))) + (b*(Integer.parseInt(ingredients.get(1)[4]))) + (c*(Integer.parseInt(ingredients.get(2)[4]))) + (d*(Integer.parseInt(ingredients.get(3)[4])));
								combos.add(stats);
								//out.println(Arrays.toString(stats));
							}
						}
					}
				}
			}
			ArrayList<Integer> totals = new ArrayList<Integer>();
			for(int i = 0; i < combos.size(); i++)
			{
				int total = 0;
				int[] combo = combos.get(i);
				if(combo[0] < 0 || combo[1] < 0 || combo[2] < 0 || combo[3] < 0)
				{
					total = 0;
				}
				else{
					total = combo[0] * combo[1] * combo[2] * combo[3];
				}
				out.println(total);
				totals.add(total);
			}
			Collections.sort(totals);
			out.println(totals.get(totals.size() - 1));
			bab.close();
    	}
}