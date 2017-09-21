import java.util.*;
import java.io.*;
public class UnusualProduct {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lines = Integer.parseInt(br.readLine());
		
		boolean ans = false;
		int line = 0;
		while(lines-- > 0) {
			String s = br.readLine();
			if (s.charAt(line) == '1') {
				ans = !ans;
			}
			line += 2;
		}
		int queries = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(queries-- > 0) {
			String q = br.readLine();
			if(!q.equals("3")) {
				ans = !ans;
			} else {
				 if(ans == false) {
					 sb.append("0");
				 } else {
					 sb.append("1");
				 }
			}
		}
		System.out.println(sb.toString());
	}

}
