import java.io.*;
import java.util.*;
import java.math.*;

public class Area51 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long output = 0;
        for(long i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                output++;
            }
        }
        System.out.println(output);
    }
}