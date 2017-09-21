/**
 * @(#)AdventOfCodeProblem14.java
 *
 *
 * @author 
 * @version 1.00 2015/12/13
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem14 {
        // < 5042
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem14.txt"));
			ArrayList<String[]> info = new ArrayList<String[]>();
			while (bab.hasNextLine())
			{
				String[] s = bab.nextLine().split(" ");	
				String reindeer[] = new String[4];
				reindeer[0] = s[0];
				reindeer[1] = s[3];
				reindeer[2] = s[6];
				reindeer[3] = s[13];
				info.add(reindeer);
			}
			
			ArrayList<int[]> distances = new ArrayList<int[]>();
			for(int i = 0; i < info.size(); i++)
			{
				int[] distance = new int[2503];
				String[] deerInfo = info.get(i);
				int speed = Integer.parseInt(deerInfo[1]);
				int flyTime = Integer.parseInt(deerInfo[2]);
				int restTime = Integer.parseInt(deerInfo[3]);
				int pos = 0;
				int startPos = 0;
				out.println(Arrays.toString(deerInfo));
				while(pos < distance.length)
				{
					startPos = pos;
					for(int j = startPos; j < startPos + flyTime; j++)
					{
						if(pos < distance.length)
						{
							distance[j] = speed;
						}
						pos++;
					}
					pos+=restTime;
				}
				distances.add(distance);
			}
			out.println(distances.size());
			//out.println(Arrays.toString(distances.get(8)));
			ArrayList<Integer> distTravel = new ArrayList<Integer>();
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			distTravel.add(0);
			ArrayList<Integer> leadPoints = new ArrayList<Integer>();
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			leadPoints.add(0);
			for(int i = 0; i < 2503; i++)
			{
				distTravel.set(0, (distTravel.get(0) + (distances.get(0)[i])));
				distTravel.set(1, (distTravel.get(1) + (distances.get(1)[i])));
				distTravel.set(2, (distTravel.get(2) + (distances.get(2)[i])));
				distTravel.set(3, (distTravel.get(3) + (distances.get(3)[i])));
				distTravel.set(4, (distTravel.get(4) + (distances.get(4)[i])));
				distTravel.set(5, (distTravel.get(5) + (distances.get(5)[i])));
				distTravel.set(6, (distTravel.get(6) + (distances.get(6)[i])));
				distTravel.set(7, (distTravel.get(7) + (distances.get(7)[i])));
				distTravel.set(8, (distTravel.get(8) + (distances.get(8)[i])));
				int max = Integer.MIN_VALUE;
				for(int j = 0; j < distTravel.size(); j++)
				{
					if(distTravel.get(j) > max)
					{
						max = distTravel.get(j);
					}
				}
				out.println("Max distance traveled after " + i + " seconds is " + max);
				for(int j = 0; j < distTravel.size(); j++)
				{
					if(distTravel.get(j) == max)
					{
						leadPoints.set(j, (leadPoints.get(j) + 1));
					}
				}
				
			}
			int maxDist = Integer.MIN_VALUE;
			for(int i = 0; i < leadPoints.size(); i++)
			{
				if(leadPoints.get(i) > maxDist)
				{
					maxDist = leadPoints.get(i);
				}
			}
			out.println(maxDist);
			/*
			ArrayList<Integer> distances = new ArrayList<Integer>();
			int finalTime = 2503;
			int count = 0;
			int elapsedTime = 0;
			for(int i = 0; i < info.size(); i++)
			{
				String[] deer = info.get(i);
				count = 0;
				int speed = Integer.parseInt(deer[1]);
				int flyTime = Integer.parseInt(deer[2]);
				int restTime = Integer.parseInt(deer[3]);
				elapsedTime = 0;
				while(elapsedTime <= finalTime)
				{
					elapsedTime+=(flyTime + restTime);
					count+=(speed*flyTime);
				}
				elapsedTime -= (flyTime + restTime);
				if(elapsedTime != finalTime)
				{
					count-=(speed*flyTime);
					if((elapsedTime + flyTime) < finalTime)
					{
						count+=(speed*flyTime);
					}
					else
					{
						int extraTime = finalTime - elapsedTime;
						count+= extraTime*speed;
					}
				}
				//out.println(elapsedTime);
				distances.add(count);
				
			}
			Collections.sort(distances);
			out.println(distances.get(distances.size() - 1));
			*/
			bab.close();
    	}
}