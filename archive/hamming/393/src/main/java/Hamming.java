import java.lang.Exception;

class Hamming {

    private String m_Left = new String();
    private String m_Right = new String();

    Hamming(String leftStrand, String rightStrand) {
      m_Left = leftStrand;
      m_Right = rightStrand;

    }

    int getHammingDistance() throws Exception {


        int contor = 0;
        if (m_Left == null) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (m_Right == null) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (m_Right.length() != m_Left.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {

            for (int i=0 ; i< m_Left.length(); i++){

                if (m_Left.charAt(i) != m_Right.charAt(i)){contor++;}

            }


        }
        return contor;

    }


}
