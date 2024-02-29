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
    List<Integer> levelvalue = new ArrayList<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null){return root;}
        root.val = 0;
        dfsSearchLevelValues(root,0);
        dfsChangeValues(root,0);
        return root;
    }

    public void dfsSearchLevelValues(TreeNode root,int level){
        if(levelvalue.size() <= level){
            levelvalue.add(root.val);
        }else{
            levelvalue.set(level,root.val + levelvalue.get(level));
        }
        if(root.left != null){dfsSearchLevelValues(root.left,level + 1);}
        if(root.right != null){dfsSearchLevelValues(root.right,level + 1);}
    }

    public void dfsChangeValues(TreeNode root,int level){
        if(root.left != null && root.right != null){
            root.left.val = levelvalue.get(level + 1) - root.left.val - root.right.val;
            root.right.val = root.left.val;
            dfsChangeValues(root.left,level + 1);
            dfsChangeValues(root.right,level + 1);
        }else if(root.left != null && root.right == null){
            root.left.val = levelvalue.get(level + 1) - root.left.val;
            dfsChangeValues(root.left,level + 1);
        }else if(root.right != null && root.left == null){
            root.right.val = levelvalue.get(level + 1) - root.right.val;
            dfsChangeValues(root.right,level + 1);
        }else{return;}
    }
}
