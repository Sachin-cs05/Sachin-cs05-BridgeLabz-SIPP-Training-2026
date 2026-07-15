import java.util.*;

public class NetworkPacketBufferSol {

    static class PacketBuffer {
        private int[] data;
        private int front;
        private int count;

        PacketBuffer(int capacity) {
            data = new int[capacity];
            front = 0;
            count = 0;
        }

        boolean enqueue(int packetId) {
            if (count == data.length) {
                return false;
            }

            data[(front + count) % data.length] = packetId;
            count++;
            return true;
        }

        int dequeue() {
            if (count == 0) {
                throw new RuntimeException("Buffer empty");
            }

            int val = data[front];
            front = (front + 1) % data.length;
            count--;

            return val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();
        int n = sc.nextInt();

        PacketBuffer buffer = new PacketBuffer(capacity);

        for (int i = 0; i < n; i++) {
            int packetId = sc.nextInt();
            System.out.println(buffer.enqueue(packetId));
        }

        int dequeueCount = sc.nextInt();

        for (int i = 0; i < dequeueCount; i++) {
            System.out.println(buffer.dequeue());
        }
    }
}