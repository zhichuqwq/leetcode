class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 999999;

        for(int i = 0; i < len; i++){
            if(i > 0  && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, z = len -1;
            while(j < z){
                int sum = nums[i] + nums[j] + nums[z];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target)< Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    z--;
                    while(nums[z] == nums[z+1] && j < z){
                        z--;
                    }
                }else{
                    j++;
                    while(nums[j] == nums[j-1] && j < z){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
