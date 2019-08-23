package analyzer.exercises;

public enum Status {
    APPROVE,
    DISAPPROVE,
    REFER_TO_MENTOR;

    public String toJson() {
        return name().toLowerCase();
    }
}