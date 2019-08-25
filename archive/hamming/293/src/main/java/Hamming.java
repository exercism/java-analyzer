class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

         if(leftStrand.isEmpty() && rightStrand.length()>0)
            throw new IllegalArgumentException("left strand must not be empty.");
        else if(rightStrand.isEmpty() && leftStrand.length()>0)
            throw new IllegalArgumentException("right strand must not be empty.");
        else if(leftStrand.length()!=rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        if(leftStrand.isEmpty()&&rightStrand.isEmpty()) return 0;
        else if (leftStrand.length()==1 && rightStrand.length()==1) return (leftStrand.compareTo(rightStrand)==0)? 0: 1;
        else if(leftStrand.compareTo(rightStrand)==0) return 0;
        else {
            int distance =0;
            for (int i=0; i< leftStrand.length(); i++) {
                if(leftStrand.charAt(i)!= rightStrand.charAt(i))
                    distance = distance + 1;
            }
            return distance;
        }
    }
}
