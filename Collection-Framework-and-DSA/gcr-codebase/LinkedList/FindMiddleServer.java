class Node {
    String serverName;
    Node next;

    Node(String serverName) {
        this.serverName = serverName;
        this.next = null;
    }
}

public class FindMiddleServer {

    static Node findMiddleServer(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void printChain(Node head) {

        while (head != null) {
            System.out.print(head.serverName);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node("Server-1");
        head.next = new Node("Server-2");
        head.next.next = new Node("Server-3");
        head.next.next.next = new Node("Server-4");
        head.next.next.next.next = new Node("Server-5");

        System.out.println("Server Relay Chain:");
        printChain(head);

        Node middle = findMiddleServer(head);

        System.out.println("Middle Server: " + middle.serverName);
    }
}