import java.util.*;

public class LongestSubstringNonrepeatingChars {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		if(s.length() == 0)  {
			System.out.println("0");
		}
		        
        HashSet<Character> letters = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int max = 1;
        int cur = 0;
        char same = '0';
        while(right < s.length()) {
            while(right < s.length() && !letters.contains(s.charAt(right))) {
                letters.add(s.charAt(right));
                same = s.charAt(right);
                right++;
                cur++;
            }
            if(cur > max) {
                max = cur;
            }
            if(right == s.length() - 1) break;
            while(left < right && s.charAt(left) != same) {
                letters.remove(s.charAt(left));
                left++;
                cur--;
            }
            left++;
            cur--;
            letters.remove(same);
        }
	}

}
