import org.junit.rules.ExpectedException;

class Hamming {
public String ls;
public String rs;

    Hamming(String leftStrand, String rightStrand) {
        ls = leftStrand;
        rs = rightStrand;

        if (("").equals(ls)) throw new IllegalArgumentException("left strand must not be empty.");
        if (rs.equals("")) throw new IllegalArgumentException("right strand must not be empty.");
        if (ls.length() != rs.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");





    }

    int getHammingDistance() {
        int counter = 0;

        for (int i = 0; i < ls.length(); i++)
            if (ls.charAt(i) != rs.charAt(i)) counter++;


        return counter;
    }
        };





