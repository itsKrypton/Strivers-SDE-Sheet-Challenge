// https://www.codingninjas.com/codestudio/problems/minimum-number-of-platforms_8230720?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 * Sort both the arrivals and departures separately. That is because we dont need to keep track of arrival and departure of a specific train. Use two pointers and check
 * if currArrival <= currDeparture, if it is then you need to use a new platform and if it's not then you get rid of a platform. Keep a track of max platforms all the
 * time.
 */

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int maxPlatforms = 0, currentPlatforms = 0, currArrival = 0, currDeparture = 0;

        while(currArrival < n)
        {
            if(at[currArrival] <= dt[currDeparture]) 
            {
                currentPlatforms++;
                currArrival++;
            }

            else
            {
                currentPlatforms--;
                currDeparture++;
            }

            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;
    }
}
