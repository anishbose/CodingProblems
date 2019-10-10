import java.io.*;
import java.util.*;

public class HatCatalog {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBuyHats = sc.nextInt();
        sc.nextLine();
        HashSet<String> buyHats = new HashSet<String>(numBuyHats);
        for(int i = 0; i < numBuyHats; i++) {
            String s = sc.nextLine();
            buyHats.add(s);
        }
        int numHats = sc.nextInt();
        int budget = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> prices = new HashMap<String, Integer>();
        PriorityQueue<Hat> q = new PriorityQueue<Hat>();
        for(int i = 0; i < numHats; i++) {
            String name = sc.nextLine();
            int price = sc.nextInt();
            if(sc.hasNextLine()) sc.nextLine();
            prices.put(name, price);
            Hat h = new Hat(name, price);
            q.add(h);
        }
        int hatsBought = 0;
        while(!q.isEmpty()) {
            Hat h = q.poll();
            String[] fullName = h.name.split(" ");
            String hName = fullName[fullName.length - 1];
            if(buyHats.contains(hName)) {
                if(budget >= prices.get(h.name)) {
                    hatsBought++;
                    budget -= prices.get(h.name);
                } else {
                    break;
                }
            }
        }
        System.out.println(hatsBought);
    }
}

class Hat implements Comparable<Hat> {
        String name;
        int price;
        public Hat(String hat, int price) {
            this.name = hat;
            this.price = price;
        }
        
        @Override
        public int compareTo(Hat other) {
            return Integer.compare(this.price, other.price);
        }
}