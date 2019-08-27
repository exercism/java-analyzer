public class Hamming {

    private char[] leftStrandArray;
    private char[] rightStrandArray;
    private int difference = 0;
  
  Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == "" && rightStrand != ""){
          throw new IllegalArgumentException("left strand must not be empty.");
        }
         if (rightStrand == "" && leftStrand != ""){
          throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()){
          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        
       leftStrandArray = leftStrand.toCharArray();
       rightStrandArray = rightStrand.toCharArray();
       
       
       for (int i = 0; i < leftStrandArray.length;i++){
         if (leftStrandArray[i] != rightStrandArray[i]){
           difference ++;
         }
       }
     }

    int getHammingDistance() {
        return difference;
    }

}



