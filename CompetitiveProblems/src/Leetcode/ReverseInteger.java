import java.util.*;
public class ReverseInteger {
	public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        long rev = 0;
        int orig = x;
        while(x != 0) {
            int mod = x % 10;
            rev *= 10;
            rev += mod;
            x /= 10;
        }
        if(orig < 0) rev *= 1;
        if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;
        return (int)rev;
    }
}
