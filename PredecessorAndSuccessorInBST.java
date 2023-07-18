// https://www.codingninjas.com/codestudio/problems/predecessor-and-successor_920476?leftPanelTab=0

/*
 * For a successor, we need to find the smallest value that is bigger than the given key. It's the opposite for predecessor.
 */

 import java.util.ArrayList;

 public class PredecessorAndSuccessorInBST {
     public static ArrayList<Integer> findPreSuc(TreeNode root, int key) {
         ArrayList<Integer> predSucc = new ArrayList<>();
         predSucc.add(-1);
         predSucc.add(-1);
 
         findPredecessor(root, predSucc, key);
         findSuccessor(root, predSucc, key);
 
         return predSucc;
     }
 
     public static void findPredecessor(TreeNode root, ArrayList<Integer> predSucc, int key)
     {
         while(root != null)
         {
             if(root.val >= key)
             root = root.left;
 
             else
             {
                 predSucc.set(0, root.val);
                 root = root.right;
             }
         }
     }
 
     public static void findSuccessor(TreeNode root, ArrayList<Integer> predSucc, int key)
     {
         while(root != null)
         {
             if(root.val <= key)
             root = root.right;
 
             else
             {
                 predSucc.set(1, root.val);
                 root = root.left;
             }
         }
     }
 
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
 }
 
