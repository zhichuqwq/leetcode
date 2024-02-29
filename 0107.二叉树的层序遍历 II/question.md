## 107. 二叉树的层序遍历 II

[二叉树的层序遍历 II](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/)



## 题目描述

```
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
```

