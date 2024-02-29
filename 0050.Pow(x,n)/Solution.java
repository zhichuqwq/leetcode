class Solution {
    public double myPow(double x, int n) {
        if(n == 0){return 1;}
        if(n == 1){return x;}
        if(n == -1){return 1 / x;}
        if(n % 2 == 0){
            double half = myPow(x, n / 2);
            return half * half;
        }else{
            double half = myPow(x, (n - 1) / 2);
            return half * half * x;
        }
    }
}
