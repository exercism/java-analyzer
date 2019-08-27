class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
            if (leftStrand.isEmpty() ^ rightStrand.isEmpty()) {
                String expection = leftStrand.isEmpty() ? "left" : "right";
                expection += " strand must not be empty.";
                throw new IllegalArgumentException(expection);
            } else if (leftStrand.length() != rightStrand.length()) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }

        int getHammingDistance() {
            int count = 0;
            char[] leftStandArray = leftStrand.toCharArray();
            char[] rigthStandArray = rightStrand.toCharArray();
            for (int i = 0; i < leftStandArray.length; i++) {
                if (leftStandArray[i] != rigthStandArray[i]) {

                    count += 1;
                }
            }
            return count;

        }
    }


