import java.util.*;
class Investment
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Type in the investment amount:");
		double amount=input.nextDouble();
		System.out.println("Type in the interest rate:");
		double rate=input.nextDouble();
		System.out.println("Type in the number of years:");
		double year=input.nextDouble();
		double invest_value=amount*(Math.pow((1+rate),year*12));
		System.out.printf("The future investment value is %10.2f .",invest_value);
			

	}
}
