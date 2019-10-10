import java.util.*;
public class Shirts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = Integer.parseInt(sc.nextLine());
        while(times-- > 0) {
            String s = sc.nextLine().trim();
            String answer = s.substring(10);
            answer = answer.substring(0, s.length() - 40);
            System.out.println(answer);
        }
    }
}
