import java.util.*;
class Calendar
{
	private int year;
	private int first;
	private String [] months={"January","February","March",
							"April","May","June","July","August",
							"September","October","November","December"};
	public Calendar(int year,int first)
	{
		this.year=year;
		this.first=first;
	}

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("What year of the calendar do you want to print?");
		int year=input.nextInt();
		System.out.println("What day do you want January First to fall on?(0 to 6 represents Su Mo.. Sa)");
		int first=input.nextInt();

		Calendar cal=new Calendar(year,first);
		for(int i=1;i<=12;i++)
		{
			cal.PrintMonth(i);
			System.out.println();
		}
		
		
	}
	public void PrintMonth(int m)
	{
		int width=20;
		//print header
		String header=months[m-1]+" "+year;
		int hlen=header.length();
		String left;
		String right;
		right=left=getSpace((20-hlen)/2);
		p(left+header+right+"\n");
		p("Su Mo Tu We Th Fr Sa\n");
		//the current position(1-7) of the table,
		int position;
		//get days before this month
		int days=getDaysBeforeThisMonth(m);
		position=(first+days)%7+1;
		//print the padding
		p(getSpace((position-1)*3));

		
		for (int i=0;i<getDaysByMonth(m);i++)
		{
			if((position)%7==0)
				pf("%2s \n",""+(i+1));
			else
				pf("%2s ",""+(i+1));
			position++;
		}
	}
	//i is the current month
	private int getDaysBeforeThisMonth(int m)
	{
		int sum=0;
		for(int i=1;i<m;i++)
			sum+=getDaysByMonth(i);
		return sum;
	}
	//get number of days by month
	private int getDaysByMonth(int m)
	{
		int days=0;
		switch(m)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days= 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days=30;
				break;
			case 2:
				if ((year % 4 == 0) && year % 100 != 0)
					days= 29;
				else
					days= 28;
			default:
				days=0;
		}
		return days;
	}
	private String getSpace(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
			s+=" ";
		return s;
	}
	public void pf(String format,String str)
	{
		System.out.printf(format,str);
	}
	public void p(String str)
	{
		System.out.print(str);
	}
	
}