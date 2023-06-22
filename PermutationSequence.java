// https://leetcode.com/problems/permutation-sequence/description/ and 

/*
 * We start placing numbers from the first index, for e.g n = 4, by fixing the first index, we will have 3 * 2 * 1 possibilities of the remaining numbers. Thus, we
 * divide k / remaining possibilities. The rest of the K we send to next iteration where we fix the second position and so on. Check strivers video / problem
 * post to understand better.
 */

import java.util.ArrayList;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder();

        int fact = 1;
        for(int i = 1; i <= n; i++) // Calculating fact of n - 1 numbers
        {
            numbers.add(i);

            if(i < n)
            fact *= i;
        }

        k--; // 0 based indexing
        while(numbers.size() > 0)
        {
            int currentNumberIndex = k / fact; // Index of current number to be placed
            sb.append(numbers.get(currentNumberIndex));
            numbers.remove(currentNumberIndex); // Removing that number from set of numbers
            k %= fact; // remaining k

            if(numbers.size() > 0)
            fact /= numbers.size(); // fact of current number length - 1
        }

        return sb.toString();
    }
}
