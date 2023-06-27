// https://leetcode.com/problems/find-median-from-data-stream/description/

import java.util.PriorityQueue;

// One way of doing this is to have two priority queues, one small and one big and store the incoming values in them. When median is to be found, we can do that
// by getting the biggest value from smallest array and smallest value from larger array.

// Other way to implement this can be using a TreeSet which will insert the values in logn as well and we can keep a pointer to track the middle element to return
// the value in O(1) time.

/*
 * If the numbers are guaranteed to be in (0, 100) then we can initialise a HashTable with key, value pairs. Key being the numbers from 1 to 100 and values are their
 * frequencies and we also keep track of the total numbers. To find median, we just run a loop to get to half of the total numbers which makes the solution O(1) to 
 * insert elements and get median as well.
 * 
 * For some values being over 100 or under 0, we can have another variable storing this types of numbers assuming that median will always be inside the 0,100 range.
 */

//T: O(1) to get median, O(logn) to insert values.

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    
    public FindMedianFromDataStream() {
        small = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a)); // Will store smaller values in a Max Heap to fetch the biggest value of the smaller array
        large = new PriorityQueue<Integer>(); // Will store larger values in a Min Heap to fetch the smallest value of the larger array
    }
    
    public void addNum(int num) {
        if(small.isEmpty())
        small.add(num);

        else if(num > small.peek() && (large.isEmpty() || num >= large.peek()))
        large.add(num);

        else
        small.add(num);

        if(Math.abs(small.size() - large.size()) > 1)
        {
            if(small.size() > large.size())
            large.add(small.remove());

            else
            small.add(large.remove());
        }
    }
    
    public double findMedian() {
        return ((small.size() + large.size()) % 2 == 0) ? (small.peek() + large.peek()) / 2.00 : 
        (small.size() > large.size()) ? small.peek() : large.peek();
    }
}
