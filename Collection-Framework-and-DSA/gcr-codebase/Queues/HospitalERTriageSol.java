import java.util.*;

public class HospitalERTriageSol {

    static class Patient {
        int priority;
        String name;

        Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }
    }

    static PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((a, b) -> a.priority - b.priority);

    public static void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    public static Patient callNextPatient() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int priority = sc.nextInt();

            admitPatient(new Patient(priority, name));
        }

        while (!triageQueue.isEmpty()) {
            Patient p = callNextPatient();
            System.out.println(p.name + " " + p.priority);
        }
    }
}