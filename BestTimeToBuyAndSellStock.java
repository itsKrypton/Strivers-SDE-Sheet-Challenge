import java.util.ArrayList;

public class BestTimeToBuyAndSellStock {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int buyPrice = prices.get(0);
        int maxSellPrice = 0;

        for(int price : prices)
        {
            int currentSellPrice = price - buyPrice;
            maxSellPrice = Math.max(maxSellPrice, currentSellPrice);
            buyPrice = Math.min(buyPrice, price);
        }

        return maxSellPrice;
    }
}
