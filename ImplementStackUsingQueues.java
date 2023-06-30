import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> queue;
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        if(empty()) return -1;

        for(int i = 0; i < queue.size() - 1; i++)
        queue.add(queue.remove());

        return queue.remove();
    }
    
    public int top() {
        if(empty()) return -1;

        for(int i = 0; i < queue.size() - 1; i++)
        queue.add(queue.remove());

        int num = queue.peek();
        queue.add(queue.remove());

        return num;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
