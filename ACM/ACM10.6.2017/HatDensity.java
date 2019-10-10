import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HatDensity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        in.close();
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i = 0; i <= n - k; i++) {
            for(int j = 0; j <= n - k; j++) {
                double avgThick = calcThickness(a, k, i, j);
                max = Math.max(max, avgThick);
                min = Math.min(min, avgThick);
            }
        }
        System.out.println(max - min);
    }
    
    public static double calcThickness(int[][] grid, int k, int r, int c) {
        double thickness = 0;
        for(int i = r; i < r + k; i++) {
            for(int j = c; j < c + k; j++) {
                thickness += grid[i][j];
            }
        }
        thickness /= (k * k);
        return thickness;
    }
}