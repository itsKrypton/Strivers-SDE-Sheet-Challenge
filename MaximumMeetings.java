// https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

/*
 * Store start, end and pos in a DS. Sort it on the basis of end time and keep selecting the meetings with the least end time.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumMeetings {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        ArrayList<Group> meetings = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < start.length; i++)
        meetings.add(new Group(start[i], end[i], i + 1));

        Collections.sort(meetings, (a,b) -> Integer.compare(a.endTime, b.endTime));

        answer.add(meetings.get(0).position);
        int currentEnd = meetings.get(0).endTime;

        for(int i = 1; i < meetings.size(); i++)
        {
            Group currentMeeting = meetings.get(i);
            if(currentMeeting.startTime > currentEnd)
            {
                answer.add(currentMeeting.position);
                currentEnd = currentMeeting.endTime;
            }
        }

        return answer;
    }

    static class Group {
        private int startTime;
        private int endTime;
        private int position;

        public Group (int startTime, int endTime, int position)
        {
            this.startTime = startTime;
            this.endTime = endTime;
            this.position = position;
        }

        @Override
        public String toString() {
            return Integer.toString(position);
        }
    }
}
