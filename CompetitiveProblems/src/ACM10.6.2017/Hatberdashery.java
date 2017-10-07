import java.io.*;
import java.util.*;

public class Hatberdashery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.replaceAll("berdashery", " store");
        System.out.println(line);
    }
}