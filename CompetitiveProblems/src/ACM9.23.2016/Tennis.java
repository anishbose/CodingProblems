import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Tennis {

	public static void main(String[] args) {
		Scanner bab = new Scanner(System.in);
		
		int cases = Integer.parseInt(bab.nextLine());
		while(cases > 0) {
			String[] info = bab.nextLine().split(" ");
			int rounds = Integer.parseInt(info[0]);
			String p0 = info[1];
			String p1 = info[2];
			int[] scores = {0, 15, 30, 40};
			int[] d = {0, 0};
			int[] score = new int[2];
			boolean deuce = false;
			for(int i = 0; i < rounds; i++) {
				String result = bab.nextLine();
				if(!deuce) {
					if(result.equals(p0)) {
						score[0]++;
					} else {
						score[1]++;
					}
				}
				else {
					if(result.equals(p0)) {
						d[0]++;
					} else d[1]++;
				}
				
				if(!deuce && score[0] == 3 && score[1] == 3) {
					deuce = true;
					out.println("deuce");
				} else if(score[0] == 4) {
					out.println(p0 + " won!");
					deuce = false;
					d[0] = 0;
					d[1] = 0;
					score[0] = 0;
					score[1] = 0;
				} else if(score[1] == 4) {
					out.println(p1 + " won!");
					deuce = false;
					d[0] = 0;
					d[1] = 1;
					score[0] = 0;
					score[0] = 0;
				} else if(deuce) {
					if(d[0] - 2 == d[1]) {
						out.println(p0 + " won!");
						deuce = false;
						d[0] = 0;
						d[1] = 0;
						score[0] = 0;
						score[1] = 0;
					} else if (d[1] - 2 == d[0]) {
						out.println(p1 + " won!");
						deuce = false;
						d[0] = 0;
						d[1] = 0;
						score[0] = 0;
						score[1] = 0;
					} else if(d[0] > d[1]) {
						out.println("advantage " + p0);
					} else if(d[0] == d[1]) {
						out.println("deuce");
					}
					else out.println("advantage " + p1);
				} else {
					if(scores[score[0]] == scores[score[1]] && scores[score[0]] != 0) {
						out.println(scores[score[0]] + " all"); 
					} else if (scores[score[0]] == scores[score[1]] && scores[score[0]] == 0) {
						out.println("love all");
					} else {
						if(scores[score[0]] == 0) {
							out.print("love ");
						} else if (scores[score[0]] != 0) {
							out.print(scores[score[0]] + " ");
						}
						if(scores[score[1]] == 0) {
							out.println("love");
						} else if (scores[score[1]] != 0) {
							out.println(scores[score[1]]);
						}
					}
				}
				
				
				
			}
			
			
			
			cases--;
		}

	}

}
