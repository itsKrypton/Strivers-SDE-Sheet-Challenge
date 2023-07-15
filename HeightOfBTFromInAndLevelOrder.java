import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBTFromInAndLevelOrder {
    public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
		HashMap<Integer, Integer> inMap = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		int height = 0;

		queue.add(new Node(0, 0, N - 1)); // First element can be in the range from 0 to length of array with height 0.

		for(int i = 0; i < N; i++)
		inMap.put(inorder[i], i); // Add all inorder elements with their indexes in HashMap for O(1) fetching.

		for(int i = 0; i < N; i++)
		{
			int curr = levelOrder[i];
			Node currNode = queue.remove();
			int inOrderIndex = inMap.get(curr); // Find current element's index in inorder array.

			if(inOrderIndex > currNode.left) // If it's more than the current left index that means there's a left subtree. Add that range in queue.
			{
				height = Math.max(height, currNode.height + 1);
				queue.add(new Node(currNode.height + 1, currNode.left, inOrderIndex - 1));
			}

			if(inOrderIndex < currNode.right) // If it's more than the current right index that means there's a right subtree. Add that range in queue.
			{
				height = Math.max(height, currNode.height + 1);
				queue.add(new Node(currNode.height + 1, inOrderIndex + 1, currNode.right));
			}
		}

		return height;
	}

	public static class Node {
		private int height;
		private int left;
		private int right;

		public Node(int height, int left, int right)
		{
			this.height = height;
			this.left = left;
			this.right = right;
		}
	}
}
