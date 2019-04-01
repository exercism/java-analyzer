package package1;

public class TwoFer {
	
	static String Result;
	public static String TwoFerMethod(String ar)
	{
		
		Result="One for "+ar+", one for me.";
		return (Result);
	}
	
	public static String TwoFerMethod()
	{
		Result= "One for you, one for me.";
		return(Result);
	}
	public static void main(String[] args)
	{
		System.out.println(TwoFerMethod("ABC"));
		System.out.println(TwoFerMethod());
		

	}

}
