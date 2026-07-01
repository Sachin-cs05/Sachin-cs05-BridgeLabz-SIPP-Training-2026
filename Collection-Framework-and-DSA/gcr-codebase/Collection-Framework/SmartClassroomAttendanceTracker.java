import java.util.*;

public class SmartClassroomAttendanceTracker {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    static void markAttendance(String subject, String student) {

        if (!attendance.containsKey(subject)) {
            attendance.put(subject, new ArrayList<>());
        }

        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student)) {
            System.out.println("Attendance Already Marked.");
        } else {
            students.add(student);
            System.out.println("Attendance Marked Successfully.");
        }
    }

    static void displayAttendance() {

        if (attendance.isEmpty()) {
            System.out.println("No Attendance Records Found.");
            return;
        }

        System.out.println("\n----- Attendance Record -----");

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject : " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println("Total Students Present : " + students.size());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Smart Classroom Attendance Tracker =====");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Subject Name : ");
                    String subject = sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String student = sc.nextLine();

                    markAttendance(subject, student);
                    break;

                case 2:
                    displayAttendance();
                    break;

                case 3:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}