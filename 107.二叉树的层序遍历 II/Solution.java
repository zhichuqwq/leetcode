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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){return res;}
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int num = list.size();
            for(int i = 0;i < num;i++){
                TreeNode cur = list.poll();
                level.add(cur.val);
                if(cur.left != null){
                    list.offer(cur.left);
                }
                if(cur.right != null){
                    list.offer(cur.right);
                }
            }
            res.addFirst(level);
        } 
        return res;
    }
}
