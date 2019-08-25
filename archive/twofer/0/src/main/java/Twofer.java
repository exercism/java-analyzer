/**
 * Implementation for the Two Fer Programming Exercise
 */
class Twofer {
    /**
     * Returns a string of the pattern "one for {@code name}, one for me." If {@code name}
     * is not given ({@code null}) then a "you" will be used instead.
     *
     * @param name the string to use as a name in the returned phrase.
     * @return a string phrase using {@code name} or "you" if null.
     */
    String twofer(String name) {
        return "One for " + (name == null ? "you" : name) + ", one for me.";
    }
}
