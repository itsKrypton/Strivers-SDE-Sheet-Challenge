// https://www.codingninjas.com/codestudio/problems/count-subarrays-with-given-xor_8230830?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 *  K    X
 *  |    |
 * |-| |---|
 * 1 2 3 4 5    Thus, XR = K ^ X, XORing X both sides we get, XR ^ X = K
 * |_______|    So we basically need to find K which is equal to XR ^ X (XR would be our XOR till that point i.e prefXor HashMap)
 *     |
 *     XR
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CountSubarrayWithGivenXOR {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int xor = 0;
        int count = 0;
        for(int i : arr)
        {
            xor ^= i;
            int k = xor ^ x;

            if(map.containsKey(k))
            count += map.get(k);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
	}
}
