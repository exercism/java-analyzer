class Hamming
{
  String leftStrand;
  String rightStrand;

  Hamming( String leftStrand, String rightStrand )
  {
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;

    if ( leftStrand.isEmpty() && !rightStrand.isEmpty() )
    {
      throw new IllegalArgumentException( "left strand must not be empty." );
    }
    else if ( !leftStrand.isEmpty() && rightStrand.isEmpty() )
    {
      throw new IllegalArgumentException( "right strand must not be empty." );
    }
    else if ( leftStrand.length() != rightStrand.length() )
    {
      throw new IllegalArgumentException( "leftStrand and rightStrand must be of equal length." );
    }

  }

  public int getHammingDistance()
  {
    if ( leftStrand.equals( rightStrand ) )
    {
      return 0;
    }

    int hammingDistance = 0;

    for ( int i = 0; i < leftStrand.length(); i++ )
    {
      if ( leftStrand.charAt( i ) != rightStrand.charAt( i ) )
      {
        hammingDistance++;
      }
    }
    return hammingDistance;
  }

}
