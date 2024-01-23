## 103. 二叉树的锯齿形层序遍历

[二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/)



## 题目描述

给你二叉树的根节点 `root` ，返回其节点值的 **锯齿形层序遍历** 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)

```
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]
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

这题正常使用BFS，加一个布尔型变量flag控制遍历的方向



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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        boolean flag = true;
        while(!list.isEmpty()){
            int levelsize = list.size();
            //用链表保存每层节点，方便通过头插尾插控制遍历的顺序
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0;i < levelsize;i++){
                TreeNode current = list.poll();
                //flag为true时候尾插
                if(!flag){
                    level.addFirst(current.val);
                }
                else{
                    level.addLast(current.val);
                }
                if(current.left != null){
                    list.offer(current.left);
                }
                if(current.right != null){
                    list.offer(current.right);
                }
            }
            //更改遍历方向
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(n)