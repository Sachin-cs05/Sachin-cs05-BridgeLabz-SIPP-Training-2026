import java.util.*;

public class PrintQueueRushJobSol {

    static Deque<Integer> printQueue = new ArrayDeque<>();

    public static void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    public static void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    public static int printNextJob() {
        return printQueue.removeFirst();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int normalJobs = sc.nextInt();

        for (int i = 0; i < normalJobs; i++) {
            int jobId = sc.nextInt();
            submitJob(jobId);
        }

        int urgentJob = sc.nextInt();
        submitUrgentJob(urgentJob);

        while (!printQueue.isEmpty()) {
            System.out.println(printNextJob());
        }
    }
}