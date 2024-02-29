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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y){return false;}
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int level = 0;
        int xlevel = 0, ylevel = 0;
        TreeNode xfather = null, yfather = null;
        while(!list.isEmpty()){
            int n = list.size();
            for(int i = 0;i < n;i++){
                TreeNode cur = list.poll();
                if(cur.left != null && cur.left.val == x){
                    xlevel = level + 1;
                    xfather = cur;
                    list.offer(cur.left);
                }else if(cur.left != null && cur.left.val == y){
                    ylevel = level + 1;
                    yfather = cur;
                    list.offer(cur.left);
                }else if(cur.left != null){
                    list.offer(cur.left);
                }
                if(cur.right != null && cur.right.val == x){
                    xlevel = level + 1;
                    xfather = cur;
                    list.offer(cur.right);
                }else if(cur.right != null && cur.right.val == y){
                    ylevel = level + 1;
                    yfather = cur;
                    list.offer(cur.right);
                }else if(cur.right != null){
                    list.offer(cur.right);
                }
            }
            level++;
            if(xfather != null && yfather != null){
                break;
            }
        }
        return xfather != yfather && xlevel == ylevel;
    }
}
