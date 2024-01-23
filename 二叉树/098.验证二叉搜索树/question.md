## 98. 验证二叉搜索树

[验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/)



## 题目描述

给你一个二叉树的根节点 `root` ，判断其是否是一个有效的二叉搜索树。

**有效** 二叉搜索树定义如下：

- 节点的左子树只包含 **小于** 当前节点的数。
- 节点的右子树只包含 **大于** 当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。



**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg)

```
输入：root = [2,1,3]
输出：true
```



**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg)

```
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
```



## 思路

- 二叉搜索树的中序遍历是升序排列，判断是否是搜索树只用中序遍历一边树，判断相邻节点值是否升序排序就行



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
    //记录终须遍历前一个节点的值，在遍历过程中判断是不是搜索二叉树
    private Integer prev = null;
    /*
    本来是用个数组存中序遍历序列然后判断是不是升序的，但是用时长了点
    public List<Integer> res = new ArrayList<>();
    */
    public boolean isValidBST(TreeNode root) {
        return bstsort(root);
    }

    public boolean bstsort(TreeNode root){
        if(root == null){return true;}
        //判断接收上一次调用的结果，如果有一个节点返回false就全部返回false
        if(!bstsort(root.left)){return false;};
        if(prev != null && root.val <= prev){return false;}
        prev = root.val;
        return bstsort(root.right);
    }
}
```





#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(log(n))