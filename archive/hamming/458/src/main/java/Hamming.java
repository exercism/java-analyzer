import java.util.stream.IntStream;

class Hamming {

   private static String first;
   private static String second;

   public Hamming(String first, String second) {
       this.first = first;
       this.second = second;

   }

   public int getHammingDistance() {

       if (first.length() != second.length()) {
           throw new IllegalArgumentException();
       }

           return IntStream.range(0, first.length()).map(i -> first.charAt(i) != second.charAt(i) ? 1 : 0).sum();
       }

   }