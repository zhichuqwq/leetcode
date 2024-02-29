class Solution {
    public int alternatingSubarray(int[] nums) {
        if(nums.length <= 1){return -1;}
        int res = -1,cur = 1;
        boolean flag = true;
        for(int i = 0,j = 1;j < nums.length;i++,j++){
            if(flag){
                if(nums[i]-nums[j] == -1){
                    cur++;
                    res = Math.max(res,cur);
                    flag = !flag;
                }else{
                    cur = 1;        
                }
            }else{
                if(nums[i]-nums[j] == 1){
                    cur++;
                    res = Math.max(res,cur); 
                }else{ 
                    i--;
                    j--;
                    cur = 1;   
                }
                flag = true;
            }
        }
        return res;
    }
}
