import com.sun.net.httpserver.Filter.Chain;

class Hamming {

    String str;
    String str1;

    String[] strArr = str.split("");
    String[] strArr1 = str1.split("");
    int distance = 0;


    Hamming(String leftStrand, String rightStrand) {
        this.str = leftStrand;
        this.str1 = rightStrand;

    }

        

    int getHammingDistance() {
        if (strArr.equals(null)) {
            return 0;
        }
        if (strArr.length == strArr1.length) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != strArr1[i]) {
                    distance++;
                } 
                    
                }
            } return distance;
        } 
        

}
