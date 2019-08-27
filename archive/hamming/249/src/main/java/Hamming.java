import java.util.stream.IntStream;

class Hamming {
    String left, right;

    Hamming(String leftStrand, String rightStrand) {
        // is inlining ifs like this a good java practice? I think it reads better, but not sure
        //  how the java community feels about this... (question to mentor)
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");

        // also, there is weird edge case in that two empty strands are valid...??? (first test case)

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        left = leftStrand;
        right = rightStrand;
    }

    int getHammingDistance() {
        // should I make it a practice to always access instance variables via accessors?
        // is there a best practice, or standard method names or syntatical sugar for this 
        //  in java (like attr_accessors in ruby)? (question to mentor)
        Integer countDifferences = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                countDifferences += 1;
            }
        }

        return countDifferences;
    }

    int getHammingDistance_slightlyDeclarativeApproach() {
        return IntStream.range(0, left.length()).reduce(0, (accumulatedDistance, i) -> {
            return accumulatedDistance + (left.charAt(i) != right.charAt(i) ? 1 : 0);
        });
    }

    // if there was a zip function for lists or streams, i'd prefer doing
    // something like:
    /*
    return zip(left.chars(), right.chars(), (a,b) -> a != b ? 1 : 0).collect(Collectors.getSum())
    */

}
