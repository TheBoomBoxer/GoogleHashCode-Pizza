package prPizza;

import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		Pizza p = new Pizza();
		
		p.makePizza();
		
		System.out.println(p.toString());
		
		List<Integer> l = p.fgen();
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(l.toString());
		
		while(st.hasMoreTokens())
		{
			for(int i = 0; i< 4; i++)
			{
				sb.append(st.nextToken());
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
