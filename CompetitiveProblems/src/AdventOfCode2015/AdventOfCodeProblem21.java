/**
 * @(#)AdventOfCodeProblem21.java
 *
 *
 * @author 
 * @version 1.00 2015/12/21
 */

import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem21 {
        
    	public static void main(String[] args)
    	{
			HashMap<String, Integer> costs = new HashMap<String, Integer>();
			HashMap<String, String> stats = new HashMap<String, String>();
			ArrayList<String> weapons = new ArrayList<String>();
			ArrayList<String> armor = new ArrayList<String>();
			ArrayList<String> rings = new ArrayList<String>();
			
			weapons.add("dagger");
			weapons.add("shortsword");
			weapons.add("warhammer");
			weapons.add("longsword");
			weapons.add("greataxe");
			
			armor.add("noA");
			armor.add("leather");
			armor.add("chainmail");
			armor.add("splintmail");
			armor.add("bandedmail");
			armor.add("platemail");
			
			rings.add("noR");
			rings.add("da1");
			rings.add("da2");
			rings.add("da3");
			rings.add("de1");
			rings.add("de2");
			rings.add("de3");
			rings.add("da1 da2");
			rings.add("da1 da3");
			rings.add("da1 de1");
			rings.add("da1 de2");
			rings.add("da1 de3");
			rings.add("da2 da3");
			rings.add("da2 de1");
			rings.add("da2 de2");
			rings.add("da2 de3");
			rings.add("da3 de1");
			rings.add("da3 de2");
			rings.add("da3 de3");
			rings.add("de1 de2");
			rings.add("de1 de3");
			rings.add("de2 de3");
			
			costs.put("dagger", 8);
			costs.put("shortsword", 10);
			costs.put("warhammer", 25);
			costs.put("longsword", 40);
			costs.put("greataxe", 74);
			costs.put("noA", 0);
			costs.put("leather", 13);
			costs.put("chainmail", 31);
			costs.put("splintmail", 53);
			costs.put("bandedmail", 75);
			costs.put("platemail", 102);
			costs.put("noR", 0);
			costs.put("da1", 25);
			costs.put("da2", 50);
			costs.put("da3", 100);
			costs.put("de1", 20);
			costs.put("de2", 40);
			costs.put("de3", 80);
			
			stats.put("dagger", "4");
			stats.put("shortsword", "5");
			stats.put("warhammer", "6");
			stats.put("longsword", "7");
			stats.put("greataxe", "8");
			stats.put("noA", "0");
			stats.put("leather", "1");
			stats.put("chainmail", "2");
			stats.put("splintmail", "3");
			stats.put("bandedmail", "4");
			stats.put("platemail", "5");
			stats.put("noR", "d 0");
			stats.put("da1", "d 1");
			stats.put("da2", "d 2");
			stats.put("da3", "d 3");
			stats.put("de1", "a 1");
			stats.put("de2", "a 2");
			stats.put("de3", "a 3");
			
			int[] battleStats = new int[6];
			battleStats[0] = 104;
			battleStats[1] = 8;
			battleStats[2] = 1;
			battleStats[3] = 100;
			battleStats[4] = 0;
			battleStats[5] = 0;
			boolean simulation = false;
			int lowestGold = Integer.MAX_VALUE;
			int highestGold = Integer.MIN_VALUE;
			for(int i = 0; i < weapons.size(); i++)
			{
				for(int j = 0; j < armor.size(); j++)
				{
					for(int k = 0; k < rings.size(); k++)
					{
						String[] gear = new String[3];
						gear[0] = weapons.get(i);
						gear[1] = armor.get(j);
						gear[2] = rings.get(k);
						simulation = simulate(gear, battleStats, stats);
						if(simulation)
						{
							int cost = 0;
							cost+=costs.get(gear[0]);
							cost+=costs.get(gear[1]);
							String[] listRings = gear[2].split(" ");
							for(int a = 0; a < listRings.length; a++)
							{
								cost+=costs.get(listRings[a]);
							}
							if(cost < lowestGold)
							{
								lowestGold = cost;
							}
						}
						else
						{
							int cost = 0;
							cost+=costs.get(gear[0]);
							cost+=costs.get(gear[1]);
							String[] listRings = gear[2].split(" ");
							for(int a = 0; a < listRings.length; a++)
							{
								cost+=costs.get(listRings[a]);
							}
							if(cost > highestGold)
							{
								highestGold = cost;
							}
						}
					}
				}
			}
			out.println("Least amount of gold to win: " + lowestGold);
			out.println("Highest amount of gold to lose: " + highestGold);
    	}
    	
    	public static boolean simulate(String[] gear, int[] playerStats, HashMap<String, String> stats)
    	{
    		int oppHealth = playerStats[0];
			int oppDam = playerStats[1];
			int oppArmor = playerStats[2];
			int myHealth = playerStats[3];
			int myDam = playerStats[4];
			int myArmor = playerStats[5];
			String[] rings = gear[2].split(" ");
			for(int i = 0; i < rings.length; i++)
			{
				String s = rings[i];
				String ringInfo[] = stats.get(s).split(" ");
				if(ringInfo[0].equals("a"))
				{
					myArmor+= Integer.parseInt(ringInfo[1]);
				}
				else
				{
					myDam+= Integer.parseInt(ringInfo[1]);
				}
			}
    		myDam+=Integer.parseInt(stats.get(gear[0]));
    		myArmor+=Integer.parseInt(stats.get(gear[1]));
    		int myRoundDamage = myDam-oppArmor;
    		if(myRoundDamage < 1)
    		{
    			myRoundDamage = 1;
    		}
    		int oppRoundDamage = oppDam-myArmor;
    		if(oppRoundDamage < 1)
    		{
    			oppRoundDamage = 1;
    		}
    		
    		while(oppHealth > 0 && myHealth > 0)
    		{
    			oppHealth-=myRoundDamage;
    			if(oppHealth < 1)
    			{
    				return true;
    			}
    			myHealth-=oppRoundDamage;
    			if(myHealth < 1)
    			{
    				return false;
    			}
    		}
    		if(oppHealth < 1)
			{
				return true;
			}
			else return false;
    	}
    	
}