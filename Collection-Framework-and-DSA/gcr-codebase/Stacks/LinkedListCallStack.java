class CallStack {

    private static class Frame {

        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top = null;

    void push(String functionName) {
        top = new Frame(functionName, top);
    }

    String pop() {

        if (isEmpty()) {
            throw new RuntimeException("No active call to return from");
        }

        String function = top.functionName;
        top = top.next;

        return function;
    }

    String peek() {

        if (isEmpty()) {
            throw new RuntimeException("Call Stack is Empty");
        }

        return top.functionName;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Call Stack is Empty");
            return;
        }

        System.out.println("Current Call Stack:");

        Frame temp = top;

        while (temp != null) {
            System.out.println(temp.functionName);
            temp = temp.next;
        }
    }
}

public class LinkedListCallStack {

    public static void main(String[] args) {

        CallStack stack = new CallStack();

        stack.push("main()");
        stack.push("login()");
        stack.push("validateUser()");
        stack.push("checkPassword()");

        stack.display();

        System.out.println("\nCurrently Executing: " + stack.peek());

        System.out.println("\nFunction Returned: " + stack.pop());

        System.out.println();

        stack.display();
    }
}