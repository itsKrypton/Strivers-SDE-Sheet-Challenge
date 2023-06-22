public class ValidSudoku {
    public static boolean isItSudoku(int matrix[][]) {
		return solver(matrix);
	}

	public static boolean solver(int[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 0)
                {
                    for(int c = 1; c <= 9; c++)
                    {
                        if(isSafe(board, i, j, c))
                        {
                            board[i][j] = c;

                            if(solver(board))
                            return true;

                            else
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int i) {
        for(int j = 0; j < board.length; j++)
        {
            if(board[row][j] == i)
            return false;
        }

        for(int j = 0; j < board.length; j++)
        {
            if(board[j][col] == i)
            return false;
        }

        for(int j = (row - (row % 3)); j < ((row - (row % 3)) + 3); j++)
        {
            for(int k = (col - (col % 3)); k < ((col - (col % 3)) + 3); k++)
            {
                if(board[j][k] == i)
                return false;
            }
        }

        return true;
    }
}
