// import java.lang.Throwble;
class Hamming {
    String leftStrand,rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        validate(leftStrand,rightStrand);
        this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
    }

    int getHammingDistance() {    
         
        int distance=0;
            for(int i=0;i<leftStrand.length();i++){
                if(leftStrand.charAt(i)!=rightStrand.charAt(i))
                    distance++;

        }
        return distance;
       
    }

    void validate(String leftStrand, String rightStrand){
        if(leftStrand.isEmpty() && rightStrand.isEmpty())
            return;
        else if(rightStrand.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        else if(leftStrand.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if(leftStrand.length()!=rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        }
    }

}
