class Solution {
    public int removeElement(int[] nums, int val) {
        int unique = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] != val){
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }
}
