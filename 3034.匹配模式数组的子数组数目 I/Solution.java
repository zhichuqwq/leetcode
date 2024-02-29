class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int res = 0;
        int n = nums.length,m = pattern.length;
        for(int i = 0;i < n - m;i++){
            int a = i,b = 0;
            while(a < n && b <= m){
                if(b == m){
                    res++;
                    break;
                }
                if(pattern[b] == 1){
                    if(nums[a] >= nums[a + 1]){
                        break;
                    }
                }else if(pattern[b] == 0){
                    if(nums[a] != nums[a + 1]){
                        break;
                    }
                }else{
                    if(nums[a] <= nums[a + 1]){
                        break;
                    }
                }
                a++;
                b++;
            }
        }
        return res;
    }
}
