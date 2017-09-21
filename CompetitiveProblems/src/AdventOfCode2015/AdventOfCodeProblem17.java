/**
 * @(#)AdventOfCodeProblem17.java
 *
 *
 * @author 
 * @version 1.00 2015/12/20
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem17 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			//out.println(i + " " + j + " " + k + " " + l + " " + m);
			Scanner bab = new Scanner(new File("AdventOfCodeProblem17.txt"));
     		ArrayList<Integer> containers = new ArrayList<Integer>();
     		//boolean[] condition = new boolean[containers.size()];
     		int count = 0;
     		int total = 0;
     		int cupCount = 0;
     		int answer = 0;
     		int lowestCup = Integer.MAX_VALUE;
     		while(bab.hasNextLine())
     		{
     			containers.add(Integer.parseInt(bab.nextLine()));
     		}
     		Collections.sort(containers);
     		for(int a = 0; a < 2; a++)
     		{
     			for(int b = 0; b < 2; b++)
	     		{
	     			for(int c = 0; c < 2; c++)
		     		{
		     			for(int d = 0; d < 2; d++)
			     		{
			     			for(int e = 0; e < 2; e++)
				     		{
				     			for(int f = 0; f < 2; f++)
					     		{
					     			for(int g = 0; g < 2; g++)
						     		{
						     			for(int h = 0; h < 2; h++)
							     		{
							     			for(int i = 0; i < 2; i++)
								     		{
								     			for(int j = 0; j < 2; j++)
									     		{
									     			for(int k = 0; k < 2; k++)
										     		{
										     			for(int l = 0; l < 2; l++)
											     		{
											     			for(int m = 0; m < 2; m++)
												     		{
												     			for(int n = 0; n < 2; n++)
													     		{
													     			for(int o = 0; o < 2; o++)
														     		{
														     			for(int p = 0; p < 2; p++)
															     		{
															     			for(int q = 0; q < 2; q++)
																     		{
																     			for(int r = 0; r < 2; r++)
																	     		{
																	     			for(int s = 0; s < 2; s++)
																		     		{
																		     			for(int t = 0; t < 2; t++)
																			     		{
																			     			cupCount = 0;
																			     			total = 0;
																			     			if(a == 1)
																			     			{
																			     				total+=containers.get(0);
																			     			}
																			     			if(b == 1)
																			     			{
																			     				total+=containers.get(1);
																			     			}
																			     			if(c == 1)
																			     			{
																			     				total+=containers.get(2);
																			     			}
																			     			if(d == 1)
																			     			{
																			     				total+=containers.get(3);
																			     			}
																			     			if(e == 1)
																			     			{
																			     				total+=containers.get(4);
																			     			}
																			     			if(f == 1)
																			     			{
																			     				total+=containers.get(5);
																			     			}
																			     			if(g == 1)
																			     			{
																			     				total+=containers.get(6);
																			     			}
																			     			if(h == 1)
																			     			{
																			     				total+=containers.get(7);
																			     			}
																			     			if(i == 1)
																			     			{
																			     				total+=containers.get(8);
																			     			}
																			     			if(j == 1)
																			     			{
																			     				total+=containers.get(9);
																			     			}
																			     			if(k == 1)
																			     			{
																			     				total+=containers.get(10);
																			     			}
																			     			if(l == 1)
																			     			{
																			     				total+=containers.get(11);
																			     			}
																			     			if(m == 1)
																			     			{
																			     				total+=containers.get(12);
																			     			}
																			     			if(n == 1)
																			     			{
																			     				total+=containers.get(13);
																			     			}
																			     			if(o == 1)
																			     			{
																			     				total+=containers.get(14);
																			     			}
																			     			if(p == 1)
																			     			{
																			     				total+=containers.get(15);
																			     			}
																			     			if(q == 1)
																			     			{
																			     				total+=containers.get(16);
																			     			}
																			     			if(r == 1)
																			     			{
																			     				total+=containers.get(17);
																			     			}
																			     			if(s == 1)
																			     			{
																			     				total+=containers.get(18);
																			     			}
																			     			
																			     			if(t == 1)
																			     			{
																			     				total+=containers.get(19);
																			     			}
																			     			if(total == 150)
																			     			{
																			     				answer++;
																			     				cupCount = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t;
																			     			}
																			     			if(cupCount != 0 && cupCount < lowestCup)
																			     			{
																			     				lowestCup = cupCount;
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
     		for(int a = 0; a < 2; a++)
     		{
     			for(int b = 0; b < 2; b++)
	     		{
	     			for(int c = 0; c < 2; c++)
		     		{
		     			for(int d = 0; d < 2; d++)
			     		{
			     			for(int e = 0; e < 2; e++)
				     		{
				     			for(int f = 0; f < 2; f++)
					     		{
					     			for(int g = 0; g < 2; g++)
						     		{
						     			for(int h = 0; h < 2; h++)
							     		{
							     			for(int i = 0; i < 2; i++)
								     		{
								     			for(int j = 0; j < 2; j++)
									     		{
									     			for(int k = 0; k < 2; k++)
										     		{
										     			for(int l = 0; l < 2; l++)
											     		{
											     			for(int m = 0; m < 2; m++)
												     		{
												     			for(int n = 0; n < 2; n++)
													     		{
													     			for(int o = 0; o < 2; o++)
														     		{
														     			for(int p = 0; p < 2; p++)
															     		{
															     			for(int q = 0; q < 2; q++)
																     		{
																     			for(int r = 0; r < 2; r++)
																	     		{
																	     			for(int s = 0; s < 2; s++)
																		     		{
																		     			for(int t = 0; t < 2; t++)
																			     		{
																			     			total = 0;
																			     			if(a == 1)
																			     			{
																			     				total+=containers.get(0);
																			     			}
																			     			if(b == 1)
																			     			{
																			     				total+=containers.get(1);
																			     			}
																			     			if(c == 1)
																			     			{
																			     				total+=containers.get(2);
																			     			}
																			     			if(d == 1)
																			     			{
																			     				total+=containers.get(3);
																			     			}
																			     			if(e == 1)
																			     			{
																			     				total+=containers.get(4);
																			     			}
																			     			if(f == 1)
																			     			{
																			     				total+=containers.get(5);
																			     			}
																			     			if(g == 1)
																			     			{
																			     				total+=containers.get(6);
																			     			}
																			     			if(h == 1)
																			     			{
																			     				total+=containers.get(7);
																			     			}
																			     			if(i == 1)
																			     			{
																			     				total+=containers.get(8);
																			     			}
																			     			if(j == 1)
																			     			{
																			     				total+=containers.get(9);
																			     			}
																			     			if(k == 1)
																			     			{
																			     				total+=containers.get(10);
																			     			}
																			     			if(l == 1)
																			     			{
																			     				total+=containers.get(11);
																			     			}
																			     			if(m == 1)
																			     			{
																			     				total+=containers.get(12);
																			     			}
																			     			if(n == 1)
																			     			{
																			     				total+=containers.get(13);
																			     			}
																			     			if(o == 1)
																			     			{
																			     				total+=containers.get(14);
																			     			}
																			     			if(p == 1)
																			     			{
																			     				total+=containers.get(15);
																			     			}
																			     			if(q == 1)
																			     			{
																			     				total+=containers.get(16);
																			     			}
																			     			if(r == 1)
																			     			{
																			     				total+=containers.get(17);
																			     			}
																			     			if(s == 1)
																			     			{
																			     				total+=containers.get(18);
																			     			}
																			     			if(t == 1)
																			     			{
																			     				total+=containers.get(19);
																			     			}
																			     			cupCount = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t;
																			     			if(total == 150 && cupCount == lowestCup)
																			     			{
																			     				count++;
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
 			out.println(answer);
			out.println(count);
			bab.close();
    	}
}