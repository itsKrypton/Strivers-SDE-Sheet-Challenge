// https://www.codingninjas.com/codestudio/problems/day-6-majority-element_8230731?challengeSlug=striver-sde-challenge&leftPanelTab=0

public class MajorityElement {
    public static int findMajority(int[] arr, int n) {
		int count = 0;
        int candidate = 0;

        for(int num : arr)
        {
            if(count == 0)
            candidate = num;

            count += (num == candidate) ? 1 : -1;
        }

		count = 0;
        for(int num : arr)
		{
			if(num == candidate) count++;
		}

		return (count > (n/2)) ? candidate : -1;
	}
}
