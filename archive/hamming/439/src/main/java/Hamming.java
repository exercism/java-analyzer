class Hamming {

    int distance;
    String left, right;
    Hamming(String leftStrand, String rightStrand)throws IllegalArgumentException {
        left = leftStrand;
        right = rightStrand;
        if(left==null){
          throw new IllegalArgumentException("leftStrand must not be null.");
        }
        if(right==null){
          throw new IllegalArgumentException("rightStrand must not be null.");
        }
        if(left.length()==0 && right.length()>0){
          throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(right.length()==0 && left.length()>0){
          throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(left.length() != right.length()){
          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        distance = 0;
    }

    int getHammingDistance() {

      for(int i=0;i<left.length();i++){
        if(left.charAt(i) != right.charAt(i)){
          distance++;
        }
      }
      return distance;
    }

}
