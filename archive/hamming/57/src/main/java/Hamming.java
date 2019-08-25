class Hamming {


    int counter=0;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        char[] leftStrandArray=leftStrand.toCharArray();
        char[] rightStrandArray=rightStrand.toCharArray();


      if(leftStrand.equals("") && rightStrand.equals("")){
            counter=0;
        }
        else if(leftStrand.equals("")){
            throw new IllegalArgumentException("left strand must not be empty.");

        }
        else if(rightStrand.equals("")){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
       else  if(leftStrand.length()!=rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        else  if(leftStrand.equals("") && rightStrand.equals("")){
            getHammingDistance();

        }

        for(int i=0;i<leftStrandArray.length;i++){
            if(leftStrandArray[i]=='G'&& (rightStrandArray[i]=='C'||rightStrandArray[i]=='T'||rightStrandArray[i]=='A')){
               counter++;
            }
            else if(leftStrandArray[i]=='C'&& (rightStrandArray[i]=='G'||rightStrandArray[i]=='A'||rightStrandArray[i]=='T')){
                counter++;
            }
            else if(leftStrandArray[i]=='T'&& (rightStrandArray[i]=='G'||rightStrandArray[i]=='A'||rightStrandArray[i]=='C')){
                counter++;
            }
            else  if(leftStrandArray[i]=='A'&& (rightStrandArray[i]=='G'||rightStrandArray[i]=='T'||rightStrandArray[i]=='C')){
                counter++;
            }
        }

    }

    int getHammingDistance() {
       return counter;
    }

}
