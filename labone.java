

package lab_1;

import java.util.*;

public class labone 
{	

	public static void main(String[] args) 
	{
		Board b1= new Board();
		Scanner in = new Scanner(System.in);
		System.out.println("Userchoice: ");
		int userinput = in.nextInt();
		if(userinput == 1)
		{	
			do
			{
				int x = in.nextInt();
				int y = in.nextInt();
				char val = b1.tic();
				b1.put(x, y, val);
			}
			while(b1.checkState() != true);
			System.out.println();
		}
		
		
		else if(userinput == 2)
		{
			int tab = 1;
			do
			{
				if(tab%2 == 1)
				{System.out.println();
					System.out.println("Computer:");
					System.out.println();
					Random var = new Random();
					int x,y;
					do
						{
							x = var.nextInt(3);
							y = var.nextInt(3);
						}
					while((b1.get())[x][y] != '-');
					
					char val = 'O';
					b1.put(x, y, val);
					tab++;
					
				}
				else
				{
					System.out.println();
					System.out.println("You:");
					System.out.println();
					int x,y;
					char val = 'X';
					boolean task;
					do
					{
						task = false;
						x = in.nextInt();
						y = in.nextInt();
						
						if(x>=3 || y>=3)
						{
							System.out.println("Invalid coordinates. Please enter again.");
							task = true;
						}
						else if((b1.get())[x][y] != '-')
						{
							System.out.println("Invalid coordinates. Please enter again.");
							task = true;
						}
					}
					while(task);
					b1.put(x, y, val);
					tab++;
				}
			}
			while(b1.checkState() != true);
		}
		
		
		else if(userinput == 3)
		{
			int tab = 1;
			do
			{
				if(tab%2 == 1)
				{	System.out.println();
					System.out.println("Computer:");
					System.out.println();
					Random var = new Random();
					int x,y;
					do
						{
							x = var.nextInt(3);
							y = var.nextInt(3);
						}
					while((b1.get())[x][y] != '-');
					
					
					char val = 'O';
					b1.put(x, y, val);
					tab++;
					System.out.println();
				}
				else
				{	System.out.println();
					System.out.println("AI :");
					System.out.println();
					
					char val = 'X';
					int x;
					int y;
					do
					{
						b1.myAI();
					
						x = b1.getX();
						y  =b1.getY();
					}
					while((b1.get())[x][y] != '-');
				
					
					b1.put(x, y, val);
					tab++;
				}
			}
			while(b1.checkState() != true);
		}
	
	
		else if(userinput == 4)
		{
			int tab = 1;
			do
			{
				if(tab%2 == 1)
				{
					System.out.println();
					System.out.println("You:");
					System.out.println();
					int x,y;
					char val = 'O';
					boolean task;
					do
					{task = false;
						x = in.nextInt();
						y = in.nextInt();
						
						if(x>=3 || y>=3)
						{
							System.out.println("Invalid coordinates. Please enter again.");
							task = true;
						}
						else if((b1.get())[x][y] != '-')
						{
							System.out.println("Invalid coordinates. Please enter again.");
							task = true;
						}
					}
					while(task);
					b1.put(x, y, val);
					tab++;
		
				}
				else
				{
					System.out.println();
					System.out.println("AI :");
					System.out.println();
					
					char val = 'X';
					int x;
					int y;
					do
					{
						b1.myAI();
					
						x = b1.getX();
						y  =b1.getY();
					}
					while((b1.get())[x][y] != '-');
					
					
					b1.put(x, y, val);
					tab++;
				}
			}
			while(b1.checkState() != true);
		}

		else 
		{
			System.out.println("Invalid choice");
		}
		
	}

}
