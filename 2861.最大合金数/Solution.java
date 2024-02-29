class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 0,right = 200000000;
        int res = 0;
        while(left <= right){
            int mid = (left + right)/2;
            boolean flag = false;
            outerLoop:
            for(int i = 0;i < k;i++){
                long pay = 0;
                for(int j = 0;j < n;j++){
                    pay += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                if(pay <= budget){
                    flag = !flag;
                    break;
                }
            }
            if(flag){
                left = mid + 1;
                res = mid;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
