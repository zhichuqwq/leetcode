## 116. 填充每个节点的下一个右侧节点

[填充每个节点的下一个右侧节点](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/)



## 题目描述

```
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
```



#### java code

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){return root;}
        Queue<Node> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            int n = list.size();
            Node pren = null;
            for(int i = 0;i < n;i++){
                Node now = list.poll();
                if(pren != null){
                    pren.next = now;
                }
                pren = now;
                if(now.left != null){list.add(now.left);}
                if(now.right != null){list.add(now.right);}
            }
        }
        return root;
    }
}
```

