package Kattis;
import java.util.*;
//import java.io.*;
public class CarefulAscent {
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        String[] s = sc.nextLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int numshields = Integer.parseInt(sc.nextLine());
        
        ArrayList<Shield> shields = new ArrayList<Shield>();
        
        for(int i = 0; i < numshields; i++) {
            String[] info = sc.nextLine().split(" ");
            int low = Integer.parseInt(info[0]);
            int high = Integer.parseInt(info[1]);
            if(high > y) {
                high = y;
            }
            double speed = Double.parseDouble(info[2]);
            Shield sh = new Shield(high - low, speed);
            shields.add(sh);
        }
        sc.close();
        int height = 0;
        double mult = 0;
        for(Shield ch : shields) {
            height += ch.size;
            mult += ch.size * ch.speed;
        }
        mult += (y - height);
        double answer = x / mult;
        
        System.out.println(answer);

    }

}

class Shield {
    int size;
    double speed;
    public Shield(int size, double speed) {
        this.size = size;
        this.speed =speed;
        
    }
    
}