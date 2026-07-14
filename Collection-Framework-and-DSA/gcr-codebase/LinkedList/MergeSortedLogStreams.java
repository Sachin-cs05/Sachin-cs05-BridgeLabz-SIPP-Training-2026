class Node {
    int timestamp;
    Node next;

    Node(int timestamp) {
        this.timestamp = timestamp;
        this.next = null;
    }
}

public class MergeSortedLogStreams {

    static Node mergeLogStreams(Node a, Node b) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {

            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    static void printLogs(Node head) {

        while (head != null) {
            System.out.print(head.timestamp);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node streamA = new Node(1);
        streamA.next = new Node(4);
        streamA.next.next = new Node(7);

        Node streamB = new Node(2);
        streamB.next = new Node(3);
        streamB.next.next = new Node(8);

        System.out.println("Log Stream A:");
        printLogs(streamA);

        System.out.println("Log Stream B:");
        printLogs(streamB);

        Node merged = mergeLogStreams(streamA, streamB);

        System.out.println("Merged Log Stream:");
        printLogs(merged);
    }
}