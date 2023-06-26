import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MinHeap {
    public static void main(String[] args) {
        int[] answer = minHeap(10, new int[][]{
            {0, 10},
            {0, 9},
            {0, 8}, 
            {0, 7}, 
            {0, 6}, 
            {0, 5},
            {0, 4},
            {0, 3},
            {0, 2},
            {0, 1},
            {1},
            {1},
            {1},
            {1},
            {1},
            {1},
            {1},
            {1},
            {1},
            {1}
        });

        System.out.println(Arrays.toString(answer));
    }

    public static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> answersList = new ArrayList<>();
        LinkedList<Integer> heap = new LinkedList<>();

        for(int[] query : q)
        {
            if(query[0] == 0)
            {
                heap.add(query[1]);
                
                int currentPos = heap.size();

                while(currentPos > 1)
                {
                    if(heap.get(currentPos - 1) < heap.get((currentPos / 2) - 1))
                    {
                        int temp = heap.get(currentPos - 1);
                        heap.set(currentPos - 1, heap.get((currentPos / 2) - 1));
                        heap.set((currentPos / 2) - 1, temp);
                    }

                    currentPos /= 2;
                }
            }

            else
            {
                int temp = heap.get(0);
                heap.set(0, heap.get(heap.size() - 1));
                heap.set(heap.size() - 1, temp);

                answersList.add(heap.removeLast());
                heapify(1 , heap);
            }
        }

        int[] answers = new int[answersList.size()];
        for(int i = 0; i < answers.length; i++)
        answers[i] = answersList.get(i);

        return answers;
    }

    public static void heapify(int currentPos, LinkedList<Integer> heap)
    {
        int leftChild = (currentPos * 2);
        int rightChild = (currentPos * 2) + 1;
        int smallerChild = 0;

        if(leftChild > heap.size() && rightChild > heap.size()) return;

        else if(leftChild > heap.size() && rightChild <= heap.size())
        smallerChild = rightChild;

        else if(leftChild <= heap.size() && rightChild > heap.size())
        smallerChild = leftChild;

        else
        smallerChild = (heap.get(leftChild - 1) <= heap.get(rightChild - 1)) ? leftChild : rightChild;

        if(heap.get(currentPos - 1) > heap.get(smallerChild - 1))
        {
            int temp = heap.get(currentPos - 1);
            heap.set(currentPos - 1, heap.get(smallerChild - 1));
            heap.set(smallerChild - 1, temp);
            heapify(smallerChild, heap);
        }
    }
}
