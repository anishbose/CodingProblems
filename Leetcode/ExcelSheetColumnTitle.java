package Leetcode;
import java.util.*;
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        StringBuffer output = new StringBuffer();
        while(n != 0) {
            int mod = n % 26;
            char letter = mod != 0 ? (char)(mod + 64): 'Z';
            output.append(letter);
            n = letter == 'Z' ? (n - 1) / 26: n / 26;
        }
        return output.reverse().toString();
        
    }
}
