import java.awt.*;
import java.util.*;
import java.lang.*;
class Circle
{	
	static Point[] points=new Point[2];
	static double[] radius=new double[2];
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		for(int i=0;i<2;i++)
		{
			System.out.printf("Please type in the x of the circle center %d \n",i+1);
			double x=input.nextDouble();
			System.out.printf("Please type in the y of the circle center %d \n",i+1);
			double y=input.nextDouble();
			System.out.printf("Please type in the radius of circle %d \n",i+1);
			radius[i]=input.nextDouble();
			Point point=new Point();
			point.setLocation(x,y);
			points[i]=point;
		}
		double centerDist=getDistance(points[0],points[1]);
		if(centerDist>radius[0]+radius[1])
		{
			System.out.println("They are separated from each other.");
		}
		else if(centerDist==radius[0]+radius[1])
			System.out.println("They are touching each other.");
		else
		{
			if(centerDist<radius[0]||centerDist<radius[1])
				System.out.println("One of them is completely within another.");
			else
				System.out.println("They are overlapping.");
		}
	}
	public static double getDistance(Point p1,Point p2)
	{
		double len=Math.sqrt(Math.pow(p2.getX()-p1.getX(),2)+Math.pow(p2.getY()-p1.getY(),2));
		return len;
	}
}
