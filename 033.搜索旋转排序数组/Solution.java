class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            //0到mid一侧为有序排列的一侧
            if(nums[0] <= nums[mid]){
                //target在有序的一侧时，更新右指针
                if(nums[mid] > target && target >= nums[0]){
                    right = mid - 1;
                }
                //target在无序的一侧时，更新左指针
                else{
                    left = mid + 1;
                }
            }
            //mid到nums.length-1的一侧有序
            else{
                //target在有序的一侧时，更新左指针
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }
                //target在无序的一侧时，更新右指针
                else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
