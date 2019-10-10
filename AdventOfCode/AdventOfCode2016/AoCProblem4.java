
import java.util.*;
import java.io.*;
public class AoCProblem4 {

	static class Node implements Comparable<Node> {
		char val;
		int occurrences;

		public void Node(char c, int o) {
			this.val = c;
			this.occurrences = o;
		}

		@Override
		public int compareTo(Node n) {
			if(this.occurrences != n.occurrences) {
				return -1 * Integer.compare(this.occurrences, n.occurrences);
			} else {
				return Integer.compare(this.val, n.val);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("problem4.txt"));
		int count = 0;
		
		/*while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split("-");
			int[] map = new int[26];
			for(int i = 0; i < split.length - 1; i++) {
				for(int j = 0; j < split[i].length(); j++) {
					map[split[i].charAt(j) - 97]++;
				}
			}

			ArrayList<Node> nodes = new ArrayList<Node>();
			for(int i = 0; i < map.length; i++) {
				Node n = new Node();
				n.val = (char)(i + 97);
				n.occurrences = map[i];
				nodes.add(n);
			}
			Collections.sort(nodes);

			HashSet<Character> topFive = new HashSet<Character>();
			for(int i = 0; i < 5; i++) {
				topFive.add(nodes.get(i).val);
			}

			String[] sectorChecksum = split[split.length - 1].split("\\[");
			int sector = Integer.parseInt(sectorChecksum[0]);
			boolean flag = true;
			for(int i = 0; i < 5; i++) {
				char c = sectorChecksum[1].charAt(i);
				if(!topFive.contains(c)) flag = false;
			}
			if(flag) count += sector;
		}
		System.out.println(count);*/

		while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split("-");
			String[] sectorChecksum = split[split.length - 1].split("\\[");
			int sector = Integer.parseInt(sectorChecksum[0]);
			int shift = sector % 26;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < split.length - 1; i++) {
				for(int j = 0; j < split[i].length(); j++) {
					char c = split[i].charAt(j);
					c -= 97;
					c = (char)((c + shift) % 26);
					c += 97;
					sb.append(c);
				}
				sb.append(" ");
			}
			System.out.println(sb);
			if(sb.toString().contains("north")) {
				System.out.println(sector);
				break;
			}
		}
	}
}
