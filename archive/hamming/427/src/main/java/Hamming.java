import java.util.Optional;

class Hamming {

    Optional<String> left;
    Optional<String> right;

    Hamming(String leftStrand, String rightStrand) {
        left = Optional.ofNullable(leftStrand);
        right = Optional.ofNullable(rightStrand);

        if((left.isPresent() && right.isPresent()) && (left.get().isEmpty() || right.get().isEmpty()) ) {
            if (left.get().isEmpty() && !right.get().isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (right.get().isEmpty() && !left.get().isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
        if(!(left.get().length() == right.get().length())){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int returnTotal = 0;
        char[] leftArray = left.get().toCharArray();
        char[] rightArray = right.get().toCharArray();
        for(int i = 0; i < leftArray.length; i++){
            if(!(leftArray[i] == rightArray[i])){
                returnTotal ++ ;
            }
        }
        return returnTotal;
    }

}
