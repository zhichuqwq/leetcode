## 104. 二叉树的最大深度

[二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)



## 题目描述

```
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
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
    public int res = 0;
    public int maxDepth(TreeNode root) {
        return searchDepth(root,1);
    }

    public int searchDepth(TreeNode root,int depth){
        if(root == null){return Math.max(depth - 1,res);}
        return Math.max(searchDepth(root.left,depth + 1),searchDepth(root.right,depth + 1));
    }
}

```

