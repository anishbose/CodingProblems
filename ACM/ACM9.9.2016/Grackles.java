import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Grackles {

	static int oPos;
	static int pos;
	static int next;
	public Grackles(int p) {
		oPos = p;
		pos = p;
	}
	public static int oPos() {
		return oPos;
	}
	public static int getPos() {
		return pos;
	}
	public static void setPos(int p) {
		pos = p;
	}
	public static void setNext(int p) {
		next = p;
	}
	public static int getNext() {
		return next;
	}
	
	public static void main(String[] args) throws IOException{

		Scanner bab = new Scanner(System.in);
		
		int times = Integer.parseInt(bab.nextLine());
		while(times > 0) {
			int birds = Integer.parseInt(bab.nextLine());
			ArrayList<Grackles> all = new ArrayList<Grackles>();
			for(int i = 0; i < birds; i++) {
				Grackles g = new Grackles(Integer.parseInt(bab.next()));
				out.println(g.getPos());
				all.add(g);
			}
			bab.nextLine();
			boolean safe = false;
			while(!safe) {
				out.println();
				for(int j = 0; j < all.size(); j++) {
					int p = all.get(j).getPos();
					out.println(p);
					boolean r = false;
					boolean l = false;
					out.println("pos of all birds");
					for(int i = 0; i < all.size(); i++) {
						out.println(all.get(i).getPos());
						if(all.get(i).getPos() == (p-1)) {
							l = true;
						}
						if(all.get(i).getPos() == (p+1)) {
							r = true;
						}
					}
					out.println(l + " " + r);
					if(!l && r) {
						all.get(j).setNext(p-1);
					} else if (!r && l) {
						all.get(j).setNext(p+1);
					} else if(r && l) {
						all.get(j).setNext(p);
					} else all.get(j).setNext(p);
					out.println(all.get(j).getNext());
					out.println();
				}
				
				for(Grackles g : all) {
					int next = g.getNext();
					int same = 0;
					for(Grackles test : all) {
						if(test.getNext() == next) {
							same++;
						}
					}
					if(same == 1) {
						g.setPos(next);
					}
				}
				
				
				
				safe = test(all);
			}
			
			int lon = 0;
			
			for(Grackles g : all) {
				if(Math.abs(g.getPos() - g.oPos()) > lon) {
					lon = Math.abs(g.getPos() - g.oPos());
				}
			}
			out.println(lon);
			
			
			
			times--;
		}
	}
	
	public static boolean test(ArrayList<Grackles> all) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		for(Grackles g : all) {
			pos.add(g.getPos());
		}
		
		for(Integer i : pos) {
			if(pos.contains(i+1) || pos.contains(i-1)) {
				return false;
			}
		}
		
		
		return true;
	}
}
