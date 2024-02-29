class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int res = 0;
        for(int i : set){
            if(set.contains(i - 1)){
                continue;
            }
            int cur = i;
            int len = 1;
            while(set.contains(cur + 1)){
                cur++;
                len++;
            }
            res = Math.max(len , res);
        }
        return res;
    }
}
