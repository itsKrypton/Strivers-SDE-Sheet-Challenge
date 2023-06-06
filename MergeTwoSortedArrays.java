// https://www.codingninjas.com/codestudio/problems/merge-two-sorted-arrays_8230835?challengeSlug=striver-sde-challenge&leftPanelTab=0

public class MergeTwoSortedArrays {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int i = 0;

        for(i = m + n - 1; i >= 0 && index1 != -1 && index2 != -1; i--)
        {
            if(arr1[index1] > arr2[index2])
            arr1[i] = arr1[index1--];

            else
            arr1[i] = arr2[index2--];
        }

        while(index1 > -1)
        arr1[i--] = arr1[index1--];

        while(index2 > -1)
        arr1[i--] = arr2[index2--];

        return arr1;
    }
}
