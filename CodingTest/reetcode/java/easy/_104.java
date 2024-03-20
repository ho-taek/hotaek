package reetcode.java.easy;
import java.util.*;

import javax.swing.tree.TreeNode;
public class _104 {
  
  public static class TreeNode {
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

  public static void main(String[] args){
    
  }
  public int maxDepth(TreeNode root) {
    if(root == null){
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while(!queue.isEmpty()){
      depth += 1;
      
      for(int i =0; i < queue.size(); i++){
        TreeNode q = queue.poll();
        if(q.left != null){
          queue.offer(q.left);
        }
        if(q.right != null){
          queue.offer(q.right);
        }
      }
    }
    return depth;
  }
}
