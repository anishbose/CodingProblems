/**
 * @(#)AdventOfCodeProblem8.java
 *
 *
 * @author 
 * @version 1.00 2015/12/8
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class AdventOfCodeProblem7 {
        
    public static void main(String[] args) throws IOException
    {
    	Scanner bab = new Scanner(new File("AdventOfCodeProblem7.txt"));
    	//*****SECOND PART OF PROBLEM ASKS TO CHANGE INPUT IN FILE. ORIGINALLY, B IS SET AS 1674. NEW IS SET TO 46065*****
    	ArrayList<String[]> signals = new ArrayList<String[]>();
    	HashMap<String, Integer> wires = new HashMap<String, Integer>();
    	//int count = 5;
    	while(bab.hasNextLine())
    	{
    		String[] input = new String[5];
    		String s[] = bab.nextLine().split(" ");
    		if(s[0].equals("NOT"))
    		{
    			input[3] = s[0];
    			input[0] = s[1];
    			input[2] = s[3];
    		}
    		else if(s.length == 3)
    		{
    			input[0] = s[0];
    			input[2] = s[2];
    			
    		}
    		else if(s[1].contains("SHIFT"))
    		{
    			input[0] = s[0];
    			input[2] = s[4];
    			input[3] = s[1];
    			input[4] = s[2];
    		}
    		else
    		{
    			input[0] = s[0];
    			input[1] = s[2];
    			input[2] = s[4];
    			input[3] = s[1];
    		}
    		signals.add(input);
    		
    		if(!wires.containsKey(input[0]) && !isNumber(input[0]))
    		{
    			wires.put(input[0], 70000);
    		}
    		if(input[1] != null && !wires.containsKey(input[1]) && !isNumber(input[1]))
    		{
    			wires.put(input[1], 70000);
    		}
    		if(!wires.containsKey(input[2]))
    		{
    			wires.put(input[2], 70000);
    		}
    	}
    	
    	int iteration = 1;
    	//int times = 5;
    	while(wires.get("a") == 70000)	//
    	{
    		out.println("Iteration " + (iteration++));
    		for(int i = 0; i < signals.size(); i++)
    		{
    			if(ready(signals, wires, i))
    			{
    				String[] arr = signals.get(i);
    				int fin = 0;
    				//ONE VARIABLE, SHIFT, or NOT
    				if(arr[1] == null)
    				{
    					//NOT
    					if(arr[3] != null && arr[3].equals("NOT"))
    					{
    						if(isNumber(arr[0]))
    						{
    							fin = ~(Integer.parseInt(arr[0]));
    						}
    						else fin = ~(wires.get(arr[0]));
    					}
    					else if(arr[3] != null)
    					{
    						//SHIFT
    						if(arr[3].charAt(0) == 'R')
    						{
    							if(isNumber(arr[0]))
    							{
    								fin = Integer.parseInt(arr[0]) >> Integer.parseInt(arr[4]);
    							}
    							else fin = wires.get(arr[0]) >> Integer.parseInt(arr[4]);
    						}
    						else
    						{
    							if(isNumber(arr[0]))
    							{
    								fin = Integer.parseInt(arr[0]) << Integer.parseInt(arr[4]);
    							}
    							else fin = wires.get(arr[0]) << Integer.parseInt(arr[4]);
    						}
    					}
    					else
    					{
    						//ONE VARIABLE
    						if(isNumber(arr[0]))
    						{
    							fin = Integer.parseInt(arr[0]);
    						}
    						else fin = wires.get(arr[0]);
    					}
    				}
    				else
    				{
    					//AND
    					if(arr[3].equals("AND"))
    					{
    						if(isNumber(arr[0]) && !isNumber(arr[1]))
    						{
    							fin = Integer.parseInt(arr[0]) & wires.get(arr[1]);
    						}
    						else if(!isNumber(arr[0]) && isNumber(arr[1]))
    						{
    							fin = wires.get(arr[0]) & Integer.parseInt(arr[1]);
    						}
    						else if(isNumber(arr[0]) && isNumber(arr[1]))
    						{
    							fin = Integer.parseInt(arr[0]) & Integer.parseInt(arr[1]);
    						}
    						else
    						{
    							 out.println(Arrays.toString(arr));
    							 fin = wires.get(arr[0]) & wires.get(arr[1]);
    						}
    						
    					}
    					else
    					{
    						//OR
    						if(isNumber(arr[0]) && !isNumber(arr[1]))
    						{
    							fin = Integer.parseInt(arr[0]) | wires.get(arr[1]);
    						}
    						else if(!isNumber(arr[0]) && isNumber(arr[1]))
    						{
    							fin = wires.get(arr[0]) | Integer.parseInt(arr[1]);
    						}
    						else if(isNumber(arr[0]) && isNumber(arr[1]))
    						{
    							fin = Integer.parseInt(arr[0]) | Integer.parseInt(arr[1]);
    						}
    						else fin = wires.get(arr[0]) | wires.get(arr[1]);
    					}
    				}
    				out.println("Setting " + arr[2] + " as " + fin);
    				wires.put(arr[2], fin);
    				signals.remove(i);
    				i--;
    			}
    		}
    	}
    	out.println(wires.get("a"));
    	bab.close();
    }
    
    
    public static boolean isNumber(String s)
    {
    	if(s.contains("-") || s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9"))
    	{
    		return true;
    	}
    		return false;
    }
    
    public static boolean ready(ArrayList<String[]> wires, HashMap<String, Integer> signals, int i)
    {
    	String[] s = wires.get(i);
    	
    	if(isNumber(s[0]) || signals.get(s[0]) != 70000)
    	{
    		if(s[1] == null)
    		{
    			return true;
    		}
    		else
    		{
    			if(isNumber(s[1]) || signals.get(s[1]) != 70000)
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    	
    }
    
}
