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
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return res;}
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        dfsperLevel(root,1);
        return res;
    }

    public void dfsperLevel(TreeNode root,int i){
        if(root == null){return;}
        //当保存该节点的孩子节点的列表还没有创建并且存在该节点的孩子节点时，创建保存新层的列表
        if(res.size() == i && (root.left != null || root.right != null)){res.add(new ArrayList<>());}
        if(root.left != null){res.get(i).add(root.left.val);}
        if(root.right != null){res.get(i).add(root.right.val);}
        //递归孩子节点的时候，加上孩子节点的层数信息
        dfsperLevel(root.left,i+1);
        dfsperLevel(root.right,i+1);
    }
}
