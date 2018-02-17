package prPizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {
	
	private int rows = 0, cols = 0, min = 0, max = 0, tom = 0, mush = 0;
	char [][] pizza; //0 T 1 M
	
	public Pizza ()
	{
		
	}
	
	public void makePizza()
	{
		try {
			Scanner sc = new Scanner(new File("example.in"));
			
			rows = sc.nextInt();
			cols = sc.nextInt();
			min = sc.nextInt();
			max = sc.nextInt();
			
			pizza = new char[rows][cols];
			int i = 0;
			int j=0;
			String ingr;
			while(sc.hasNextLine())
			{
				
				ingr = sc.nextLine();
				for(char a:ingr.toCharArray())
				{
					if(a == 'T')
					{
						tom++;
					}
					else
					{
						mush++;
					}
					pizza[i][j] = a;
					
					j++;
					
					if(j == cols)
					{
						j = 0;
						i++;
					}
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private float fobj (int ocupadas)
	{
		return ocupadas / (float) rows * cols;
	}
	
	public List<Integer> fgen ()
	{
		List <Integer> l = new ArrayList<>();
		
		int sr = 0, sc = 0, er = rows, ec = 1;

		while(sc < rows)
		{
			while(sc < cols)
			{
				if (comprobar(sr, sc, er, ec))
				{
					l.add(sr);
					l.add(sc);
					l.add(er - 1);
					l.add(ec - 1);
					sc = (ec + 1) < cols ? (ec) : cols; 
				}
				else
				{
					if(((er - sr) + (ec - sc)) > max)
					{
						break;
					}
					else
					{
						ec++;
					}
				}
			}
			
			er--;
			
			if (comprobar(sr, sc, er, ec))
			{
				l.add(sr);
				l.add(sc);
				l.add(er - 1);
				l.add(ec - 1);
				sr = (er + 1) < rows ? (er) : 0;
			}
				
		}
		
		return l;
	}
	
	private boolean comprobar(int sr, int sc, int er, int ec)
	{
		boolean ok = false;
		int lt = 0, lm = 0;
		char minActual = minActual();
		int maxSlices = maxSlices();
		int minIngr;
		int minLocal;

		
		for(int i = sc; i < ec; i++)
		{
			for(int j = sr; j < er; j++)
			{
				if(pizza[j][i] == 'T')
				{
					lt++;
				}
				else
				{
					lm++;
				}
			}
		}
		
		if(lt >= min && lm >= min && (lt + lm) <= max)
		{
			if(minActual == 'T')
			{
				minIngr = tom;
				minLocal = lt;
			}
			else
			{
				minIngr = mush;
				minLocal = lm;
			}
			
			if(( minIngr / maxSlices) == 1)
			{
				if(minLocal == 1)
				{
					ok = true;
				}
				else
				{
					ok = false;
				}
			}
			else
			{
				ok = true;
			}
		}		
		
		return ok;
	}
	
	private char minActual ()
	{
		return (tom < mush) ? 'T' : 'M';
	}
	
	private int maxSlices ()
	{
		float tam = rows * cols;
		float div = tam / max;
		
		return (int) Math.ceil(div);
	}
	
	public String toString()
	{
		return "Rows: " + rows + " Cols: " + cols + " Min Ingredient: " + 
				min + " Max Cells: " + max + "\nTomatoes: " + tom + " Mushrooms: "+ mush + " Max Slices: " + maxSlices();	
	}

}
