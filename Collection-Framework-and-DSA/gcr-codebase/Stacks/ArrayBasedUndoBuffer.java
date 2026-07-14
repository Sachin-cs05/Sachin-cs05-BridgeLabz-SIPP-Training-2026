class UndoBuffer {

    private String[] data;
    private int top;

    UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    boolean push(String edit) {

        if (top == data.length - 1) {
            System.out.println("Undo Buffer is Full");
            return false;
        }

        data[++top] = edit;
        return true;
    }

    String pop() {

        if (isEmpty()) {
            throw new RuntimeException("Nothing to Undo");
        }

        return data[top--];
    }

    String peek() {

        if (isEmpty()) {
            throw new RuntimeException("Undo Buffer is Empty");
        }

        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Undo Buffer is Empty");
            return;
        }

        System.out.println("Undo Buffer:");

        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
}

public class ArrayBasedUndoBuffer {

    public static void main(String[] args) {

        UndoBuffer buffer = new UndoBuffer(5);

        buffer.push("Typed Hello");
        buffer.push("Inserted World");
        buffer.push("Deleted !");
        buffer.push("Changed Font");
        buffer.push("Added Paragraph");

        buffer.display();

        System.out.println("\nLatest Edit: " + buffer.peek());

        System.out.println("\nUndo: " + buffer.pop());

        System.out.println();

        buffer.display();

        buffer.push("Changed Color");
    }
}