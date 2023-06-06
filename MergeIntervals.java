// https://www.codingninjas.com/codestudio/problems/merge-intervals_8230700?challengeSlug=striver-sde-challenge&leftPanelTab=0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> output = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        int currStart = intervals[0].start;
        int currEnd = intervals[0].finish;
        for(Interval interval : intervals)
        {
            if(interval.start <= currEnd)
            {
                if(interval.finish > currEnd)
                currEnd = interval.finish;
            }

            else
            {
                output.add(new Interval(currStart, currEnd));
                currStart = interval.start;
                currEnd = interval.finish;
            }
        }
        output.add(new Interval(currStart, currEnd));

        return output;
    }

    class Interval {
        private int start;
        private int finish;

        public Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
