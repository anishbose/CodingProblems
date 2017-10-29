import java.util.Scanner;

public class ArksChess {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int games = in.nextInt();
        int d = 0;
        int a = 0;
        int k = 0;
        for(int a0 = 0; a0 < games; a0++){
            int black = in.nextInt();
            int white = in.nextInt();
            int total = black + white;
            if(total % 2 == 0 && total % 4 != 0) a++;
        }
        System.out.println("Draws: " + (games-a));
        System.out.println("Ark Won: " + a);
        System.out.println("Knave Won: 0");
        in.close();
    }
}
