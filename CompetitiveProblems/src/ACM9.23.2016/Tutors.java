import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Tutors {

	public static void main(String[] args) {
		Scanner bab = new Scanner(System.in);
		
		int c = Integer.parseInt(bab.nextLine());
		
		while(c > 0) {
			
			String[] info = bab.nextLine().split(" ");
			int numTut = Integer.parseInt(info[0]);
			int numTimes = Integer.parseInt(info[1]);
			ArrayList<Integer> timeRange = new ArrayList<Integer>();
			ArrayList<int[]> ranges = new ArrayList<int[]>();
			for(int i = 0; i < numTut; i++) {
				String[] time = bab.nextLine().split(" ");
				timeRange.add(Integer.parseInt(time[0]));
				timeRange.add(Integer.parseInt(time[1]));
				int[] rang = new int[2];
				rang[0] = Integer.parseInt(time[0]);
				rang[1] = Integer.parseInt(time[1]);
				ranges.add(rang);
			}
			Collections.sort(timeRange);
			
			int max = timeRange.get(timeRange.size() - 1);
			
			int[] times = new int[max];
			for(int i = 0; i < ranges.size(); i++) {
				for(int j = ranges.get(i)[0]; j < ranges.get(i)[1]; j++) {
					out.println("adding time " + times[j]);
					times[j]++;
				}
			}
			out.println(Arrays.toString(times));
			for(int i = 0; i < numTimes; i++) {
				double d = Double.parseDouble(bab.nextLine());
				int pos = (int)Math.floor(d);
				out.println(times[pos]);
			}
			
			
			c--;
		}
		

	}

}
