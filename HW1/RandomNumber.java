import java.util.*;
class RandomNumber
{
	public static String[] names={"One","Two","Three","Four","Five",
									"Six","Seven","Eight","Nine",
									"Ten","Eleven","Twelve"};
	public static void main(String [] args)
	{
		Random rand=new Random(System.currentTimeMillis());
		int num=rand.nextInt(12);
		System.out.printf("The number got randomly generated is %d (%s)",num+1,names[num]);
	}
}
