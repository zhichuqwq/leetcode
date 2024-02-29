class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int i = 0;i < nums.size(); i++){
            if(bitCount(i) == k){
                res += nums.get(i);
            }
        }
        return res;
    }

    public int bitCount(int i){
        int res = 0;
        while(i != 0){
            res += (i % 2);
            i /= 2;
        }
        return res;
    }
}
