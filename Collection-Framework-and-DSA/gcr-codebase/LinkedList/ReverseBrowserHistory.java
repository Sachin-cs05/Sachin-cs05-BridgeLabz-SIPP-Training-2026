class Node {
    String page;
    Node next;

    Node(String page) {
        this.page = page;
        this.next = null;
    }
}

public class ReverseBrowserHistory {

    static Node reverseHistory(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }

    static void printHistory(Node head) {

        while (head != null) {
            System.out.print(head.page);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node("ChatGPT");
        head.next = new Node("YouTube");
        head.next.next = new Node("Google");
        head.next.next.next = new Node("GitHub");

        System.out.println("Browser History Before Reversing:");
        printHistory(head);

        head = reverseHistory(head);

        System.out.println("Browser History After Reversing:");
        printHistory(head);
    }
}