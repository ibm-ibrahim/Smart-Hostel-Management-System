package user.model;

public class Student extends Role {

    public Student(String name) {
        this.name = name;
        this.type = "Student";
    }

    @Override
    public void dashboard() {
        System.out.println("Student Dashboard Accessed");
    }
}
