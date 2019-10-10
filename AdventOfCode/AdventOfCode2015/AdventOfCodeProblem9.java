/**
 * @(#)AdventOfCodeProblem9.java
 *
 *
 * @author 
 * @version 1.00 2015/12/8
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem9 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem9.txt"));
     		
     		Map<String, Integer> locations = new HashMap<String, Integer>();
			Set<String> listCities = new TreeSet<String>();
			
			while (bab.hasNextLine())
			{
				
				String[] s = bab.nextLine().split(" ");
				String c = "";
				String cReverse = "";
				c+= s[0] + " " + s[2];
				cReverse += s[2] + " " + s[0];
				locations.put(c, Integer.parseInt(s[4]));
				locations.put(cReverse, Integer.parseInt(s[4]));
				listCities.add(s[0]);
				listCities.add(s[2]);
			}
			System.out.println(locations.size());
			System.out.println(listCities.size());
			
			String[] cities = listCities.toArray(new String[listCities.size()]);
			out.println(Arrays.toString(cities));
			
			//ArrayList<String> combos = new ArrayList<String>();
			int lowestCount = Integer.MAX_VALUE;
			int highestCount = Integer.MIN_VALUE;
			out.println();
			out.println();
			for(int a = 0; a < 8; a++)
			{
				for(int b = 0; b < 8; b++)
				{
					for(int c = 0; c < 8; c++)
					{
						for(int d = 0; d < 8; d++)
						{
							for(int e = 0; e < 8; e++)
							{
								for(int f = 0; f < 8; f++)
								{
									for(int g = 0; g < 8; g++)
									{
										for(int h = 0; h < 8; h++)
										{
											String total = "";
											if(allDifferent(a, b, c, d, e, f, g, h))
											{
												total+=(cities[a] + " " + cities[b] + "  ");
												total+=(cities[b] + " " + cities[c] + "  ");
												total+=(cities[c] + " " + cities[d] + "  ");
												total+=(cities[d] + " " + cities[e] + "  ");
												total+=(cities[e] + " " + cities[f] + "  ");
												total+=(cities[f] + " " + cities[g] + "  ");
												total+=(cities[g] + " " + cities[h]);
												
												//out.println(total);
												int currentCount = 0;
												String[] distances = total.split("  ");
												//out.println("Array: " + Arrays.toString(distances));
												for(int i = 0; i < distances.length; i++)
												{
													//out.println(distances[i]);
													currentCount+= locations.get(distances[i]);
													//out.println("hi");
												}
												if(currentCount < lowestCount)
												{
													lowestCount = currentCount;
													//out.println(lowestCount);
												}
												if(currentCount > highestCount)
												{
													highestCount = currentCount;
													out.println(highestCount);
												}	
											}
										}
									}
								}
							}
						}
					}
				}
			}
			out.println(lowestCount);
			out.println(highestCount);
			bab.close();
    	}
    	
    	public static boolean allDifferent(int a, int b, int c, int d, int e, int f, int g, int h)
		{
			Set<Integer> nums = new HashSet<Integer>();
			nums.add(a);
			nums.add(b);
			nums.add(c);
			nums.add(d);
			nums.add(e);
			nums.add(f);
			nums.add(g);
			nums.add(h);
			if(nums.size() == 8){
				return true;
			}
			return false;
		}
}