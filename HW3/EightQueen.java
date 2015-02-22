//I've seen the recursive version of this problem, so I tried it with iteration
import java.util.*;
class EightQueen
{
	public static void main(String args[])
	{
		EightQueen eq=new EightQueen();
		eq.start();
	}
	public final int SIZE=8;
	public int[][] board=new int[SIZE][SIZE]; //board[col][row]
	public int colUpTo=0;        		//0-7
	public int[] colCellUpTo=new int[SIZE];     
	public EightQueen()
	{
		
	}
	public void start()
	{
	//test every grid
	//8 queeens placed on a 8X8 chess board means there is one queen in each column
		//printBoard();
		for(int i=0;i<SIZE;i++)
			colCellUpTo[i]=-1;
		
		int round=0;
		int numToFind;
		int numFound=0;
		Scanner input=new Scanner(System.in);
		pl("Please type in how many configurations of 8 Queens you want to see.");
		numToFind=input.nextInt();
		
		while(numFound<numToFind)
		{
			for(int col=colUpTo;col<SIZE;col++)
			{
				//pl(col+"");
				int cell=nextAvailableCell(col,colCellUpTo[col]+1);
				//p(cell+"");
				//means no available cell in this column
				if(cell==-1)       		
				{
					//p("bad");
					//avoid index out of bound
					if(colUpTo>0)       
					{
						//current column is not working,so clean the data of the column that is after this column
						//forget about the where the rest of the cells up to
						//but not forget it of this column, because it will need the colCellUpTo variable to determin where to start to search the next cell
						cleanCellUpToFrom(colUpTo);      
						colUpTo--;
						//clean the columns from the current column to the end so that it can repeat the process
						cleanColFrom(colUpTo);
						//printBoard();
						
						
					
					}
					break;			
				}
				else
				//found the next available cell in the col
				{
					board[col][cell]=1;
					colCellUpTo[col]=cell;
					colUpTo=col;
					//if successfully find the proper cell for the last column
					//it means it found one !!!
					if(col==SIZE-1)
					{
						numFound++;
						pl("Found configuration "+numFound);
						printBoard();
						pl("");
					}
				}
			}
		}
		
	}
	public void cleanColFrom(int col)
	{
		if (col<0)
			return;
		
		for(int i=col;i<SIZE;i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				//pl(""+i+","+j);
				board[i][j]=0;
			}
		}
	}
	public void cleanCellUpToFrom(int col)
	{
		if (col<0||col>=SIZE)
			return;
		
		for(int i=col;i<SIZE;i++)
		{
			colCellUpTo[col]=-1;
		}
	}
	public int nextAvailableCell(int col,int start)
	{
		for(int cell=start;cell<SIZE;cell++)
		{
			if(isEmptyRow(cell)&&checkDiagonal(col,cell))
				return cell;
		}
		return -1;
	}
	public boolean checkDiagonal(int col,int row)
	{
		/*
		if(getCell(col-1,row-1)==1)
			return false;
		else if(getCell(col+1,row-1)==1)
			return false;
		else if(getCell(col-1,row+1)==1)
			return false;
		else if(getCell(col+1,row+1)==1)
			return false;
		else
			return true;
		*/
		//diagonal has 4 directions top left,bottom left,top right and bottom right
		int c=col;
		int r=row;
		//top left
		while(c>=0&&r>=0)
		{

			if(getCell(c,r)==1)
				return false;
			c--;
			r--;
		}
		c=col;
		r=row;
		
		//bottom right
		while(c<SIZE||r<SIZE)
		{
			
			if(getCell(c,r)==1)
				return false;
			c++;
			r++;
			
		}
		
		c=col;
		r=row;
		//top right
		while(c<SIZE&&r>=0)
		{
			if(getCell(c,r)==1)
				return false;
			c++;
			r--;
		}
		c=col;
		r=row;
		//bottom left
		while(c>=0&&r<SIZE)
		{
			if(getCell(c,r)==1)
				return false;
			c--;
			r++;
		}

		return true;
	}
	//check if a cell has a queen
	public int getCell(int col,int row) 
	{
		if(col<SIZE&&col>=0&&row<SIZE&&row>=0)
		{
			return board[col][row];
		}
		else
			return 0;
	}
	public boolean isEmptyRow(int row)
	{
		for(int i=0;i<SIZE;i++)
		{
			if(board[i][row]==1)
				return false;
		}
		return true;
	}
	public void p(String str)
	{System.out.print(str);}
	public void pl(String str)
	{System.out.println(str);}
	public void printBoard()
	{
		for(int i=0;i<SIZE;i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				if(board[j][i]==0)
					p(" |");
				else
					p("Q|");
			}
			pl("");
		}
	}
}