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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        int n = arr.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr.get(i); // 转成数组，效率更高
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size()); // 预分配空间
        for (int q : queries) {
            int j = lowerBound(a, q);
            int mx = j == n ? -1 : a[j];
            if (j == n || a[j] != q) { // a[j]>q, a[j-1]<q
                j--;
            }
            int mn = j < 0 ? -1 : a[j];
            ans.add(List.of(mn, mx));
        }
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> a) {
        if (node == null) {
            return;
        }
        dfs(node.left, a);
        a.add(node.val);
        dfs(node.right, a);
    }

    private int lowerBound(int[] a, int target) {
        int left = -1, right = a.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1; // 比 /2 快
            if (a[mid] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
