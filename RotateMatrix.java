// https://www.codingninjas.com/codestudio/problems/rotate-matrix_8230774?challengeSlug=striver-sde-challenge&leftPanelTab=0

import java.util.ArrayList;

public class RotateMatrix {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int i = 0;
        int j = 0;

        while(i < n - 1 - i && j < m - 1 - j)
        {
            borderTraversal(mat, i, n - 1 - i, j, m - 1 - j);
            i++;
            j++;
        }
    }

    public static void borderTraversal(ArrayList<ArrayList<Integer>> mat, int rowStart, int rowEnd, int colStart, int colEnd)
    {
        int temp = 0;
        int tempValue = mat.get(rowStart).get(colStart);

        // First Row
        for(int j = colStart + 1; j <= colEnd; j++)
        {
            temp = mat.get(rowStart).get(j);
            mat.get(rowStart).set(j, tempValue);
            tempValue = temp;
        }

        // Last Column
        for(int i = rowStart + 1; i <= rowEnd; i++)
        {
            temp = mat.get(i).get(colEnd);
            mat.get(i).set(colEnd, tempValue);
            tempValue = temp;
        }

        // Last Row
        for(int j = colEnd - 1; j >= colStart; j--)
        {
            temp = mat.get(rowEnd).get(j);
            mat.get(rowEnd).set(j, tempValue);
            tempValue = temp;
        }

        // First Column
        for(int i = rowEnd - 1; i >= rowStart; i--)
        {
            temp = mat.get(i).get(colStart);
            mat.get(i).set(colStart, tempValue);
            tempValue = temp;
        }
    }
}
