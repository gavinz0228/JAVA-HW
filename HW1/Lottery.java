import java.util.*;
class Lottery
{
	public static int [] numbers=new int[3];
	public static int [] inputs=new int[3];
	public static void main(String [] args)
	{
		System.out.println("3 Numbers will be generated from 1 to 59");
		Random rand=new Random(System.currentTimeMillis());
		
		
		for(int i=0;i<3;i++){
			int num=rand.nextInt(59)+1;
			//check if the number already exists
			if(!exists(num))
				numbers[i]=num;
			else
			{
				//already exists ,repeat this process one more time by decrementing i
				i--;
				
			}
		}
		System.out.printf("The lottery numbers are: %d %d %d (shu!~~) \n",numbers[0],numbers[1],numbers[2]);
		
		//obttain the inputs from the user
		System.out.println("Please type in 3 numbers you want to guess.");
		Scanner input=new Scanner(System.in);
		for(int i=0;i<3;i++)
			inputs[i]=input.nextInt();
		
		//how many correct and in right order
		int rightOrder=0;
		for(int i=0;i<3;i++)
		{
			if(numbers[i]==inputs[i])
				rightOrder++;
		}
		if(rightOrder==3)
		{
			System.out.println("You got all numbers correct and in right order! You won $10,000!");
		}
		else
		{
	
			//calculate how many numbers the user guess correctly
			int rightNum=0;
			for (int i=0;i<3;i++)
				for(int j=0;j<3;j++)
				{
					if(numbers[i]==inputs[j])
						rightNum++;
				}
			if(rightNum==3)
			{
				System.out.println("All numbers matched, you won $3,000!");
			}
			else if(rightNum==1)
			{
				System.out.println("One number matched, you won $1,000!");
			}
			else
				System.out.println("You didn't win any prize.");
		
		}
		
	}
	

	public static boolean exists(int num)
	{
		for(int i=0;i<numbers.length;i++)
			if(num==numbers[i])
				return true;
		return false;
	}
}
