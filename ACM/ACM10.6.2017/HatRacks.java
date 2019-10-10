import java.io.*;
import java.util.*;

public class HatRacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String[] wall = sc.nextLine().split("");
        int racks = 0;
        boolean possible = true;
        for(int i = 0; i < wall.length; i++) {
            if(wall[i].equals("E")) {
                if(!safe(wall, i)) {
                    int place = getSpot(wall, i);
                    if(place == -1) {
                        System.out.println("-1");
                        possible = false;
                        break;
                    } else {
                        wall[place] = "H";
                        racks++;
                    }
                }
            }
        }
        if(possible) {
            System.out.println(racks);
        }
    }
    
    public static boolean safe(String[] wall, int i) {
        if(i - 2 >= 0 && wall[i-2].equals("H")) return true;
        if(i - 1 >= 0 && wall[i-1].equals("H")) return true;
        if(i + 2 < wall.length && wall[i+2].equals("H")) return true;
        if(i + 1 < wall.length && wall[i+1].equals("H")) return true;
        return false;
    }
    
    public static int getSpot(String[] wall, int i) {
        if(i + 2 < wall.length && wall[i+2].equals(".")) return i + 2;
        if(i + 1 < wall.length && wall[i+1].equals(".")) return i + 1;
        if(i - 1 >= 0 && wall[i-1].equals(".")) return i - 1;
        if(i - 2 >= 0 && wall[i-2].equals(".")) return i - 2;
        return -1;
    }
}