public class StackImplementationUsingArray {
    private int[] stack;
    private int top;

    public StackImplementationUsingArray(int capacity)
    {
        this.stack = new int[capacity];
        this.top = -1;
    }

    void push(int num) {
        if(isFull() == 0)
        this.stack[++this.top] = num;
    }

    int pop() {
        if(isEmpty() == 0)
        return this.stack[this.top--];

        return -1;
    }

    int top() {
        if(isEmpty() == 0)
        return this.stack[this.top];

        return -1;
    }

    int isEmpty() {
        return (this.top == -1) ? 1 : 0;
    }

    int isFull() {
        return (this.top == this.stack.length - 1) ? 1 : 0;
    }
}
