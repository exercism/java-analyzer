import java.util.stream.IntStream;

/** Should not be checking character literals. */
class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        validateStrandsHaveEqualLength(leftStrand, rightStrand);

        hammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    private int calculateHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length())
        .filter(index -> nucleotidesDiffer(leftStrand.charAt(index), rightStrand.charAt(index)))
        .count();
    }

    private boolean nucleotidesDiffer(char leftNucleotide, char rightNucleotide) {
        switch (leftNucleotide) {
            case 'C':
                return rightNucleotide == 'A' || rightNucleotide == 'G' || rightNucleotide == 'T';
            case 'A':
                return rightNucleotide == 'C' || rightNucleotide == 'G' || rightNucleotide == 'T';
            case 'G':
                return rightNucleotide == 'A' || rightNucleotide == 'C' || rightNucleotide == 'T';
            case 'T':
                return rightNucleotide == 'A' || rightNucleotide == 'G' || rightNucleotide == 'C';
        }
        return false; // unknown nucleotide
    }

    private void validateStrandsHaveEqualLength() {
        if (leftStrand.length() == rightStrand.length()) {
            return;
        }
        if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        throw new IllegalArgumentException(
            "leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}