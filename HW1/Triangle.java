import java.awt.*;
import java.util.*;
import java.lang.*;
class Triangle
{
	static Point[] points=new Point[3];

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		for (int i=0;i<3;i++)
		{
			System.out.printf("Please type the x of point %d: ",i+1);
			double x=input.nextDouble();
			System.out.printf("Please type the y of point %d: ",i+1);
			double y=input.nextDouble();
			Point point=new Point();
			point.setLocation(x,y);
			points[i]=point;
		}
		double line1=getDistance(points[0],points[1]);
		double line2=getDistance(points[1],points[2]);
		double line3=getDistance(points[2],points[0]);
		//System.out.printf(" %f,%f,%f",line1,line2,line3);
		
		if(line1+line2>line3&&line1+line3>line2&&line2+line3>line1)
		{
			System.out.println("This is a real triangle.");
		}
		else
			System.out.println("This is a fake triangle.");
	}
	public static double getDistance(Point p1,Point p2)
	{
		double len=Math.sqrt(Math.pow(p2.getX()-p1.getX(),2)+Math.pow(p2.getY()-p1.getY(),2));
		return len;
	}
}
