## 101. 对称二叉树

[对称二叉树](https://leetcode.cn/problems/symmetric-tree/)



## 题目描述

```
给你一个二叉树的根节点 root ， 检查它是否轴对称。
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
    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root,q = root;
        return compare(p,q);
    }

    public boolean compare(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else{
            return compare(p.left,q.right) &&compare(p.right,q.left);
        }
    }
}
```

