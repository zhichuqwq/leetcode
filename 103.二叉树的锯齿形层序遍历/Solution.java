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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        boolean flag = true;
        while(!list.isEmpty()){
            int levelsize = list.size();
            //用链表保存每层节点，方便通过头插尾插控制遍历的顺序
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0;i < levelsize;i++){
                TreeNode current = list.poll();
                //flag为true时候尾插
                if(!flag){
                    level.addFirst(current.val);
                }
                else{
                    level.addLast(current.val);
                }
                if(current.left != null){
                    list.offer(current.left);
                }
                if(current.right != null){
                    list.offer(current.right);
                }
            }
            //更改遍历方向
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
