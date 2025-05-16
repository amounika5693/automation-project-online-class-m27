package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
	
	//giving value to add method(int a,,int b)
	int sum=add(10,20);
	System.out.println(sum);
	System.out.println(add(sum,20));
	System.out.println(add(30,21));
	
	//giving value to sub(int a,int b) method
	int sub=sub(60,10);
	System.out.println(sub(sub, 10));
	
	//giving value to mul(int a,int b) method
		int mult=mul(3,1);
		System.out.println(mul(mult, 2));
	}
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static int sub(int a,int b)
	{
		int c=a-b;
		return c;
	}
	
	public static int mul(int a,int b)
	{
		int c=a*b;
		return c;
	}
}
