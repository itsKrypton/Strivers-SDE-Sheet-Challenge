public class FindMinimumNumberOfCoins {
    public static int findMinimumCoins(int amount)
    {
        int[] denominations = new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1};

        int totalCoins = 0;
        for(int i = 0; i < denominations.length && amount > 0; i++)
        {
            if(denominations[i] <= amount)
            {
                totalCoins += amount / denominations[i];
                amount %= denominations[i];
            }
        }

        return totalCoins;
    }
}
