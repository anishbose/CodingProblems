
import java.util.*;
import java.io.*;
public class AoCProblem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("problem1.txt"));
		String[] operations = sc.nextLine().split(", ");
		System.out.println(Arrays.toString(operations));
		//String sc = "R5, L5, R5, R3";
		//String[] operations = sc.split(", ");
		HashSet<String> visited = new HashSet<String>();
		int x = 0;
		int y = 0;
		// 0 is up, 1 is right, 2 is down, 3 is left
		int curDirection = 0;
		for(String s : operations) {
			System.out.println(s + " " + x + " " + y);
			boolean isLeft = s.charAt(0) == 'L';
			int dist = Integer.parseInt(s.substring(1));
			if(curDirection == 0) {
				int dx = isLeft ? -1 * dist : dist;
				addToSet(visited, x, y, dx, 0);
				x += dx;
				curDirection = isLeft ? 3 : 1;
			} else if (curDirection == 2) {
				int dx = isLeft ? dist : -1 * dist;
				addToSet(visited, x, y, dx, 0);
				x += dx;
				curDirection = isLeft ? 1 : 3;
			} else if (curDirection == 1) {
				int dy = isLeft ? dist : -1 * dist;
				addToSet(visited, x, y, 0, dy);
				y += dy;
				curDirection = isLeft ? 0 : 2;
			} else {
				int dy = isLeft ? -1 * dist : dist;
				addToSet(visited, x, y, 0, dy);
				y += dy;
				curDirection = isLeft ? 2 : 0;
			}
		}
		System.out.println("Result: " + x + " " + y);
		System.out.println(Math.abs(x) + Math.abs(y));
		
	}

	public static void addToSet(HashSet<String> visited, int x, int y, int dx, int dy) {
		if(dx > 0) {
			for(int i = 0; i < dx; i++) {
				x++;
				String key = Integer.toString(x) + " " + Integer.toString(y);
				if(visited.contains(key)) System.out.println("FIRST REPEAT: " + key);
				visited.add(key);
			}
		} else if (dx < 0) {
			for(int i = 0; i > dx; i--) {
				x--;
				String key = Integer.toString(x) + " " + Integer.toString(y);
				if(visited.contains(key)) System.out.println("FIRST REPEAT: " + key);
				visited.add(key);
			}
		}

		if(dy > 0) {
			for(int i = 0; i < dy; i++) {
				y++;
				String key = Integer.toString(x) + " " + Integer.toString(y);
				if(visited.contains(key)) System.out.println("FIRST REPEAT: " + key);
				visited.add(key);
			}
		} else if (dy < 0) {
			for(int i = 0; i > dy; i--) {
				y--;
				String key = Integer.toString(x) + " " + Integer.toString(y);
				if(visited.contains(key)) System.out.println("FIRST REPEAT: " + key);
				visited.add(key);
			}
		}
	}
}
