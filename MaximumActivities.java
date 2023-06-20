import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumActivities {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        List<Pair> activities = new ArrayList<>();

        for(int i = 0; i < start.size(); i++)
        activities.add(new Pair(start.get(i), end.get(i)));

        Collections.sort(activities, (a,b) -> Integer.compare(a.end, b.end));

        int prevEnd = activities.get(0).end;
        int maxActivities = 1;

        for(int i = 1; i < activities.size(); i++)
        {
            Pair currActivity = activities.get(i);

            if(currActivity.start >= prevEnd)
            {
                maxActivities++;
                prevEnd = currActivity.end;
            }
        }

        return maxActivities;
    }

    static class Pair {
        private int start;
        private int end;

        public Pair(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
}
