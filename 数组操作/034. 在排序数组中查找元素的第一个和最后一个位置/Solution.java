class Solution {
    public int[] searchRange(int[] nums, int target) {
        //分两次分别查找第一个等于target的数的数组下标和第一个大于target的数的数组下标
        int left = search(nums , target);
        int right = search(nums , target+1);
        if(left == nums.length || nums[left] != target){return new int[]{-1,-1};}
        return new int[]{left,right-1};
    }
    
    public int search(int[] nums , int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right)>>1;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
