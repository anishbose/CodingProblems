import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArknavianAfro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int i = 0; i < numCases; i++) {
            int numNameLines = scanner.nextInt();
            int laps = scanner.nextInt();
            scanner.nextLine();
            String archduke = "";
            String vice = "";
            boolean found = false;
            HashMap<String, Integer> people = new HashMap<>();
            for (int j = 0; j < numNameLines; j++) {
                found = false;
                String name = scanner.nextLine();
                
                if (people.containsKey(name)) {
                    people.put(name, people.get(name)+1);
                } else {
                    people.put(name, 1);
                }
                
                if (people.get(name) == laps) {
                    if (archduke.equals("")) {
                        archduke = name;
                    } else if (vice.equals("")) {
                        vice = name;
                        found = true;
                    }
                }
            }
            if(!archduke.equals("") && !vice.equals("")) {
                System.out.println(archduke + "\n" + vice);
            } else {
                System.out.println("Armageddon");
            }
        }
    }
}