## 99. 恢复二叉搜索树

[恢复二叉搜索树](https://leetcode.cn/problems/recover-binary-search-tree/)



## 题目描述

给你二叉搜索树的根节点 `root` ，该树中的 **恰好** 两个节点的值被错误地交换。*请在不改变其结构的情况下，恢复这棵树* 。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/28/recover1.jpg)

```
输入：root = [1,3,null,null,2]
输出：[3,1,null,null,2]
解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/10/28/recover2.jpg)

```
输入：root = [3,1,4,null,null,2]
输出：[2,1,4,null,null,3]
解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
```



## 思路

- 在交换节点后，中序遍历序列中会有两个逆序对，第一个逆序对值更大的节点和第二个逆序对值更小的点就是更换的节点



#### java code：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private Integer prve = null;
    private Integer max = null;
    private TreeNode prvep = null;
    private TreeNode prveroot = null;
    private TreeNode nextroot = null;

    public void recoverTree(TreeNode root) {
        recoverTreett(root);
        prveroot.val = nextroot.val;
        nextroot.val = max;
    }

    public void recoverTreett(TreeNode root){
        if (root == null) {
            return;
        }
        recoverTreett(root.left);
        if (prve != null && prve >= root.val) {
            if (max == null) {
                max = prve;
                prveroot = prvep;
            }
            nextroot = root;
        }
        prvep = root;
        prve = root.val;
        recoverTreett(root.right);
    }
}
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(n)