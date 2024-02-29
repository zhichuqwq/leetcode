## 50. Pow(x, n)

[Pow(x, n)](https://leetcode.cn/problems/powx-n/)



## 题目描述

```
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
```



#### java code

```java
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
```

