class Hamming {

    String left, right;
    Hamming(String leftStrand, String rightStrand) { // }throws IllegalArgumentException {
        // Error checks on length
        if (leftStrand.length() != rightStrand.length()) {

            throw new IllegalArgumentException(isOnlyOneEmpty(leftStrand, rightStrand) ?
                String.format("%s strand must not be empty.", (leftStrand=="") ? "left" : "right") :
                "leftStrand and rightStrand must be of equal length.");

            //if (isOnlyOneEmpty(leftStrand, rightStrand)) {
                //throw new IllegalArgumentException(String.format("%s strand must not be empty.", (leftStrand=="") ? "left" : "right"));
            //}
            //throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        System.out.println("setting l: " + leftStrand + " and r: " + rightStrand);
        this.left=leftStrand;
        this.right=rightStrand;
    }

    int getHammingDistance() {
        System.out.println("getHammingDistance(): l: " + left + " and r: " + right);
        return getHammingDistanceRecurse(left, right, 0);
    }
    int getHammingDistanceRecurse(String l, String r, int sum) {
        System.out.println("getHammingDistanceRecurse(): l: " + l + " and r: " + r);
        if (l == r) return sum;
        if (l.length() == 1 && l != r) return sum+1;
        sum = (l.charAt(0) == r.charAt(0)) ? sum : sum+1;
        return getHammingDistanceRecurse(l.substring(1), r.substring(1), sum);

    }

    boolean isOnlyOneEmpty(String l, String r) {
        return (l=="" && r.length() > 0 || r=="" && l.length() > 0);
    }
}
