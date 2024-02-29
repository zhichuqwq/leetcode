class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer , List<Integer>> mp = new HashMap<>();
        int n = nums.size(),res = n;
        for(int i = 0;i < n;i++){
            mp.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> list : mp.values()){
            int maxdis = list.get(0) + n - list.get(list.size() - 1);
            for(int i = 1;i < list.size();i++){
                maxdis = Math.max(maxdis , list.get(i) - list.get(i - 1));
            }
            res = Math.min(maxdis / 2,res);
        }
        return res;
    }
}
