import java.util.*;
class CalculateArea
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		while (input.hasNextDouble())
		{
			Double radius=input.nextDouble();
			System.out.print("The area is:");
			System.out.printf("%5.2f \n",Math.PI*Math.pow(radius,2));
		}
	}
}
