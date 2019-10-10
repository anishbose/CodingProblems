import java.io.*;
import java.util.*;

public class SortingHat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Person> q = new PriorityQueue<Person>();
        for(int i = 0; i < people; i++) {
            String[] info = sc.nextLine().split(" ");
            Person p = new Person(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
            q.add(p);
        }
        while(!q.isEmpty()) {
            Person p = q.poll();
            
            System.out.println(p.first + " " + p.last);
        }
    }
}

class Person implements Comparable<Person> {
    String first;
    String last;
    int siblings;
    int month;
    int day;
    
    public Person(String f, String l, int s, int m, int d) {
        this.first = f;
        this.last = l;
        this.siblings = s;
        this.month = m;
        this.day = d;
    }

    @Override
    public int compareTo(Person other) {
        char oF = other.first.charAt(0);
        int oS = other.siblings;
        int oM = other.month;
        int oD = other.day;
        
        if(vowel(oF) && !vowel(first.charAt(0))) {
            return -1;
        } else if (!vowel(oF) && vowel(first.charAt(0))) {
            return 1;
        } else {
            if (oS < siblings) {
                return 1;
            } else if (oS > siblings) {
                return -1;
            } else {
                if((oM < 6 || oM > 8) && (month >= 6 && month <= 8)) {
                    return 1;
                } else if ((oM >= 6 && oM <= 8) && (month < 6 || month > 8)) {
                    return -1;
                } else {
                    if (oD > day) {
                        return 1;
                    } else if (oD < day) {
                        return -1;
                    } else {
                        return this.last.compareTo(other.last);
                    }
                }
            }
        }
    }
    
    public boolean vowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}