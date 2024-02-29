## 1686. 石子游戏 VI

[石子游戏 VI](https://leetcode.cn/problems/stone-game-vi/)



## 题目描述

```
Alice 和 Bob 轮流玩一个游戏，Alice 先手。

一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。

给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。

所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。

请你推断游戏的结果，用如下的方式表示：

如果 Alice 赢，返回 1 。
如果 Bob 赢，返回 -1 。
如果游戏平局，返回 0 。
```



#### java code

```java
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
```

