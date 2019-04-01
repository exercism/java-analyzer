class Twofer {
    String twofer(String name) {
        StringBuilder stringBuilder = new StringBuilder("One for ");
        if (name == null || name.equals("")) {
            stringBuilder.append("you");
        } else {
            stringBuilder.append(name);
        }
        stringBuilder.append(", one for me.");
        return stringBuilder.toString();
    }
}
