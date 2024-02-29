class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer,Integer> front = new HashMap<>();
        HashMap<Integer,Integer> behind = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            if(!behind.containsKey(nums[i])){
                behind.put(nums[i],1);
            }else{
                behind.put(nums[i],behind.get(nums[i]) + 1);
            }
        }
        for(int i = 0;i < n;i++){
            if(!front.containsKey(nums[i])){
                front.put(nums[i],1);
            }else{
                front.put(nums[i],front.get(nums[i]) + 1);
            }
            behind.put(nums[i],behind.get(nums[i]) - 1);
            if(behind.get(nums[i]) == 0){behind.remove(nums[i]);}
            res[i] = front.size() - behind.size();
        }
        return res;
    }
}
