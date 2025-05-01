public class Badge {
    public String print(Integer id, String name, String department) {
        Optional<Integer> optionalId = Optional.ofNullable(id);
        Optional<String> optionalDepartment = Optional.ofNullable(department);

        String idPart = optionalId.map(i -> String.format("[%d] - ", i)).orElse("");
        String departmentPart = optionalDepartment.orElse("OWNER").toUpperCase();

        return String.format("%s%s - %s", idPart, name, departmentPart);
    }
}
