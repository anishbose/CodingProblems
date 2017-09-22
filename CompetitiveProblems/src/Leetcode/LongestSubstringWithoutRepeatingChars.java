package Leetcode;
import java.util.*;
public class LongestSubstringWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        HashSet<Character> letters = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int max = 1;
        int cur = 0;
        char same = '0';
        while(right < s.length()) {
            while(right < s.length() && !letters.contains(s.charAt(right))) {
                letters.add(s.charAt(right));
                right++;
                cur++;
            }
            if(cur > max) {
                max = cur;
            }
            if(right == s.length()) {
                break;            
            } else {
                same = s.charAt(right);
            }
            while(s.charAt(left) != same) {
                letters.remove(s.charAt(left));
                left++;
                cur--;
            }
            letters.remove(same);
            left++;
            cur--;
        }
        return max;
    }
}
