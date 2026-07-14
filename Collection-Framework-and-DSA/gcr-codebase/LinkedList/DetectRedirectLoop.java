class Node {
    String url;
    Node next;

    Node(String url) {
        this.url = url;
        this.next = null;
    }
}

public class DetectRedirectLoop {

    static boolean hasRedirectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node url1 = new Node("google.com");
        Node url2 = new Node("youtube.com");
        Node url3 = new Node("github.com");
        Node url4 = new Node("chatgpt.com");

        url1.next = url2;
        url2.next = url3;
        url3.next = url4;

        // Create a redirect loop
        url4.next = url2;

        if (hasRedirectLoop(url1)) {
            System.out.println("Redirect Loop Detected");
        } else {
            System.out.println("No Redirect Loop");
        }
    }
}