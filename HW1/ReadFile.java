import java.io.*;
import java.util.*;
class ReadFile
{
	public static void main(String[] args)throws IOException
	{
		Scanner input =new Scanner(System.in);
		while(input.hasNextDouble())
		{
			System.out.println(input.nextDouble());
		}
		
	}
}
