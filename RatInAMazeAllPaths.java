import java.util.ArrayList;

public class RatInAMazeAllPaths {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        helper(0, 0, maze, answers, visited);

        return answers;
    }

    public static void helper(int x, int y, int[][] maze, ArrayList<ArrayList<Integer>> answers, boolean[][] visited)
    {
        if(x == maze.length - 1 && y == maze.length - 1) 
        {
            ArrayList<Integer> answer = new ArrayList<>();
            visited[x][y] = true;

            for(boolean[] i : visited)
            {
                for(boolean j : i)
                {
                    if(j) 
                    answer.add(1);

                    else 
                    answer.add(0);
                }
            }

            visited[x][y] = false;
            answers.add(answer);
            return;
        }

        visited[x][y] = true;
        // Left
        if(isSafe(x, y - 1, maze) && !visited[x][y - 1])
        helper(x, y - 1, maze, answers, visited);

        // Top
        if(isSafe(x - 1, y, maze) && !visited[x - 1][y])
        helper(x - 1, y, maze, answers, visited);

        // Right
        if(isSafe(x, y + 1, maze) && !visited[x][y + 1])
        helper(x, y + 1, maze, answers, visited);

        // Down
        if(isSafe(x + 1, y, maze) && !visited[x + 1][y])
        helper(x + 1, y, maze, answers, visited);

        visited[x][y] = false;
    }

    public static boolean isSafe(int x, int y, int[][] maze)
    {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }
}
