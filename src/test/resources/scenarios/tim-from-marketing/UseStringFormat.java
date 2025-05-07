public class Badge {
    public String print(Integer id, String name, String department) {
        if (department == null) {
            department = "OWNER";
        } else {
            department = department.toUpperCase();
        }

        if (id == null) {
            return String.format("%s - %s", name, department);
        } else {
            return String.format("[%d] - %s - %s", id, name, department);
        }
    }
}
