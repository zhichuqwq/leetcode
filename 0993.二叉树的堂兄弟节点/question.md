## 993. 二叉树的堂兄弟节点

[二叉树的堂兄弟节点](https://leetcode.cn/problems/cousins-in-binary-tree/)



## 题目描述

```
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y){return false;}
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int level = 0;
        int xlevel = 0, ylevel = 0;
        TreeNode xfather = null, yfather = null;
        while(!list.isEmpty()){
            int n = list.size();
            for(int i = 0;i < n;i++){
                TreeNode cur = list.poll();
                if(cur.left != null && cur.left.val == x){
                    xlevel = level + 1;
                    xfather = cur;
                    list.offer(cur.left);
                }else if(cur.left != null && cur.left.val == y){
                    ylevel = level + 1;
                    yfather = cur;
                    list.offer(cur.left);
                }else if(cur.left != null){
                    list.offer(cur.left);
                }
                if(cur.right != null && cur.right.val == x){
                    xlevel = level + 1;
                    xfather = cur;
                    list.offer(cur.right);
                }else if(cur.right != null && cur.right.val == y){
                    ylevel = level + 1;
                    yfather = cur;
                    list.offer(cur.right);
                }else if(cur.right != null){
                    list.offer(cur.right);
                }
            }
            level++;
            if(xfather != null && yfather != null){
                break;
            }
        }
        return xfather != yfather && xlevel == ylevel;
    }
}
```

