class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    protected final String studentId;
    protected double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return "Student{" + super.toString() + ", studentId='" + studentId + "', gpa=" + gpa + "}";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return "GradStudent{" + super.toString() + ", thesis='" + thesis + "'}";
    }
}

public class UniversitySystemDemo {
    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("Aman", 24, "STU101", 8.9, "AI in Education");

        System.out.println(gradStudent);

        Student student = gradStudent;
        Person person = gradStudent;

        System.out.println("GradStudent IS-A Student: " + (gradStudent instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (gradStudent instanceof Person));
        System.out.println("Student reference: " + student);
        System.out.println("Person reference: " + person);
    }
}
