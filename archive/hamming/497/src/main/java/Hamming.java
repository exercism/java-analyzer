public class Hamming {
  private int hammingDistance = 0;
  
  public Hamming(String left, String right) throws IllegalArgumentException
  {
    if (left.length() != right.length()) {
      if (left == null || left.isEmpty()) {
        throw new IllegalArgumentException("left strand must not be empty.");
      } else if (right == null || right.isEmpty()) {
        throw new IllegalArgumentException("right strand must not be empty.");
      } else {
        throw new 
          IllegalArgumentException(
            "leftStrand and rightStrand must be of equal length."
          );
      }
    }
    
    for (int i = 0; i < left.length(); ++i)
      if (left.toCharArray()[i] != right.toCharArray()[i]) 
        this.hammingDistance += 1;
    
  }

  public int getHammingDistance() 
  { return this.hammingDistance; }

} // public class Hamming
