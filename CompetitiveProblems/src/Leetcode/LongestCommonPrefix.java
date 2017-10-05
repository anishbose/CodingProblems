import java.util.*;
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String lcp = "";
        loop:
        for(int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for(int j  = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || cur != strs[j].charAt(i)) {
                    break loop;
                }
            }
            lcp += cur;
        }
        return lcp;
    }
}
