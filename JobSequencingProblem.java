import java.util.Arrays;
//import java.util.HashSet;

public class JobSequencingProblem {
    /* public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, (a,b) -> (Integer.compare(b[1], a[1])));
        HashSet<Integer> set = new HashSet<>();

        int totalProfit = 0;
        for(int job[] : jobs)
        {
            int currentDeadline = job[0];
            while(currentDeadline-- > 0)
            {
                if(set.add(currentDeadline)) 
                {
                    totalProfit += job[1];
                    break;
                }
            }
        }

        return totalProfit;
    } */

    // This method is accepted on Coding Ninjas
    public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, (a,b) -> (Integer.compare(b[1], a[1])));
        boolean[] slots = new boolean[jobs.length];

        int totalProfit = 0;
        for(int job[] : jobs)
        {
            for(int j = Math.min(job[0] - 1, jobs.length - 1); j >= 0; j--)
            {
                if(!slots[j])
                {
                    slots[j] = true;
                    totalProfit += job[1];
                    break;
                }
            }
        }

        return totalProfit;
    }
}
