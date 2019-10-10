
import java.util.*;
import java.io.*;
public class AoCProblem3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("problem3.txt"));
		int count = 0;
		
		/*while(sc.hasNextLine()) {
			String[] split  = sc.nextLine().trim().split("\\s+");
			int[] triangle = {Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
			Arrays.sort(triangle);
			if(triangle[0] + triangle[1] > triangle[2]) count++;
		}*/

		ArrayList<int[]> array = new ArrayList<int[]>();
		while(sc.hasNextLine()) {
			String[] split  = sc.nextLine().trim().split("\\s+");
			int[] triangle = {Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
			array.add(triangle);
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < array.size(); j += 3) {
				int[] triangle = {array.get(j)[i], array.get(j + 1)[i], array.get(j + 2)[i]};
				Arrays.sort(triangle);
				if(triangle[0] + triangle[1] > triangle[2]) count++;
			}
		}
		


		System.out.println(count);
	}
}
