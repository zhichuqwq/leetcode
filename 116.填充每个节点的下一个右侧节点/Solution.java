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
