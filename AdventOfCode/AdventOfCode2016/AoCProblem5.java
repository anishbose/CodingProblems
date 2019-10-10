
import java.util.*;
import java.io.*;
import java.security.*;
public class AoCProblem5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String startCode = "cxdnnyjw";
		//String password = "";
		char[] password = {'0', '0', '0', '0', '0', '0', '0', '0'};
		int replaced = 0;
		boolean foundCode = false;
		int count = 0;
		MessageDigest md = MessageDigest.getInstance("MD5");
		while(count < Integer.MAX_VALUE)
		{
			String code = startCode + Integer.toString(count);
			byte[] bytes = md.digest(code.getBytes());
			String md5 = "";
			for (byte b : bytes)
			{
				int i = b & 0xff;
				String s = Integer.toHexString(i);
				if(s.length() == 1) s = "0" + s;
				md5 += (s);
			}
			/*if(md5.substring(0, 5).equals("00000"))
			{
				System.out.println(md5);
				password += md5.substring(5, 6);
				if(password.length() == 8) break;
			}*/
			if(md5.substring(0, 5).equals("00000"))
			{
				System.out.println(md5);
				char sixth = md5.charAt(5);
				char seventh = md5.charAt(6);
				if(sixth >= 48 && sixth <= 55) {
					if(password[sixth - 48] == '0') {
						password[sixth - 48] = seventh;
						replaced++;
					}
				}
				if(replaced == 8) break;
			}
			count++;
		}
		System.out.println(Arrays.toString(password));
		//System.out.println(password);
	}
}
