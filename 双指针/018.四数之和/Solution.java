class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //最外层循环，确定第一个数的位置
        for(int s = 0; s < len ; s++){
            //如果第一个数已经大于目标值，没有继续循环的必要，直接返回
            if(nums[s]>0&&nums[s]>target){
                Set<List<Integer>> uniqueTuples = new HashSet<>(res);
                res = new ArrayList<>(uniqueTuples);
                return res;
            }
            //如果第一个数和后三个数的和(升序数组，这四个数的和就是以s为第一个数和的最小值)大于目标值，直接返回
            if(s+3<len&&(long)nums[s]+nums[s+1]+nums[s+2]+nums[s+3]>target){
                continue;
            }
            //如果第一个数和最后三个数的和小于目标值，直接返回
            if(len-3>=0&&(long)nums[s]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }
            //循环确定第二个数的位置
            for(int i = s + 1; i < len; i++){
                int j = i + 1, z = len -1;
                while(j < z){
                    long sum = (long)nums[s] + nums[i] + nums[j] + nums[z];
                    if(sum == target){
                        List<Integer> tuple1 = new ArrayList<>(List.of(nums[s],nums[i],nums[j],nums[z]));
                        res.add(tuple1);
                    }
                    //根据和与目标值大小比较确定更新那个指针
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
        }
        Set<List<Integer>> uniqueTuples = new HashSet<>(res);
        res = new ArrayList<>(uniqueTuples);
        return res;
    }
}
