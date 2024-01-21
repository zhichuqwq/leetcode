class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len-2;i >= 0;i--){
            //1、从右到左找到第一个逆序对（nums[i] < nums[i+1]）。
            if(nums[i]<nums[i+1]){
                for(int j = len-1;j > i;j--){
                    //2、从右到左找到第一个大于 nums[i] 的数字。
                    if(nums[i]<nums[j]){
                        //3、交换这两个数字。
                        int z = nums[i];
                        nums[i] = nums[j];
                        nums[j] = z;
                        //4、反转从 i+1 到末尾的子数组。
                        int right = len - 1,left = i + 1;
                        while(right>left){
                            z = nums[left];
                            nums[left] = nums[right];
                            nums[right] = z;
                            right--;
                            left++;
                        }
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
