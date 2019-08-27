
class Hamming {

    String left,right="";
    public Hamming(String leftStrand, String rightStrand) {
        if((leftStrand.isEmpty() || leftStrand.isBlank()) && !rightStrand.isBlank()) {
            throw  new IllegalArgumentException("left strand must not be empty.");
        }
        if((rightStrand.isEmpty() || rightStrand.isBlank()) && !leftStrand.isBlank()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() > rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        if(leftStrand.length() < rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        left = leftStrand;
        right = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i=0;i<left.length();i++){
            if (left.charAt(i)!=right.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

}
