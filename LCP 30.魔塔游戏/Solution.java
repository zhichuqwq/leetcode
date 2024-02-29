class Solution {
    public int magicTower(int[] nums) {
        int sum = 1;
        for(int num : nums){
            sum += num;
        }
        if(sum <= 0){return -1;}
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        long cot = 1,negativecot = 0;
        int n = nums.length,step = 0;
        for(int i = 0;i < n; i++){
            if(nums[i] < 0){
                negative.offer(nums[i]);
            }
            cot += nums[i];
            if(cot <= 0){
                int cur = negative.poll();
                cot -= cur;
                negativecot += cur;
                step++;
            }
        }
        cot += negativecot;
        return cot <= 0 ? -1 : step;
    }
}
