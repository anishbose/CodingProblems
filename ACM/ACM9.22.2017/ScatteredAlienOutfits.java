import java.io.*;
import java.util.*;
public class ScatteredAlienOutfits {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    HashSet<String> set = new HashSet<>();
	    int count = 0;
	    
	    for(int i = 0; i < n; i++){
	        scan.next();
	        String s = scan.next();
	        if(set.contains(s)){
	            count++;
	        }
	        else{
	            set.add(s);
	        }
	    }
	    System.out.println(count);
}

}
