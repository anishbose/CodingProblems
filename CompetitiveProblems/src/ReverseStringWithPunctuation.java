import java.util.*;
public class ReverseStringWithPunctuation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		int beg = 0;
		int end = 0;
		String nonAlphaNum = "[^a-zA-Z0-9]";
		
		String[] sentence = line.split(nonAlphaNum);
		
		for(int i = 0; i < sentence.length; i++) {
			sentence[i] = reverse(sentence[i].toCharArray());
		}
		
		String reversed = "";
		
		for(int i = 0; i < sentence.length; i++) {
			reversed += sentence[i];
		}
		
		

	}
	
	public static String reverse(char[] s) {
		for(int i = 0; i < s.length / 2; i++) {
			char swap = s[i];
			s[i] = s[s.length-1-i];
			s[s.length-1-i] = swap;
		}
		
		String rev = "";
		for(int i = 0; i < s.length; i++) {
			rev += s[i];
		}
		
		return rev;
	}

}
