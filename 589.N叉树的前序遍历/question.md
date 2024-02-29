## 589. N 叉树的前序遍历

[N 叉树的前序遍历](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/)



## 题目描述

```
给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。

n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

```



#### java code

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){return res;}
        res.add(root.val);
        for(Node node : root.children){
            preorder(node);
        }
        return res;
    }
}
```

