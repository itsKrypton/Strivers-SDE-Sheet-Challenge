public class CutLogs {
    public static int cutLogs(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return memoization(k, n, dp);
    }

    public static int memoization(int e, int f, int[][] dp) {
        if (f <= 1 || e == 1) {
            return f;
        }

        if (dp[e][f] != -1) {
            return dp[e][f];
        }

        int ans = Integer.MAX_VALUE;
        int start = 1, end = f;
        while (start <= end) {
            int mid = (start + end) / 2;

            int BREAK = memoization(e - 1, mid - 1, dp);
            int SURVIVE = memoization(e, f - mid, dp);

            ans = Math.min(ans, 1 + Math.max(BREAK, SURVIVE));

            if (BREAK < SURVIVE) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        dp[e][f] = ans;
        return ans;
    }
}
