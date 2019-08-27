import java.lang.*;
class Hamming {
    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");     
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        int distance = 0;

        if(l.length == 0 && r.length == 0){
            return 0;
        }
        else if(l.length == r.length){
                
            for (int i = 0; i<l.length;i++){
                if (l[i] != r[i]){
                    distance++;
                }
            }
            return distance;
        }
        else if (l.length == 0 && r.length != 0){
            throw new IllegalArgumentException("left strand must not be empty."); 
        }
        else if(r.length == 0 && l.length != 0){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        else{
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        }

    }
}