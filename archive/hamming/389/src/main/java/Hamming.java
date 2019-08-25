class Hamming {

    char[] left;
    char[] right;

    Hamming(String leftStrand, String rightStrand) {

        left = leftStrand.toCharArray();
        right = rightStrand.toCharArray();

        if(left.length==0 && right.length>0){
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(right.length==0 && left.length>0){
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if(left.length != right.length){
            throw  new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {

        int dist = 0;

        for(int i = 0; i<left.length; i++){

            if (left[i] != right[i]){
                dist++;
            }

        }



        return dist;


    }

}
