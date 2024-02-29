class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){return res;}
        for(int mark = 0;mark < nums.length - 2 ;mark++){
            if(nums[mark] > 0){
                break;
            }
            if (mark > 0 && nums[mark] == nums[mark - 1]) {
                continue; // 跳过重复元素
            }
            int left = mark + 1,right = nums.length - 1;
            int sum = 0,target = -nums[mark];
            while(left < right){
                sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[mark], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
