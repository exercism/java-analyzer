class Hamming {

String leftStrandVar;
String rightStrandVar;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length() && !rightStrand.equals("")  && !leftStrand.equals("")) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
   else if(leftStrand.equals("") && !rightStrand.equals("")) {throw new IllegalArgumentException("left strand must not be empty.");}
   else if(rightStrand.equals("") && !leftStrand.equals("")) {throw new IllegalArgumentException("right strand must not be empty.");}
   else {leftStrandVar = leftStrand;
        rightStrandVar = rightStrand;}
    }

    int getHammingDistance() {
        int counter=0;
        String[] leftArray = leftStrandVar.split("(?!^)");
        String[] rightArray = rightStrandVar.split("(?!^)");
        for(int i=0; i<leftArray.length;i++){
            if (!leftArray[i].equals(rightArray[i])) {counter++;}
        }
        return counter;
    }

}
