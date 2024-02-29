## 2861. 最大合金数

[最大合金数](https://leetcode.cn/problems/maximum-number-of-alloys/)



## 题目描述

```
假设你是一家合金制造公司的老板，你的公司使用多种金属来制造合金。现在共有 n 种不同类型的金属可以使用，并且你可以使用 k 台机器来制造合金。每台机器都需要特定数量的每种金属来创建合金。

对于第 i 台机器而言，创建合金需要 composition[i][j] 份 j 类型金属。最初，你拥有 stock[i] 份 i 类型金属，而每购入一份 i 类型金属需要花费 cost[i] 的金钱。

给你整数 n、k、budget，下标从 1 开始的二维数组 composition，两个下标从 1 开始的数组 stock 和 cost，请你在预算不超过 budget 金钱的前提下，最大化 公司制造合金的数量。

所有合金都需要由同一台机器制造。

返回公司可以制造的最大合金数。
```



#### java code

```java
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
```

