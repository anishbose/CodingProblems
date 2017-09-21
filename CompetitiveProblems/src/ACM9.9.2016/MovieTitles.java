import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class MovieTitles {

	public static void main(String[] args) throws IOException{

		Scanner bab = new Scanner(System.in);
		
		int times = Integer.parseInt(bab.nextLine());
		while(times > 0) {
			String[] s = bab.nextLine().split(" ");
			if(s.length == 1) {
				out.println(s[0] + " Returns");
			} else {
				for(int i = 0; i < s.length; i++) {
					if(i != s.length - 1) {
						out.print(s[i] + " ");
					} else out.print(s[i]);
					
				}
				out.println(": Age of Darkness");
			}
			times--;
		}

	}

}