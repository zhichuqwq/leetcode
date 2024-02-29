/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){return true;}
        boolean flag = true;
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty() && flag){
            TreeNode node = list.poll();
            if(node.left != null){list.offer(node.left);}
            if(node.right != null){list.offer(node.right);}
            if(Math.abs(searchMaxDepth(node.left,1,0) - searchMaxDepth(node.right,1,0)) > 1){
                flag = false;
            }
        } 
        return flag;
    }

    public int searchMaxDepth(TreeNode root,int depth,int cot){
        if(root == null){return depth - 1;}
        cot = Math.max(cot,depth);
        return Math.max(searchMaxDepth(root.left,depth + 1,cot),searchMaxDepth(root.right,depth + 1,cot));
    }
}
