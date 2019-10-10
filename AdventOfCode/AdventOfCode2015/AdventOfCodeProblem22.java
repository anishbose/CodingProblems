/**
 * @(#)AdventOfCodeProblem22.java
 *
 *
 * @author 
 * @version 1.00 2015/12/22
 */

import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem22 {
	
        //Mana spent for each simulation victory
        static ArrayList<Integer> manaAfterWin = new ArrayList<Integer>();
        //Moves by player for each simulation victory
        static ArrayList<String> listOfMoves = new ArrayList<String>();
        //Stat Info:	  0-myHealth, 1-myArmor, 2-myMana	  3-oppHealth, 4-oppDamage	  5-shieldDuration, 6-poisonDuration, 7-rechargeDuration	  8-manaSpent
        static int[] originalStats = {50, 0, 500, 71, 10, 0, 0, 0, 0};
        static int lowestMana = Integer.MAX_VALUE;
        
    	public static void main(String[] args){
			//List of moves
     		ArrayList<String> moves = new ArrayList<String>();
     		moves.add("Missile");
     		moves.add("Drain");
     		moves.add("Shield");
     		moves.add("Poison");
     		moves.add("Recharge");
     		//Recursive method call
			solve(moves, originalStats, 0, listOfMoves);
			solve(moves, originalStats, 1, listOfMoves);
			solve(moves, originalStats, 2, listOfMoves);
			solve(moves, originalStats, 3, listOfMoves);
			solve(moves, originalStats, 4, listOfMoves);
			//Final output
			Collections.sort(manaAfterWin);
			out.println("Lowest mana to win: " + manaAfterWin.get(0));
    	}
    	
    	public static void solve(ArrayList<String> moves, int[] battleStats, int nextMove, ArrayList<String> listOfMoves)
    	{
    		//New ArrayList created in order to keep information from mixing up
    		ArrayList<String> listMoves = new ArrayList<String>(listOfMoves);
    		listMoves.add(moves.get(nextMove));
    		
    		//New array created in order to keep information from mixing up
    		int[] battle = Arrays.copyOf(battleStats, battleStats.length);
    		
    		//Simulates next player and computer round
    		battle = simulate(moves.get(nextMove), battle);
    		
    		//If player loses
    		if(battle[0] < 1 || battle[2] < 1)
    		{
    		}
    		//If computer loses
    		else if(battle[3] < 1)
    		{
				manaAfterWin.add(battle[8]);
				if(lowestMana > battle[8])
				{
					lowestMana = battle[8];
					out.println(Arrays.toString(battle));
					out.println(listMoves.toString());
					out.println(battle[8]);
				}
    		}
    		//If game still in progress
    		else{
				//Recursive method call
				solve(moves, battle, 0, listMoves);
				solve(moves,battle, 1, listMoves);
				if(battle[5] < 2)
				{
					solve(moves, battle, 2, listMoves);
				}
				if(battle[6] < 2)
				{
					solve(moves, battle, 3, listMoves);
				}
				if(battle[7] < 2)
				{
					solve(moves, battle, 4, listMoves);
				}
    		}
    	}
    	//Stat Info:	  0-myHealth, 1-myArmor, 2-myMana	  3-oppHealth, 4-oppDamage	  5-shieldDuration, 6-poisonDuration, 7-rechargeDuration	  8-manaSpent
    	public static int[] simulate(String move, int[] battleStats)
    	{
    		//Extra code for part 2
    		//battleStats[0]--;
    		
    		//DURATION EFFECTS
    		if(battleStats[5] > 0)
    		{
    			battleStats[1] = 7;
    			battleStats[5]--;
    		}
    		else
    		{ 
    			battleStats[1] = 0;
    		}
    		if(battleStats[6] > 0)
    		{
    			battleStats[3]-=3;
    			battleStats[6]--;
    		}
    		if(battleStats[7] > 0)
    		{
    			battleStats[2]+=101;
    			battleStats[7]--;
    		}
    		//Checks if player or computer dies during effects
    		if(battleStats[3] < 1 || battleStats[0] < 1)
    		{
    			return battleStats;
    		}
    		
    		//PLAYER TURN
    		if(move.equals("Missile"))
    		{
    			battleStats[2]-=53;
    			if(battleStats[2] < 1)
    			{
    				return battleStats;
    			}
    			else
    			{
    				battleStats[3]-=4;
    				battleStats[8] += 53;
    			}
    		}
    		else if(move.equals("Drain"))
    		{
    			battleStats[2]-=73;
    			if(battleStats[2] < 1)
    			{
    				return battleStats;
    			}
    			else
    			{
    				battleStats[0]+=2;
    				battleStats[3]-=2;
    				battleStats[8] += 73;
    			}
    		}
    		else if(move.equals("Shield"))
    		{
    			battleStats[2]-=113;
    			if(battleStats[2] < 1)
    			{
    				return battleStats;
    			}
    			else
    			{
    				battleStats[5] = 6;
    				battleStats[8] += 113;
    			}
    		}
    		else if(move.equals("Poison"))
    		{
    			battleStats[2]-=173;
    			if(battleStats[2] < 1)
    			{
    				return battleStats;
    			}
    			else
    			{
    				battleStats[6] = 6;
    				battleStats[8] += 173;
    			}
    		}
    		else if(move.equals("Recharge"))
    		{
    			battleStats[2]-=229;
    			if(battleStats[2] < 1)
    			{
    				return battleStats;
    			}
    			else
    			{
    				battleStats[7] = 5;
    				battleStats[8] += 229;
    			}
    		}
    		//Checks if computer dies during player turn
    		if(battleStats[3] < 1)
    		{
    			return battleStats;
    		}
    		
    		//DURATION EFFECTS
    		if(battleStats[5] > 0)
    		{
    			battleStats[1] = 7;
    			battleStats[5]--;
    		}
    		else
    		{ 
    			battleStats[1] = 0;
    		}
    		if(battleStats[6] > 0)
    		{
    			battleStats[3]-=3;
    			battleStats[6]--;
    		}
    		if(battleStats[7] > 0)
    		{
    			battleStats[2]+=101;
    			battleStats[7]--;
    		}
    		//Checks if player or computer dies during effects
    		if(battleStats[3] < 1 || battleStats[0] < 1)
    		{
    			return battleStats;
    		}
    		
    		//BOSS TURN
    		int damage = battleStats[4] - battleStats[1];
    		if(damage < 1)
    		{
    			damage = 1;
    		}
    		battleStats[0]-=damage;
    		return battleStats;
    	}
}