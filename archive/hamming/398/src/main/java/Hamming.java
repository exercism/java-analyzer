import java.security.spec.ECField;

class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        System.out.println(leftStrand.length() + " " + rightStrand.length());
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.equals("")) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            else if (rightStrand.equals(""))
                throw new IllegalArgumentException("right strand must not be empty.");
            else
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }


    }

    int getHammingDistance() {

                int length = 0;
                for (int i = 0; i < leftStrand.length(); i++) {
                    if (leftStrand.charAt(i) != rightStrand.charAt(i))
                        length++;
                }
                return length;

    }

}
