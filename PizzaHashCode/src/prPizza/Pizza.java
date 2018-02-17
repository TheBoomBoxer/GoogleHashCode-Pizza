package prPizza;

import java.io.File;
import java.io.FileNotFoundException;
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
			Scanner sc = new Scanner(new File("small.in"));
			
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
