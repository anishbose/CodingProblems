import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class WingsandRedBull {
	static ArrayList<Integer> moves = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{

		Scanner bab = new Scanner(System.in);
		
		int times = Integer.parseInt(bab.nextLine());
		while(times > 0) {
			String[] fo = bab.nextLine().split(" ");
			int[] info = new int[fo.length];
			for(int i = 0; i < fo.length; i++) {
				info[i] = Integer.parseInt(fo[i]);
			}
			
			int target = info[0];
			int hot = info[1];
			int num = info[2];
			
			ArrayList<Integer> wings = new ArrayList<Integer>();
			for(int i = 0; i < num; i++) {
				wings.add(Integer.parseInt(bab.nextLine()));
			}
			int turns = 0;
			int total = 0;
			//out.println("recursing");
			recurse(target, total, hot, wings, turns);
			Collections.sort(moves);
			out.println(moves.get(0));
			times--;
		}

	}
	
	public static void recurse(int target, int total, int hot, ArrayList<Integer> wings, int turns) {
		if(moves.size() < 10000) {
			if(turns > 20) {
				
			}
			
			else {
				if(total == target) {
					int i = turns;
					//out.println("adding " + i);
					moves.add(i);
				} 
				else {
					turns++;
					for(int i = 0; i < wings.size(); i++) {
						int counter = 0;
						while(total+wings.get(i) - (counter * hot) > 0) {
							int numb = total+wings.get(i) - (counter * hot);
							if(numb < 0) {
								numb = 0;
							}
							recurse(target, numb, hot, wings, turns);
							counter++;
						}
						
					}
					
					
				}
			}
		}
		
		
	}

}
