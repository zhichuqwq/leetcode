## 110. 平衡二叉树

[平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree/)



## 题目描述

```
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
```



#### java code

```java
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
```

