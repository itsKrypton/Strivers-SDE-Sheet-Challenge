import java.util.LinkedList;

public class ImplementAQueue {
    LinkedList<Integer> queue;
    ImplementAQueue() {
        queue = new LinkedList<>();
    }

    boolean isEmpty() {
        return (this.queue.size() == 0);
    }

    void enqueue(int data) {
        this.queue.add(data);
    }

    int dequeue() {
        if(!isEmpty())
        {
            int num = this.queue.get(0);
            this.queue.removeFirst();
            return num;
        }
        return -1;
    }

    int front() {
        if(!isEmpty())
        return this.queue.get(0);

        return -1;
    }
}
