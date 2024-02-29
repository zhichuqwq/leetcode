## 113. 路径总和 II

[路径总和 II](https://leetcode.cn/problems/path-sum-ii/)



## 题目描述

```
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。
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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return res;
    }

    public void dfs(TreeNode root,int targetSum){
        if(root == null){return;}
        targetSum -= root.val;
        path.add(root.val);
        if(targetSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.remove(path.size() - 1);
    }
}
```

