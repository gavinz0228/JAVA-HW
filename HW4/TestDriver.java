class TestDriver{
	public static void main(String[] args)
	{
		char[] myChar={'H','e','l','l','o'};
		MyString myStr=new MyString(myChar);
		System.out.println(myStr);
		System.out.println(myStr.charAt(4));
		System.out.println(myStr.substring(0,5));
		System.out.println(myStr.toLowerCase());
		System.out.println(myStr.toUpperCase());
		//
		//MyString newMyStr=myStr.getMyString();
		//equal
		System.out.println(MyString.valueOf(-777));
		System.out.println(MyString.valueOf(777));
	}
}