/*
 * Put all candidates in stack, push out two top ones and check whether a knows b, if he does, then a cannot be a celebrity so push b back, else push a back. Repeat till
 * one candidate is remaining. Check that candidate against all other candidates, if he doesn't know others and all others know him.
 */

//import java.util.Stack;

public class TheCelebrityProblem {
    // Commented because the knows function is problem specific and gives errors here
    /* public static int findCelebrity(int n) {
		Stack<Integer> st = new Stack<>();

		for(int i = 0; i < n; i++)
		st.push(i);

		while(st.size() > 1)
		{
			int a = st.pop();
			int b = st.pop();

			if(Runner.knows(a, b))
			st.push(b);

			else
			st.push(a);
		}

		int potentialCelebrity = st.pop();
		for(int i = 0; i < n; i++)
		{
			if(i == potentialCelebrity) continue;
			
			if(Runner.knows(potentialCelebrity, i) || !Runner.knows(i, potentialCelebrity)) return -1;
		}

		return potentialCelebrity;
    } */
}
