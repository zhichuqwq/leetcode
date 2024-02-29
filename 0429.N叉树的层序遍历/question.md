## 429. N 叉树的层序遍历

[N 叉树的层序遍历](https://leetcode.cn/problems/n-ary-tree-level-order-traversal/)



## 题目描述

```
给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int  i = 0;i < n;i++){
                Node rootplus = queue.poll();
                level.add(rootplus.val);
                queue.addAll(rootplus.children);
            }
            res.add(level);
        }
        return res;
    }
}
```

