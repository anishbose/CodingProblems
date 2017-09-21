import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Scaterplots {

	public static void main(String[] args) {
		Scanner bab = new Scanner(System.in);
		
		int num = Integer.parseInt(bab.nextLine());
		
		String s1 = "SCOTT";
		String s2 = "JARED";
		
		for(int i = 0; i < num;  i++) {
			if(Math.random() > .5) {
				out.println(s1);
			} else out.println(s2);
		}

	}

}
