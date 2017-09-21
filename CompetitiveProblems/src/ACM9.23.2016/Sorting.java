import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Sorting {

	static TreeSet<String> names = new TreeSet<String>();
	public static void main(String[] args) {
		Scanner bab = new Scanner(System.in);
		
		int times = Integer.parseInt(bab.nextLine());
		
		while(times > 0) {
			
			int numNames = Integer.parseInt(bab.nextLine());
			
			ArrayList<String> nam = new ArrayList<String>();
			for(int i = 0; i < numNames; i++) {
				String[] s = bab.nextLine().split(" ");
				String n = s[1] + s[0];
				n.toLowerCase();
				names.add(n);
				nam.add(n);
			}
			int count = 0;
			
			while(!sort(nam)) {
				
			}
			
			
			
			
			
			
			
			
			times--;
		}

	}
	
	public static int recurse() {
		return 0;
	}
	
	public static boolean sort(ArrayList<String> nam) {
		TreeSet<String> n = new TreeSet(nam);
		if(n.equals(names)) {
			return true;
		} return false;
	}

}
