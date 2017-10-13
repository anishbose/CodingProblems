package Leetcode;
import java.util.*;
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') continue;
                islands++;
                visitIsland(grid, i, j);
            }
        }
        return islands;
    }
    
    public void visitIsland(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        grid[row][col] = '0';
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            visitIsland(grid, row + dx[i], col + dy[i]);
        }
    }
}
