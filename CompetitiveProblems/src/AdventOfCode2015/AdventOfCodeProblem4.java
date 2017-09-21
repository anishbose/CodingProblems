/**
 * @(#)AdventOfCodeProblem4.java
 *
 *
 * @author 
 * @version 1.00 2015/12/5
 */

import java.util.*;
import java.security.*;
import static java.lang.System.*;

public class AdventOfCodeProblem4 {
        
    	public static void main(String[] args) throws NoSuchAlgorithmException
    	{
			String startCode = "bgvyzdsv";
			
			boolean foundCode = false;
			int count = 0;
			while(count < 10000000)
			{
				String code = startCode;
				code += Integer.toString(count);
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] bytes = md.digest(code.getBytes());
				String md5 = "";
				for (byte b : bytes)
				{
					int i = b & 0xff;
					String s = Integer.toHexString(i);
					if(s.length() == 1)
					{
						s = "0" + s;
					}
					md5 += (s);
				}
				if(md5.substring(0, 6).equals("000000"))
				{
					foundCode = true;
					out.println(count);
					out.println(Arrays.toString(bytes));
					out.println(md5);
				}
				count++;
			}
			if(!foundCode)
			{
				out.println("FAILED");
			}
    	}
}