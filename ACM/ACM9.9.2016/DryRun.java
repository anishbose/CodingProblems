import java.io.*;
import static java.lang.System.*;
import java.util.*;

public class DryRun {

	public static void main(String[] args) throws IOException{
		Scanner bab = new Scanner(System.in);
		int times = Integer.parseInt(bab.nextLine());
		
		while(bab.hasNextLine()) {
			out.println("I like " + bab.nextLine() + ".");
		}

	}

}
