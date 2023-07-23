// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
// https://leetcode.com/problems/number-of-islands/description/ in leetcode problem, diagonals are not considered.

/*
* The cells can be considered as graph nodes and then we just run BFS to find the number of connected nodes (an island).
*/

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int numberOfIslands = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    numberOfIslands++;
                    bfs(new Pair(i, j), grid, visited);
                }
            }
        }

        return numberOfIslands;
    }

    public void bfs(Pair startingVertex, char[][] grid, boolean[][] visited)
    {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(startingVertex);
        visited[startingVertex.x][startingVertex.y] = true;

        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();

            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    //if(i != 0 && j != 0) continue; // If you want to ignore the diagnonals

                    Pair nVertex = new Pair(currentVertex.x + i, currentVertex.y + j);
                    if(isValid(nVertex, grid) && grid[nVertex.x][nVertex.y] == '1' && !visited[nVertex.x][nVertex.y])
                    {
                        queue.add(nVertex);
                        visited[nVertex.x][nVertex.y] = true;
                    }
                }
            }
        }
    }

    public boolean isValid(Pair position, char[][] grid)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < grid.length && position.y < grid[position.x].length);
    }

    public class Pair {
        private int x;
        private int y;
        
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
