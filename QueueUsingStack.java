import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> input;
    Stack<Integer> output;

    public QueueUsingStack() 
    {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) 
    {
        input.push(x);
    }
    
    public int pop() 
    {
        if(output.isEmpty())
        {
            if(input.isEmpty()) return -1;

            while(!input.isEmpty())
            output.push(input.pop());
        }

        return output.pop();
    }
    
    public int peek() 
    {
        if(output.isEmpty())
        {
            if(input.isEmpty()) return -1;

            while(!input.isEmpty())
            output.push(input.pop());
        }

        return output.peek();
    }
    
    public boolean empty() 
    {
        return (input.isEmpty() && output.isEmpty());
    }
}
