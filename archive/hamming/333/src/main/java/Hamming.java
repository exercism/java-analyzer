import java.lang.IllegalArgumentException;

public class Hamming {

    //private int lS = 0,rS = 0;
    private String lefty,righty;

    public Hamming(String leftStrand, String rightStrand) {
        this.lefty = leftStrand;
        this.righty = rightStrand;
        // I wanna throw a lot.
        if(lefty.length() == 0 && righty.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");     
        }
        if(righty.length() == 0 && lefty.length() != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");     
        }
        if(righty.length() != 0 && lefty.length() != 0 && lefty.length() != righty.length()) {
            //IllegalArgumentException IllA = new IllegalArgumentException();
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
         
        }
        else {
            getHammingDistance();    
        }
    }

    //if(lefty.length() == righty.length()) {
        public int getHammingDistance() {
            //    throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
            //if(lefty.length() == righty.length()) {
                char[] lS = lefty.toCharArray() , rS = righty.toCharArray();
                int hD=0;
                
                for(int i=0; i<lefty.length(); i++) {
                    if (lS[i] != rS[i]) {
                        hD++;
                    }            
                }
                return hD; 
        }
  //}
   
}

//   public int Hamming(String leftStrand, String rightStrand) {
    //    throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
   /*     char left = leftStrand.toCharArray();
        char right = rightStrand.toCharArray();*/
        /*int lsl = leftStrand.length();
        int rsl = rightStrand.length();*/
      //  return 1;
        //can't use ternary operator for different return types in if n else clauses
        //return lsl == rsl ? "leftStrand and rightStrand must be of equal length." : "Well, they are.";
  //   {
      //  }    
       /* else {
         thrown //("leftStrand and rightStrand must be of equal length.");   
        }*/