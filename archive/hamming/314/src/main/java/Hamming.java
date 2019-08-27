import java.util.*;
class Hamming {
    String ls, rs;
    int lLen, rLen;

    Hamming(String leftStrand, String rightStrand) {
        ls = leftStrand;
        rs = rightStrand;
        lLen = ls.length();
        rLen = rs.length();
    }

    int getHammingDistance() {
        if (lLen == 0 && rLen == 0) return 0;

        if (lLen == 0 || rLen == 0) {
            String lOrR = lLen == 0 ? "left" : "right";
            throw new IllegalArgumentException(lOrR + " strand must not be empty.");
        }

        if (lLen != rLen) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        int diff = 0;

        for (int i = 0; i < lLen; i++) {
            diff += ls.charAt(i) == rs.charAt(i) ? 0 : 1;
        }

        return diff;
    }

}
