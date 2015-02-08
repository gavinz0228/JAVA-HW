import java.util.*;
class PrintTriangle
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.print("How tall do you want the pyramid to be?");
		int tall=input.nextInt();
		PrintTriangle pt=new PrintTriangle();
		System.out.print(pt.print(tall));
	}
	private String print(int height)
	{
		String output="\n";
		int space=height-1;
		//height is the number of layers
		for (int i=0;i<height;i++)
		{
			//peak is the middle of a layer, is equal to the current number of the layer
			int peak=i+1;
			//fill the space first
			output+=getSpace(space);
			//the increasing half of a layer
			for(int j=1;j<=peak;j++)
			{
				output+=""+j;
			}
			// the decreasing half
			for(int k=peak-1;k>0;k--)
			{
				output+=""+k;
			}
			output+="\n";
			space--;
		}
		return output;
	}
	private String getSpace(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
			s+=" ";
		return s;
	}
}