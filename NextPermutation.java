public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1)
        return;

        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i] > nums[i-1])
            {
                nextGreater(i-1, nums);
                reverse(i, nums);
                return;
            }
        }
        reverse(0, nums);
        return;
    }
    
    public static void reverse(int index, int nums[])
    {
        int temp=0;
        int low=index;
        int high=nums.length-1;
        while(low<high)
        {
            temp=nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        return;
    }

    public static void nextGreater(int index, int nums[])
    {
        int temp=0;
        for(int j=nums.length-1;j>=index;j--)
        {
            if(nums[j] > nums[index])
            {
                temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
                return;
            }
        }
    }
}
