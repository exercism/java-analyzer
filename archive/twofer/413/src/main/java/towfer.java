package twoFer;
public class towfer {
	public static void main(String[] args) {
		System.out.println(twofer(""));
		System.out.println(twofer("Wicks"));
	}
	
	public static String twofer(String name) {
		if (name.equals("")) {
			return "One for you, one for me.";
		}else {
			return "One for " + name +", one for me.";
		}
	}
}
