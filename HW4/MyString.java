
class MyString
{
	private char[] _string;
	public MyString(char[] chars)
	{
		//in case variable chars would be modified out side of the class, it makes a copy of it
		if(chars!=null&&chars.length>0)
		{
			_string=new char[chars.length];
			for(int i=0;i<chars.length;i++)
				_string[i]=chars[i];
		}
	}
	public char charAt(int index)
	{
		//if(index<0||_string==null||index>_string.length)
		//	return 0;
		return _string[index];
	}
	public int length()
	{
		return _string.length;
	}
	public MyString substring(int begin, int end)
	{
		//avoid index out of bound
		//if(begin>end||begin<0||begin>_string.length||end<0||end>_string.length)
		//	return null;
		char[] subStr=new char[end-begin];
		for(int i=begin;i<end;i++)
			subStr[i-begin]=_string[i];
		return new MyString(subStr);
	}
	public MyString toLowerCase()
	{
		//it's immutable, so always create a new instance with a new character array
		char[] newStr=new char[_string.length];
		for(int i=0;i<_string.length;i++)
		{
			if(_string[i]<='Z'&&_string[i]>='A')
			{
				//plus 32 turn it into lower case
				newStr[i]=(char)(_string[i]+32);
			}
			else
				newStr[i]=_string[i];
		}
		return new MyString(newStr);
	}
	public MyString toUpperCase()
	{
		//it's immutable, so always create a new instance with a new character array
		char[] newStr=new char[_string.length];
		for(int i=0;i<_string.length;i++)
		{
			if(_string[i]<='z'&&_string[i]>='a')
			{
				//subtract 32 turn it into upper case
				newStr[i]=(char)(_string[i]-32);
			}
			else
				newStr[i]=_string[i];
		}
		return new MyString(newStr);
	}
	public boolean equals(MyString s)
	{
		if (s.length()!=_string.length)
			return false;
		//when they have the same length, there won't be index out of bound
		for(int i=0;i<_string.length;i++)
		{
			if(s.charAt(i)!=this.charAt(i))
				return false;
		}
		return true;
	}
	public MyString getMyString()
	{
		return new MyString(_string);
	}
	public String toString()
	{
		return new String(_string);
	}
	public static MyString valueOf(int i)
	{
		//even if it's negative, treat it as a positive number, - will be added latter if it's less than 0
		int num=Math.abs(i);
		//the maximum value of int has 10 digits, and the sign(-) also takes up one spot
		char[] buffer=new char[11];
		
		int len=0;
		while(num!=0)
		{
			buffer[len]=(char)(num%10+'0');
			num=num/10;
			len++;
		}
		if(i<0)
		{
			buffer[len]='-';
			len++;
		}
		char[] newStr=new char[len];
		//order needs to be reversed
		for(int j=0;j<len;j++)
			newStr[len-1-j]=buffer[j];
		return new MyString(newStr);
	}
}