import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++)
        answer.add(-1);
        
        for(int i = arr.size() - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && arr.get(i) <= stack.peek())
            stack.pop();

            if(!stack.isEmpty())
            answer.set(i, stack.peek());

            stack.push(arr.get(i));
        }

        return answer;	
    }
}
