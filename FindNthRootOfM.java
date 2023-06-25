/*
 * Raising some x to n gives us m. Hence we just need to find via binary search the x between 1 to m, which when raised to n gives us the answer m.
 */

public class FindNthRootOfM {
    public static int NthRoot(int n, int m) {
        int low = 1, high = m;

        while(low <= high)
        {
            int mid = low + ((high - low) / 2);

            int res = power(mid, n, m);

            if(res > 0)
            high = mid - 1;

            else if(res < 0)
            low = mid + 1;

            else
            return mid;
        }

        return -1;
    }

    public static int power(int x, int n, int m)
    {
        long ans = 1;

        for(int i = 0; i < n; i++)
        {
            ans *= x;
            if(ans > m) return 1;
        }

        return (ans == m) ? 0 : -1;
    }
}
