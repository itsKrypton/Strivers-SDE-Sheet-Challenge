/*
 * This is what we are doing for input {a, b, c}
 * 000 -> {}
 * 001 -> {a}
 * 010 -> {b}
 * ....
 * 111 -> {a, b, c}
 * 
 * T: O(n^2 * n)
 */

import java.util.ArrayList;

public class PowerSet {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

		for(int i = 0; i < (1 << arr.size()); i++) // 2 ^ arr.size();
		{
			ArrayList<Integer> answer = new ArrayList<>();
			for(int j = 0; j < arr.size(); j++)
			{
				if((i & (1 << j)) != 0) // We are basically checking if the jth bit is set i or not, if it is, then we add jth index of input to our answer.
				answer.add(arr.get(j));
			}
			answers.add(answer);
		}

		return answers;
	}
}
