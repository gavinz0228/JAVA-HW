import java.io.*;
import java.util.*;
class ReadFile
{
	public static void main(String[] args)throws IOException
	{
		File file=new File("file_input.txt");
		Scanner input =new Scanner(file);
		while(input.hasNextDouble())
		{
			System.out.println(input.nextDouble());
		}
		
	}
}
