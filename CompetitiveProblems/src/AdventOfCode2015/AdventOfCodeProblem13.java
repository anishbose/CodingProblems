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

public class AdventOfCodeProblem13 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem13.txt"));
     		
     		Map<String, Integer> arrangements = new HashMap<String, Integer>();
			Set<String> diffSeats = new TreeSet<String>();
			boolean sign = true;
			while (bab.hasNextLine())
			{
				sign = true;
				String[] s = bab.nextLine().split(" ");
				String c = "";
				String last = s[s.length - 1];
				c+= s[0] + " " + (last.substring(0, last.length() - 1));
				String me = "Me " + s[0];
				String meRev = (last.substring(0, last.length() - 1)) + " Me";
				arrangements.put(me, 0);
				arrangements.put(meRev, 0);
				out.println(c);
				if(s[2].equals("lose"))
				{
					sign = false;
				}
				if(sign)
				{
					arrangements.put(c, Integer.parseInt(s[3]));
					
				}
				else{
					arrangements.put(c, Integer.parseInt(s[3]) * -1);
				}
				diffSeats.add(s[0]);
			}
			diffSeats.add("Me");
			System.out.println(arrangements.size());
			System.out.println(diffSeats.size());
			String[] seats = diffSeats.toArray(new String[diffSeats.size()]);
			//out.println(Arrays.toString(seats));
			int lowestCount = Integer.MAX_VALUE;
			int highestCount = Integer.MIN_VALUE;
			out.println();
			for(int a = 0; a < 9; a++)
			{
				out.println(a);
				for(int b = 0; b < 9; b++)
				{
					for(int c = 0; c < 9; c++)
					{
						for(int d = 0; d < 9; d++)
						{
							for(int e = 0; e < 9; e++)
							{
								for(int f = 0; f < 9; f++)
								{
									for(int g = 0; g < 9; g++)
									{
										for(int h = 0; h < 9; h++)
										{
											for(int j = 0; j < 9; j++)
											{
												String total = "";
												if(allDifferent(a, b, c, d, e, f, g, h, j))
												{
													total+=(seats[a] + " " + seats[b] + "  ");
													total+=(seats[b] + " " + seats[a] + "  ");
													total+=(seats[b] + " " + seats[c] + "  ");
													total+=(seats[c] + " " + seats[b] + "  ");
													total+=(seats[c] + " " + seats[d] + "  ");
													total+=(seats[d] + " " + seats[c] + "  ");
													total+=(seats[d] + " " + seats[e] + "  ");
													total+=(seats[e] + " " + seats[d] + "  ");
													total+=(seats[e] + " " + seats[f] + "  ");
													total+=(seats[f] + " " + seats[e] + "  ");
													total+=(seats[f] + " " + seats[g] + "  ");
													total+=(seats[g] + " " + seats[f] + "  ");
													total+=(seats[g] + " " + seats[h] + "  ");
													total+=(seats[h] + " " + seats[g] + "  ");
													total+=(seats[h] + " " + seats[j] + "  ");
													total+=(seats[j] + " " + seats[h] + "  ");
													total+=(seats[j] + " " + seats[a] + "  ");
													total+=(seats[a] + " " + seats[j]);
													
													int currentCount = 0;
													String[] distances = total.split("  ");
													for(int i = 0; i < distances.length; i++)
													{
														currentCount+= arrangements.get(distances[i]);
													}
													
													if(currentCount < lowestCount)
													{
														lowestCount = currentCount;
													}
													if(currentCount > highestCount)
													{
														//out.println(Arrays.toString(distances));
														highestCount = currentCount;
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
			}
			/*for(int a = 0; a < 8; a++)
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
												total+=(seats[a] + " " + seats[b] + "  ");
												total+=(seats[b] + " " + seats[a] + "  ");
												total+=(seats[b] + " " + seats[c] + "  ");
												total+=(seats[c] + " " + seats[b] + "  ");
												total+=(seats[c] + " " + seats[d] + "  ");
												total+=(seats[d] + " " + seats[c] + "  ");
												total+=(seats[d] + " " + seats[e] + "  ");
												total+=(seats[e] + " " + seats[d] + "  ");
												total+=(seats[e] + " " + seats[f] + "  ");
												total+=(seats[f] + " " + seats[e] + "  ");
												total+=(seats[f] + " " + seats[g] + "  ");
												total+=(seats[g] + " " + seats[f] + "  ");
												total+=(seats[g] + " " + seats[h] + "  ");
												total+=(seats[h] + " " + seats[g] + "  ");
												total+=(seats[h] + " " + seats[a] + "  ");
												total+=(seats[a] + " " + seats[h]);
												
												int currentCount = 0;
												String[] distances = total.split("  ");
												for(int i = 0; i < distances.length; i++)
												{
													currentCount+= arrangements.get(distances[i]);
												}
												
												if(currentCount < lowestCount)
												{
													lowestCount = currentCount;
												}
												if(currentCount > highestCount)
												{
													out.println(Arrays.toString(distances));
													highestCount = currentCount;
												}	
											}
										}
									}
								}
							}
						}
					}
				}
			}*/
			out.println(lowestCount);
			out.println(highestCount);
			bab.close();
    	}
    	
    	/*public static boolean allDifferent(int a, int b, int c, int d, int e, int f, int g, int h)
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
		}*/
		
		public static boolean allDifferent(int a, int b, int c, int d, int e, int f, int g, int h, int j)
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
			nums.add(j);
			if(nums.size() == 9){
				return true;
			}
			return false;
		}
		
}