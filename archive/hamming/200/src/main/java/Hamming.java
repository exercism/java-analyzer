import org.apache.commons.lang3.StringUtils;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        } else if (StringUtils.isEmpty(leftStrand)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (StringUtils.isEmpty(rightStrand)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        int distance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

}
