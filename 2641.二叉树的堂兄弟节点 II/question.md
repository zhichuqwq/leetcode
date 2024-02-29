## 2641. 二叉树的堂兄弟节点 II

[二叉树的堂兄弟节点 II](https://leetcode.cn/problems/cousins-in-binary-tree-ii/)



## 题目描述

```
给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。

如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。

请你返回修改值之后，树的根 root 。

注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
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
```

