public class MColouringProblem {
    public static String graphColoring(int[][] mat, int m) {
		int[] color = new int[mat.length];
		return helper(0, color, mat, m);
	}

	public static String helper(int i, int[] color, int[][] mat, int m)
	{
		if(i == mat.length)
		return "YES";

		for(int currentColor = 1; currentColor <= m; currentColor++)
		{
			for(int j = 0; j < mat.length; j++)
			{
				if(mat[i][j] == 1 && color[j] == currentColor) break;

				if(j == mat.length - 1)
				{
					color[i] = currentColor; // Try a color
					if(helper(i + 1, color, mat, m).equals("YES")) return "YES"; // Return true if it's possible to color in a certain wau
					color[i] = 0; // Try other color if current color was not possible.
				}
			}
		}

		return "NO";
	}
}
