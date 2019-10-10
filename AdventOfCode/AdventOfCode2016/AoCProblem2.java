
import java.util.*;
import java.io.*;
public class AoCProblem2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("problem2.txt"));
		String output = "";

		//int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		char[][] grid = {	{' ', ' ', '1', ' ', ' '}, 
							{' ', '2', '3', '4', ' '},
							{'5', '6', '7', '8', '9'},
							{' ', 'A', 'B', 'C',' '},
							{' ', ' ', 'D', ' ', ' '},
						};
		int row = 2;
		int col = 0;
		while(sc.hasNextLine()) {
			char[] moves = sc.nextLine().toCharArray();
			/*for(char c : moves) {
				if(c == 'U') {
					row = Math.max(row - 1, 0);
				} else if(c == 'D') {
					row = Math.min(row + 1, 2);
				} else if(c == 'L') {
					col = Math.max(col - 1, 0);
				} else {
					col = Math.min(col + 1, 2);
				}
				//System.out.println(row + " " + col);
			}*/

			for(char c : moves) {
				if(c == 'U') {
					try {
						row = grid[row - 1][col] == ' ' ? row : row - 1;
					} catch (Exception e) {}
				} else if(c == 'D') {
					try {
						row = grid[row + 1][col] == ' ' ? row : row + 1;
					} catch (Exception e) {}
				} else if(c == 'L') {
					try {
						col = grid[row][col - 1] == ' ' ? col : col - 1;
					} catch (Exception e) {}
				} else {
					try {
						col = grid[row][col + 1] == ' ' ? col : col + 1;
					} catch (Exception e) {}
				}
				//System.out.println(row + " " + col);
			}

			output += grid[row][col];
		}
		System.out.println(output);
		
	}
}
