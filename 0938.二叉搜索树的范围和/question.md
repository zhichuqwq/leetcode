## 938. 二叉搜索树的范围和

[二叉搜索树的范围和](https://leetcode.cn/problems/range-sum-of-bst/)



## 题目描述

```
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){return res;}
        if(root.val <= high && root.val >= low){
            res += root.val;
        }
        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return res;
    }
}
```

