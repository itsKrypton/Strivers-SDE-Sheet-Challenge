/*
 * The min he can study is a chapter in a day, so find the chapter which takes the most time, that's your min. The max he can study is all chapters in one day, so that's
 * your max time. Now that we have a min and max time, using BS, we can find out the max min time that he can spend in a day to complete his studies by the nth day.
 */

public class AllocateBooks {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long min = Long.MIN_VALUE, max = 0;

        for(int i : time)
        {
            min = Math.max(i, min);
            max += i;
        }

        while(min <= max)
        {
            long mid = min + (max - min) / 2;

            int days = 1;
            long currTime = 0;
            for(int i : time)
            {
                if(currTime + i <= mid)
                currTime += i;

                else
                {
                    days++;
                    currTime = i;

                    if(days > n) break;
                }
            }

            if(days > n) // Took more time to complete so we need to increase the time spent each day.
            min = mid + 1;

            else
            max = mid - 1; // Completed within time so we can try decreasing the amount of time spent in a day.
        }

        return min;
    }
}
