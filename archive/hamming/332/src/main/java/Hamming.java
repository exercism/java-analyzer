class Hamming {
  private String left, right;   //Strands
  
  Hamming(String leftStrand, String rightStrand) {
    if(leftStrand.length() != rightStrand.length() ) {
      String msg = " strand must not be empty.";
      if (leftStrand.isEmpty() )
        msg = "left" +msg;
      else if (rightStrand.isEmpty() )
        msg = "right"+msg;
      else
        msg = "leftStrand and rightStrand must be of equal length.";
    
      throw new IllegalArgumentException(msg);
    }
    left =leftStrand;  
    right=rightStrand;
  }
  
  int getHammingDistance() { 
    int dist=0;
    for(int i=0; i<left.length(); i++) {
        if(left.charAt(i) != right.charAt(i) )
            dist++;
    }
    return dist;
  }
}
