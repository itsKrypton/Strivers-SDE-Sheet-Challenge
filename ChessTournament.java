// https://www.codingninjas.com/studio/problems/chess-tournament_8230779?challengeSlug=striver-sde-challenge&leftPanelTab=0 and https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTab=1

/*
 * Find min and max distance of placing bulls and then via BS, find the best one.
 */

import java.util.Arrays;

public class ChessTournament {
    public static int chessTournament(int[] positions, int n,  int c) 
	{
        Arrays.sort(positions);

        int low = Integer.MAX_VALUE, high = positions[n - 1] - positions[0];
        for(int i = 1; i < n; i++)
        low = Math.min(low, positions[i] - positions[i - 1]);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int totalChessPlayers = 1;
            int lastRoom = positions[0];

            for(int i = 1; i < n; i++)
            {
                if(positions[i] - lastRoom >= mid)
                {
                    totalChessPlayers++;
                    lastRoom = positions[i];
                }
            }

            if(totalChessPlayers >= c)
            low = mid + 1;

            else
            high = mid - 1;
        }

        return high;
    }
}
