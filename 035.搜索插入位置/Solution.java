class Solution {
    public int searchInsert(int[] nums, int target) {
        //还是二分查找
        int left = 0 , right = nums.length-1;
        while(left < right){
            int mid = (left + right)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if(target <= nums[mid]){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        if(target <= nums[right]){return right;}
        else{return right+1;}
    }
}
