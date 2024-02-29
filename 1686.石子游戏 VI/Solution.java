class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        List<int[]> valuescot = new ArrayList<>();
        for(int i = 0;i < n;i++){
            valuescot.add(new int[] {aliceValues[i] + bobValues[i], aliceValues[i] , bobValues[i]});
        }
        Collections.sort(valuescot,(a ,b) -> Integer.compare(b[0],a[0]));
        int alice = 0,bob = 0;
        for(int i = 0;i < n ;i++){
            if(i % 2 == 0){
                alice += valuescot.get(i)[1];
            }else{
                bob += valuescot.get(i)[2];
            }
        }
        return Integer.compare(alice,bob);
    }
}
