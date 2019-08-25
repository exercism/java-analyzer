class Hamming {


    private final String[] mStrings;

    Hamming(String... strings) {
        mStrings = strings;
        checkEmpty("left strand must not be empty.", 0, mStrings);
        checkEmpty("right strand must not be empty.", 1, mStrings);
        checkEquals("leftStrand and rightStrand must be of equal length.", mStrings);
    }

    private void checkEmpty(String message, int index, String... strings) {
        for (int i = 0; i < strings.length; i++) {
            if (i == index) continue;
            if (strings[index] != null && strings[index].length() == 0 && strings[i] != null && strings[i].length() != 0) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void checkEquals(String message, String... strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() != strings[0].length()) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    int getHammingDistance() {
        int counter = 0;
        for (int i = mStrings.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String first = mStrings[j];
                String second = mStrings[j + 1];
                for (int n = 0; n < first.length(); n++) {
                    if (first.charAt(n) != second.charAt(n)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

}
