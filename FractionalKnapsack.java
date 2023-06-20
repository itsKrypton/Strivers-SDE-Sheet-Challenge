import java.util.Arrays;

public class FractionalKnapsack {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a,b) -> Double.compare((double)b.value / (double)b.weight, (double)a.value / (double)a.weight));
		double profit = 0;

		for(Pair item : items)
		{
			if(item.weight <= w)
			{
				profit += item.value;
				w -= item.weight;
			}

			else
			{
				profit += w * ((double)item.value / (double)item.weight);
				break;
			}
		}

		return profit;
    }

    static class Pair
    {
        int weight;
        int value;
        Pair(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }
    }
}
