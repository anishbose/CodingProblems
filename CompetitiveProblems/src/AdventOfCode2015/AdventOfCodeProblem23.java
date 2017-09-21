/**
 * @(#)AdventOfCodeProblem23.java
 *
 *
 * @author 
 * @version 1.00 2015/12/24
 */

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AdventOfCodeProblem23 {
        
    	public static void main(String[] args) throws FileNotFoundException {
			
     		Scanner bab = new Scanner(new File("AdventOfCodeProblem23.txt"));
			
			ArrayList<String> steps = new ArrayList<String>();
			
			while (bab.hasNextLine())
			{
				String s = bab.nextLine();
				steps.add(s);
			}
			int regA = 1;
			int regB = 0;
			int pos = 0;
			// HLF, TPL, INC, JMP, JIE, JIO
			while(pos < steps.size())
			{
				String[] step = steps.get(pos).split(" ");
				out.println(steps.get(pos));
				String command = step[0];
				if(command.charAt(0) != 'j')
				{
					if(command.equals("inc"))
					{
						pos++;
						if(step[1].equals("a"))
						{
							regA++;
						}
						else regB++;
					}
					else if(command.equals("hlf"))
					{
						pos++;
						if(step[1].equals("a"))
						{
							regA/=2;
						}
						else regB/=2;
					}
					else if(command.equals("tpl"))
					{
						pos++;
						if(step[1].equals("a"))
						{
							regA*=3;
						}
						else regB*=3;
					}
				}
				else
				{
					if(command.equals("jmp"))
					{
						if(step[1].charAt(0) == '+')
						{
							pos+= (Integer.parseInt(step[1].substring(1)));
						}
						else pos-= (Integer.parseInt(step[1].substring(1)));
					}
					else if(command.equals("jio"))
					{
						String reg = step[1].substring(0, 1);
						if(reg.equals("a"))
						{
							if(regA == 1)
							{
								if(step[2].charAt(0) == '+')
								{
									pos+= (Integer.parseInt(step[2].substring(1)));
								}
								else pos-= (Integer.parseInt(step[2].substring(1)));
							}
							else pos++;
						}
						else
						{
							if(regB == 1)
							{
								if(step[2].charAt(0) == '+')
								{
									pos+= (Integer.parseInt(step[2].substring(1)));
								}
								else pos-= (Integer.parseInt(step[2].substring(1)));
							}
							else pos++;
						}
					}
					else if(command.equals("jie"))
					{
						String reg = step[1].substring(0, 1);
						if(reg.equals("a"))
						{
							out.println("yeah");
							if(regA % 2 == 0)
							{
								if(step[2].charAt(0) == '+')
								{
									pos+= (Integer.parseInt(step[2].substring(1)));
								}
								else pos-= (Integer.parseInt(step[2].substring(1)));
							}
							else pos++;
						}
						else
						{
							if(regB % 2 == 0)
							{
								if(step[2].charAt(0) == '+')
								{
									pos+= (Integer.parseInt(step[2].substring(1)));
								}
								else pos-= (Integer.parseInt(step[2].substring(1)));
							}
							else pos++;
						}
					}
				}
				out.println(regA);
				out.println(regB);
			}
			out.println(regB);
			bab.close();
    	}
}