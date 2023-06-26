import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class KMaxSumCombinations {
    public static void main(String[] args) {
        System.out.println(kMaxSumCombination(Arrays.asList(20, 20, 18, 15, 11, 9, 7, 0), Arrays.asList(17, 16, 16, 13, 7, 7, 5, 3), 8, 8));
    }


    public static ArrayList<Integer> kMaxSumCombination(List<Integer> a, List<Integer> b, int n, int k){
		PriorityQueue<Group> pq = new PriorityQueue<>((first, second) -> Integer.compare(second.number, first.number));
		HashSet<Group> set = new HashSet<>();
		Collections.sort(a, Collections.reverseOrder());
		Collections.sort(b, Collections.reverseOrder());
		ArrayList<Integer> ans = new ArrayList<>();
		pq.add(new Group(a.get(0) + b.get(0), 0, 0));

		while(k > 0)
		{
			Group currElement = pq.remove();
			ans.add(currElement.number);
			k--;

			if(currElement.index1 + 1 < a.size())
			{
				Group firstElement = new Group(a.get(currElement.index1 + 1) + b.get(currElement.index2), currElement.index1 + 1, currElement.index2);
				if(set.add(firstElement))
				pq.add(firstElement);
			}

			if(currElement.index2 + 1 < b.size())
			{
				Group secondElement = new Group(a.get(currElement.index1) + b.get(currElement.index2 + 1), currElement.index1, currElement.index2 + 1);
				if(set.add(secondElement))
				pq.add(secondElement);
			}
		}
		
		return ans;
	}

	public static class Group {
		int number;
		int index1;
		int index2;

		public Group (int number, int index1, int index2)
		{
			this.number = number;
			this.index1 = index1;
			this.index2 = index2;
		}

        @Override
    	public int hashCode() 
		{
            final int prime = 31;
            int result = 1;
            result = prime * result + index1;
            result = prime * result + index2;
            result = prime * result + number;
            return result;
    	}

    	@Override
    	public boolean equals(Object obj) 
		{
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Group other = (Group) obj;
            return index1 == other.index1 && index2 == other.index2 && number == other.number;
    	}
	}
}
