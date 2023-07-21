// https://leetcode.com/problems/flood-fill/description/

/*
 * Pretty much a DFS/BFS, you just color all the cells connected horizontally or vertically to the starting cell if it's same as the initial color and not already visited.
 */

 public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] outputImage = image.clone();

        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        int initialColor = outputImage[sr][sc];
        dfs(sr, sc, initialColor, color, outputImage, xDirections, yDirections);

        return outputImage;
    }

    public static void dfs(int startRow, int startCol, int initialColor, int newColor, int[][] image, int[] xDirections, int[] yDirections)
    {
        image[startRow][startCol] = newColor;

        for(int i = 0; i < xDirections.length; i++)
        {
            int newRow = startRow + xDirections[i];
            int newCol = startCol + yDirections[i];

            if(isValid(newRow, newCol, image) && image[newRow][newCol] == initialColor && image[newRow][newCol] != newColor)
            dfs(newRow, newCol, initialColor, newColor, image, xDirections, yDirections);
        }
    }

    public static boolean isValid(int startRow, int startCol, int[][] image)
    {
        return (startRow >= 0 && startCol >= 0 && startRow < image.length && startCol < image[startRow].length);
    }
}
