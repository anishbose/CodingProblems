
import java.util.*;
import java.io.*;
public class AoCProblem6 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("problem6.txt"));
		String password = "";
		int[][] map = new int[8][26];
		while(sc.hasNextLine()) {
			char[] chars = sc.nextLine().toCharArray();
			for(int i = 0; i < chars.length; i++) {
				map[i][chars[i] - 97]++;
			}
		}
		//int max = 0;
		//int maxPos = 0;
		int min = Integer.MAX_VALUE;
		int minPos = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 26; j++) {
				/*if(map[i][j] > max) {
					max = map[i][j];
					maxPos = j;
				}*/

				if(map[i][j] < min) {
					min = map[i][j];
					minPos = j;
				}
			}
			password += (char)(minPos + 97);
			//max = 0;
			//maxPos = 0;
			min = Integer.MAX_VALUE;
			minPos = 0;
		}
		System.out.println(password);
	}
}
