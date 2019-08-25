class Hamming {
    int distance = 0;

    Hamming(String leftStrand, String rightStrand) {
        for (int x = 0; x < leftStrand.length(); x++) {
            char L = leftStrand.charAt(x);
            char R = rightStrand.charAt(x);
            if (L != R) {
                distance++;
            }
        };


    }


    int getHammingDistance() {
        return distance;

    }

}
