import java.util.*;
public class LongestPalindrome {
	public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        
        String longestPal = "";
        
        for(int i = 0; i < s.length(); i++) {
            // Instances where palindrome has distinct center
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else break;
            }
            if(right - left - 1 > longestPal.length()) longestPal = s.substring(left + 1, right);
            
            // Instances where palindrome has double center
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                } else break;
            }
            if(right - left - 1 > longestPal.length()) longestPal = s.substring(left + 1, right);
            
            if(longestPal.length() == s.length()) break;
        }
        return longestPal;
    }
}
