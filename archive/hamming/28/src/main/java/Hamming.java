class Hamming {
    private String ls;
    private String rs;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length()!=rightStrand.length()) 
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        ls=leftStrand;
        rs=rightStrand;
    }

    int getHammingDistance() {
      int hamCheese=0;
      for (int i = 0; i < ls.length(); i++) {
          if (ls.substring(i, i+1).compareTo(rs.substring(i,i+1))!=0)
            hamCheese+=1;
      }
      return hamCheese;
    }

}
