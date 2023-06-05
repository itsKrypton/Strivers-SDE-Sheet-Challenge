public class Sort012 {
    public static void sort012(int[] arr)
    {
        int noOfZeroes = 0, noOfOnes = 0, noOfTwos = 0;
        for(int i : arr)
        {
            if(i == 0)
            noOfZeroes++;

            else if(i == 1)
            noOfOnes++;

            else
            noOfTwos++;
        }
        
        int index = 0;
        while(noOfZeroes != 0)
        {
            arr[index] = 0;
            index++;
            noOfZeroes--;
        }

        while(noOfOnes != 0)
        {
            arr[index] = 1;
            index++;
            noOfOnes--;
        }

        while(noOfTwos != 0)
        {
            arr[index] = 2;
            index++;
            noOfTwos--;
        }
    }
}
