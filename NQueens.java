import java.util.*;

public class NQueens {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        return nQueens(board, 0);
    }

    public static ArrayList<ArrayList<Integer>> nQueens(boolean[][] board, int row)
    {
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        if(row == board.length)
        {
            answers.add(display(board));
            return answers;
        }

        //Now we start placing the queens
        for(int col = 0; col < board.length; col++)
        {
            //check if the current position is safe to place the queen, if it is then place it and check for the next row.
            if(isSafe(board, row, col))
            {
                board[row][col] = true;
                answers.addAll(nQueens(board, row+1));
                board[row][col] = false;
            }
        }

        return answers;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) 
    {
        //checks for the rows above the queen is same col
        for(int i = 0; i < row; i++)
        {
            if(board[i][col])
            return false;
        }

        //checks for diagonals to the left
        for(int i = 1; row-i>=0 && col-i>=0; i++)
        {
            if(board[row-i][col-i])
            return false;
        }

        //checks for diagonals to the right
        for(int i = 1; row-i>=0 && col+i<=board.length-1; i++)
        {
            if(board[row-i][col+i])
            return false;
        }

        return true;
    }

    public static ArrayList<Integer> display(boolean[][] board)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        for(boolean[] rows : board)
        {
            for(boolean element : rows)
            {
                if(element)
                answer.add(1);

                else
                answer.add(0);
            }
        }
        return answer;
    }
}
