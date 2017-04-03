package lab_1;


import java.util.Random;

public class Board 
{	private char[][] board = new char[3][3];

	public Board()
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				board[i][j] = '-';
			}
		}
	}

	public void print()
	{
		for(int i=0; i<3 ;i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.printf(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	
	
	public boolean checkState()
	{	
		if(board[0][0]==board[1][1] && board[1][1] == board[2][2])
			{
				if(board[1][1]=='X')
				{	System.out.println();
					System.out.println("X wins");
					return true;
				}
				else if(board[1][1]=='O')
				{
					System.out.println();
					System.out.println("O wins");
					return true;
				}
				
			}
		else if(board[0][2]==board[1][1] && board[1][1]==board[2][0])
			{
				if(board[1][1]=='X')
				{	
					System.out.println();
					System.out.println("X wins");
					return true;
				}
				else if(board[1][1] == 'O')
				{
					System.out.println();
					System.out.println("O wins");
					return true;
				}
			}
		
		
		else 
		{
			int apple = 0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(board[i][j] == '-')
							{
									apple = 1;
							}
				}
			}
			if(apple==0)
			{
				System.out.println();
				System.out.println("Tie");
				return true;
			}
		
			// horizontal check
			
			for(int i=0;i<3;i++)
			{	int total = 1;
				 int j;
				for(j=0;j<2;j++)
				{
					if(board[i][j]==board[i][j+1])
					{
						total++;
					}
				}	
				if(total==3)
					{
						if(board[i][1]=='X')
						{	
							System.out.println();
							System.out.println("X wins");
							return true;
						}
						else if(board[i][1]=='O')
						{
							System.out.println();
							System.out.println("O wins");
							return true;
						}
					}	
			
			}
		
			// vertical check
			
			for(int j=0;j<3;j++)
				{
					int total=1;
					int i;
					for(i=0;i<2;i++)
					{
						if(board[i][j]==board[i+1][j])
							{
								total++;
							}
					}
					if(total==3)
					{
						if(board[1][j]=='X')
						{
							System.out.println();
							System.out.println("X wins");
							return true;
						}
						else if(board[1][j]=='O')
						{
							System.out.println();
							System.out.println("O wins");
							return true;
						}
					}
				}
		
		
		}
	
	return false;
	}

	public void put(int x,int y, char val)
	{
		if(x>=3 || y>=3)
		{
			System.out.println("Invalid coordinates. Please enter again.");
			numb--;
		}
		else if(board[x][y] != '-')
		{
			System.out.println("Invalid coordinates. Please enter again.");
			numb--;
		}
		else
		{
			board[x][y] = val;
			print();
		}
		
	}
	
	
	
	public char[][] get()
	{
		return board;
	}
	
	private int numb = 1;
	
	public char tic()
	{
		if(numb%2 == 1)
		{
			numb++;
			return 'O';
		}
		else
		{	numb++;
			return 'X';
		}
	}

	private int flag1;
	private int flag2;
	
	
	
	
	public void myAI()
	{ 	
		
	//wining statergy
		
		for(int x = 0;x<3;x++)
		{	int count=0;
			
			for(int y=0;y<3;y++)
			{
				if(board[x][y] == 'X')
				{
					count+=1;
				}
			}
			if(count == 2 && board[x][0] == 'X' && board[x][1] == 'X' && board[x][2] == '-')
				{
				this.flag1 = x;
				this.flag2 = 2;
				return;
				}
			else if(count ==2 && board[x][0] == 'X' && board[x][2] == 'X' && board[x][1] == '-')
			{
				this.flag1 = x;
				this.flag2 = 1;
				return;
			}
			else if( count ==2 && board[x][1]=='X' && board[x][2]=='X' && board[x][0] == '-')
			{
				this.flag1 = x;
				this.flag2 = 0;
				return;
			}
		}
		
		for(int y =0 ; y<3;y++)
		{
			int count = 0;
			for(int x=0;x<3;x++)
			{
				if(board[x][y]=='X')
				{
					count +=1;
				}
			}
			if(count == 2 && board[0][y] == 'X' && board[1][y] =='X' && board[2][y] == '-')
			{
				this.flag1 = 2;
				this.flag2 = y;
				return;
			}
			else if(count == 2 && board[1][y] == 'X' && board[2][y] == 'X' && board[0][y] == '-')
			{
				this.flag1 = 0;
				this.flag2 = y;
				return;
				
			}
			else if(count==2 && board[0][y] == 'X' && board[2][y] == 'X' && board[1][y] == '-')
			{
				this.flag1 = 1;
				this.flag2 = y;
				return;
			}
		}
		
		//check along l to r diagonal
		
		if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='-')
		{
			this.flag1 = 2;
			this.flag2 = 2;
			return;
		}
		else if(board[1][1] == 'X' && board[2][2]=='X' && board[0][0] == '-')
		{
			this.flag1 = 0;
			this.flag2 = 0;
			return;
		}
		else if(board[0][0] == 'X' && board[2][2] == 'X' && board[1][1] == '-')
		{
			this.flag1 = 1;
			this.flag2 = 1;
			return;
		}
		
		//check along r to l diagonal
		
		if(board[0][2] == 'X' && board[1][1]=='X' && board[2][0] == '-')
		{
			this.flag1 = 2;
			this.flag2 = 0;
			return;
		}
		else if( board[1][1] == 'X' && board[2][0] == 'X' && board[0][2] == '-')
		{
			this.flag1 = 0;
			this.flag2 = 2;
			return;
			
		}
		else if(board[2][0]=='X' && board[0][2]=='X' && board[1][1] == '-')
		{
			this.flag1 = 1;
			this.flag2 = 1;
			return;
		}
	
		
		
		
		
		
		
		
		// counter attack generation
		
		if(board[0][0] == 'O' && board[2][2] == 'O' && board[1][1] == 'X' || board[1][1] == 'X' && board[0][2] == 'O' && board[2][0] == 'O')
		{
			do
			{
		
				flag1 = getanotherX();
				flag2 = getanotherY();
			}
			while((board[flag1][flag2]) != '-');
			return;
		}
		
		
		
		for(int x = 0;x<3;x++)
		{	int count=0;
			
			for(int y=0;y<3;y++)
			{
				if(board[x][y] == 'O')
				{
					count+=1;
				}
			}
			if(count == 2 && board[x][0] == 'O' && board[x][1] == 'O' && board[x][2]=='-')
				{
					this.flag1=x;
					this.flag2=2;
					return;
				}
			else if(count ==2 && board[x][0] == 'O' && board[x][2] == 'O' && board[x][1] == '-')
			{
				this.flag1 = x;
				this.flag2 = 1;
				return;
			}
			else if( count ==2 && board[x][1]=='O' && board[x][2]=='O' && board[x][0] == '-')
			{
				this.flag1 = x;
				this.flag2 = 0;
				return;
			}
		}
		
		for(int y =0 ; y<3;y++)
		{
			int count = 0;
			for(int x=0;x<3;x++)
			{
				if(board[x][y]=='O')
				{
					count +=1;
				}
			}
			if(count == 2 && board[0][y] == 'O' && board[1][y] =='O' && board[2][y] == '-')
			{	
				this.flag1 = 2;
				this.flag2 = y;
				return;
			}
			else if(count == 2 && board[1][y] == 'O' && board[2][y] == 'O' && board[0][y] == '-')
			{
				this.flag1 = 0;
				this.flag2 = y;
				return;
				
			}
			else if(count==2 && board[0][y] == 'O' && board[2][y] == 'O' && board[1][y] == '-')
			{
				this.flag1 = 1;
				this.flag2 = y;
				return;
			}
		}
		
		//check along l to r diagonal
		
		if(board[0][0]=='O' && board[1][1]=='O' && board[2][2] == '-')
		{
			this.flag1 = 2;
			this.flag2 = 2;
			return;
		}
		else if(board[1][1] == 'O' && board[2][2]=='O' && board[0][0] == '-')
		{
			this.flag1 = 0;
			this.flag2 = 0;
			return;
		}
		else if(board[0][0] == 'O' && board[2][2] == 'O' && board[1][1] == '-')
		{
			this.flag1 = 1;
			this.flag2 = 1;
			return;
		}
		
		//check along r to l diagonal
		
		if(board[0][2] == 'O' && board[1][1]=='O' && board[2][0] == '-')
		{
			this.flag1 = 2;
			this.flag2 = 0;
			return;
		}
		else if( board[1][1] == 'O' && board[2][0] == 'O' && board[0][2] == '-')
		{
			this.flag1 = 0;
			this.flag2 = 2;
			return;
			
		}
		else if(board[2][0]=='O' && board[0][2]=='O' && board[1][1] == '-')
		{ 	this.flag1 = 1;
			this.flag2 = 1;
			return;
		}
		
	
		
		
		//initiation stategy

	if(board[1][1] == '-')
	{
		this.flag1 = 1;
		this.flag2 = 1;
		return;
	}
	else if(board[2][2] =='O' && board[0][0] == '-')
	{
		if(board[2][1] == '-' && board[0][1]=='-')
		{
			flag1 = 0;
			flag2 = 1;
		}
		else if(board[1][0] == '-' && board[1][2] == '-')
		{
			flag1 = 1;
			flag2  = 0;
			
		}
		else
		{
			flag1=1;
			flag2=0;
		}
		
		return;
	}
	
	
	else if(board[2][0] == '-' &&  board[0][2] == 'O')
	{
		if(board[0][1] == '-' && board[2][1] == '-')
		{
			flag1 = 2;
			flag2=1;
		}
		else if(board[1][0] == '-' && board[1][2] == '-')
		{
			flag1 = 1;
			flag2 = 0;
		}
		else
		{
			flag1 = 2;
			flag2 = 1;
		}
		return;
	}
	else if(board[2][2] == '-' && board[0][0] == 'O')
	{
		if(board[2][1] == '-' && board[0][1] == '-')
		{
			flag1= 2;
			flag2 =1;
		}
		else if(board[1][0] == '-' && board[1][2] == '-')
		{
			flag1 = 1;
			flag2 = 2;
		}
		else
		{
			flag1 = 2;
			flag2 = 1;
		}
		return;
	}
	else if (board[0][2] == '-' && board[2][0] == 'O')
	{
		if(board[0][1] == '-' && board[2][1]=='-')
		{
			flag1 = 0;
			flag2 = 1;
		}
		else if(board[1][2] == '-' && board[1][0] == '-')
		{
			flag1= 1;
			flag2 = 2;
		}
		else 
		{
			flag1 = 0;
			flag2 = 1;
		}
		return;
	}
	
		else if( board[0][0] == '-' && board[1][0] == '-' && board[2][0] == '-' || board[0][0] == '-' && board[0][1]=='-' && board[0][2] == '-')
	{
		this.flag1 = 0;
		this.flag2 = 0;
		return;
		
	}
	else if( board[2][0] == '-' && board[1][0] == '-' && board[0][0] == '-' || board[2][0] == '-' && board[2][1]=='-' && board[2][2] == '-')
	{
		this.flag1 = 2;
		this.flag2 = 0;
		return;
		
	}
	else if( board[2][2] == '-' && board[2][1] == '-' && board[2][0] == '-' || board[2][2] == '-' && board[1][2]=='-' && board[0][2] == '-')
	{
		this.flag1 = 2;
		this.flag2 = 2;
		return;
		
	}
	else if( board[0][2] == '-' && board[0][1] == '-' && board[0][0] == '-' || board[0][2] == '-' && board[1][2]=='-' && board[2][2] == '-')
	{
		this.flag1 = 0;
		this.flag2 = 2;
		return;
		
	}
	
	flag1 = getanotherX();
	flag2 = getanotherY();
	return;
	
	}
	
	public int getanotherX()
	{
		Random var = new Random();
		return(var.nextInt(3));
	}
	
	public int getanotherY()
	{
		Random var = new Random();
		return(var.nextInt(3));
	}
	
	
	public int getX()
	{
		return flag1;
	}
	public int getY()
	{
		return flag2;
	}
}


