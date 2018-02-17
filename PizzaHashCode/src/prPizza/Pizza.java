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
			Scanner sc = new Scanner(new File("pizza.txt"));
			
			rows = sc.nextInt();
			cols = sc.nextInt();
			min = sc.nextInt();
			max = sc.nextInt();
			
			pizza = new char[rows][cols];
			int i = 0;
			int j=0;
			char ingr;
			while(sc.hasNext())
			{
				ingr = sc.next().charAt(0);
				if(ingr == 'T')
				{
					tom++;
				}
				else
				{
					mush++;
				}
				
				pizza[i][j] = ingr;
				
				j++;
				
				if(j == cols)
				{
					j = 0;
					i++;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private String showArray()
	{
		StringBuilder sc = new StringBuilder();
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				sc.append(pizza[i][j]+" ");
			}
			sc.append("\n");
		}
		
		return sc.toString();
	}
	
	public String toString()
	{
		return "Rows: " + rows + " Cols: " + cols + " Min Ingredient: " + 
				min + " Max Cells: " + max + "\nTomatoes: " + tom + " Mushrooms: "+ mush + "\nPizza: \n" + showArray();	
	}

}
