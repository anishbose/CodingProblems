import java.io.*;
import java.util.*;

public class CowEscape {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.nextLine();
		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;
		char[][] grid = new char[rows][cols];
		for(int i = 0; i < rows; i++) {
			char[] row = sc.nextLine().toCharArray();
			for(int j = 0; j < row.length; j++) {
				if(row[j] == 'C') {
					startRow = i;
					startCol = j;
				} else if (row[j] == 'E') {
					endRow = i;
					endCol = j;
				}
			}
			grid[i] = row;
		}
		
		int energy = sc.nextInt();
		sc.nextLine();
		int up = sc.nextInt();
		int down = sc.nextInt();
		int left = sc.nextInt();
		int right = sc.nextInt();
		int curRow = startRow;
		int curCol = startCol;
		boolean found = false;
		int u = 0;
		int d = 0;
		int r = 0;
		int l = 0;
		while(true) {
			// 1 UP, 2 DOWN, 3 RIGHT, 4 LEFT
			int dir = movDir(grid, curRow, curCol);
			if(dir == -1) {
				break;
			} else {
				grid[curRow][curCol] = '#';
				if(dir == 1) {
					u+=1;
					curRow--;
				} else if (dir == 2) {
					d+=1;
					curRow++;
				} else if (dir == 3) {
					r+=1;
					curCol++;
				} else {
					l+=1;
					curCol--;
				}
				if(curRow == endRow && curCol == endCol) {
					found = true;
					break;
				} 
			}
		}
		int spentE = u*up + d*down + r*right + l*left;
		if(!found) {
			System.out.println("-1");
		} else {
			if(energy - spentE < 0) {
				System.out.println("-1");
			} else {
				System.out.println(energy - spentE);
			}
		}
		
    }
    
    public static int movDir(char[][] grid, int row, int col) {
		if((row-1) > -1             && (grid[row - 1][col] == '.' || grid[row - 1][col] == 'E')) return 1;
		if((row+1) < grid.length	&& (grid[row + 1][col] == '.' || grid[row + 1][col] == 'E')) return 2;
		if((col+1) < grid[0].length	&& (grid[row][col + 1] == '.' || grid[row][col + 1] == 'E')) return 3;
		if((col-1) > -1			   	&& (grid[row][col - 1] == '.' || grid[row][col - 1] == 'E')) return 4;
		return -1;
	}

}