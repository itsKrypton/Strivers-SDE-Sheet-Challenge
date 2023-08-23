// https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {

    // We find the maxLeft and maxRight and take the minimum of both and then subtract it with the current height, that is the amount of water that index can hold.
    //O(2n) time and O(1) space
    /* public int trap(int[] height) {
        int maxElevation = 0;
        int[] elevationDiff = new int[height.length];

        // Calculating max elevation towards the left from an index 
        for(int i = 0; i < height.length; i++)
        {
            elevationDiff[i] = maxElevation;
            maxElevation = Math.max(maxElevation, height[i]);
        }

        // Calculating the minimum elevation between the right most elevation and left most elevation
        maxElevation = 0;
        int totalWater = 0;
        for(int i = height.length - 1; i >= 0; i--)
        {
            elevationDiff[i] = Math.min(maxElevation, elevationDiff[i]);
            int currentWater = elevationDiff[i] - height[i];
            totalWater += (currentWater <= 0) ? 0 : currentWater;
            maxElevation = Math.max(maxElevation, height[i]);
        }

        return totalWater;
    } */

    public int trap(int[] height) {
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, totalWater = 0;

        while(left <= right)
        {
            if(height[left] <= height[right])
            {
                if(height[left] >= maxLeft) 
                maxLeft = height[left];

                else
                totalWater += maxLeft - height[left];
            }

            else
            {
                if(height[right] >= maxRight)
                maxRight = height[right];

                else
                totalWater += maxRight - height[right];
            }
        }

        return totalWater;
    }
}
