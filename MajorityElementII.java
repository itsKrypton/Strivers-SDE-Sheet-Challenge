// https://www.codingninjas.com/codestudio/problems/majority-element-ii_8230738?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 * After observation, it can be see that you can only have max 2 numbers which can have more than n/3 occurence. Thus, use the MajorityElement approach of using 
 * Boyer Moores Voting Algo. 
 */

import java.util.ArrayList;

public class MajorityElementII {
    
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int num : arr)
        {
            if(count1 == 0 && num != candidate2)
            {
                candidate1 = num;
                count1 = 1;
            }

            else if(count2 == 0 && num != candidate1)
            {
                candidate2 = num;
                count2 = 1;
            }

            else if(num == candidate1) count1++;

            else if(num == candidate2) count2++;

            else
            {
                count1--;
                count2--;
            }
        }

		count1 = 0; 
        count2 = 0;

        for(int num : arr)
		{
			if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
		}

		if(count1 > (arr.size()/3)) answer.add(candidate1);
        if(count2 > (arr.size()/3)) answer.add(candidate2);

        return answer;
    }
}
