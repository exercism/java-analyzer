class Hamming {
    public Integer acumulador = 0;
    Hamming(String leftStrand, String rightStrand) throws AssertionError  {
        String minChar = null;
        if (leftStrand.length() <= rightStrand.length()) {
            minChar = leftStrand;
        } else {
            minChar = rightStrand;
        }
        for (int i = 0; i < minChar.length(); i++) {
            if (leftStrand.charAt(i) == rightStrand.charAt(i)) {
                acumulador++;
            }
        };
    }

    int getHammingDistance() throws AssertionError {
        return acumulador;
    }

}
