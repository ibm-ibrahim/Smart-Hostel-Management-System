public class Student extends User {

    public Student(String name) {
        this.name = name;
        this.role = "Student";
    }

    @Override
    public void dashboard() {
        System.out.println("Student Dashboard Accessed");
    }
}
