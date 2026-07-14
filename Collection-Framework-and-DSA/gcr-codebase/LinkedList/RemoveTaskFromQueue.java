class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveTaskFromQueue {

    static Node removeTask(Node head, int taskId) {

        if (head == null) {
            return null;
        }

        if (head.val == taskId) {
            return head.next;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    static void printQueue(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);
        head.next.next.next = new Node(104);
        head.next.next.next.next = new Node(105);

        System.out.println("Task Queue Before Deletion:");
        printQueue(head);

        int completedTaskId = 103;

        head = removeTask(head, completedTaskId);

        System.out.println("Task Queue After Deletion:");
        printQueue(head);
    }
}