//paste the following code in Main class.
/*
public class Main{
    public static void main(String[] args){
        GigaSecond gigaSecond = new GigaSecond();
        gigaSecond.method();
    }
}
 */

public class GigaSecond extends Main {
    public void method(){
        //let say that there are 40 moments in one hour. This is the definition
        //found on wikipedia.
        int gigaSecond = 1000000000;
        int totalMoments = gigaSecond/90;
        System.out.println("After one second moment will be: " + totalMoments);
    }
}
