class Twofer {
    String twofer(String name) {
        if (name == null || name.isEmpty()) {
            name = "you";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("One for ");
        sb.append(name);
        sb.append(", one for me.");

        return sb.toString();
    }
}
