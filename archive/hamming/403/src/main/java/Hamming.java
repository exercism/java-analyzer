import java.lang.IllegalArgumentException; 


class Hamming {

    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
    //Schaut ,ob der linke oder rechte String leer ist,wenn ja ,gibt er eine Fehlermeldung aus.
    if(leftStrand == "" && rightStrand != ""){
        throw new IllegalArgumentException("left strand must not be empty.");
    }else if(leftStrand != "" && rightStrand == ""){
        throw new IllegalArgumentException("right strand must not be empty.");
    }else{
        //Schaut ,ob beide Strings gleich lang sind , wenn nicht ,gibt er eine Fehlermeldung aus.
         if(leftStrand.length() != rightStrand.length()){
             throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }  
                left = leftStrand;
                right = rightStrand;
        }
    }
    int getHammingDistance() {
        //Schaut ,ob beide Strings den gleichen Inhalt haben ,wenn ja ,gibt er 0 aus.
        if (left.equals(right)){
            return 0;
        }else{
            //Berechnet den Unterschied der Strings und gibt die Zahl der Unterschiede am Ende aus.
            int misMatchCount = 0;
            for (int i=0; i<left.length();i++){
                if(left.charAt(i) != right.charAt(i)){
                    misMatchCount++;
                }

            }
            return misMatchCount;



        }



    }

}
