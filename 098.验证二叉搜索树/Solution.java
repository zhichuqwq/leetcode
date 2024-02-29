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
    //记录终须遍历前一个节点的值，在遍历过程中判断是不是搜索二叉树
    private Integer prev = null;
    /*
    本来是用个数组存中序遍历序列然后判断是不是升序的，但是用时长了点
    public List<Integer> res = new ArrayList<>();
    */
    public boolean isValidBST(TreeNode root) {
        return bstsort(root);
    }

    public boolean bstsort(TreeNode root){
        if(root == null){return true;}
        //判断接收上一次调用的结果，如果有一个节点返回false就全部返回false
        if(!bstsort(root.left)){return false;};
        if(prev != null && root.val <= prev){return false;}
        prev = root.val;
        return bstsort(root.right);
    }
}
