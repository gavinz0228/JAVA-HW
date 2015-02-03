import java.util.*;
import java.lang.*;
class GuessNumber
{
	public static void main(String[] args)
	{
		System.out.println("This program will generate a number from 1 to 50, take your guess.");
		Random ran=new Random();
		int answer=ran.nextInt(50)+1;
		//System.out.println(answer);

		Scanner input=new Scanner(System.in);
		while (true&&input.hasNextInt())
		{
			int guess=input.nextInt();
			if(guess<answer)
			{
				System.out.println("It's too low.");
			}
			else if(guess> answer)
			{
				System.out.println("It's too high.");
			}
			else
			{
				System.out.println("Congratulations!, you win!");
				break;
			}
		}
	}
}
