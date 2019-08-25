class Twofer {
    String twofer(String name) {
        String output;
        if (name == null) {
            output = "One for you, one for me.";
        } else {
            output = "One for" +name + ", one for me.";
        }
        return output;
    }
    }
