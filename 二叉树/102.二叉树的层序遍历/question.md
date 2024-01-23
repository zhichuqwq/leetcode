## 102. 二叉树的层序遍历

[ 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/)



## 题目描述

给你二叉树的根节点 `root` ，返回其节点值的 **层序遍历** 。 （即逐层地，从左到右访问所有节点）。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)

```
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
```

**示例 2：**

```
输入：root = [1]
输出：[[1]]
```

**示例 3：**

```
输入：root = []
输出：[]
```



## 思路

- 层序遍历按理用广度优先搜索BFS更合适，但是DFS让每个节点保存它的层数信息一样可以层序遍历，用DFS做一下



#### java code：

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
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(n)

