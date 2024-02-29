## 63. 不同路径 II

[不同路径 II](https://leetcode.cn/problems/unique-paths-ii/)



## 题目描述

```
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。
```



#### java code

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row == 1 && col == 1 && obstacleGrid[0][0] == 0){return 1;}
        if(row == 1 && col == 1 && obstacleGrid[0][0] == 1){return 0;}
        if(obstacleGrid[row - 1][col - 1] == 1){return 0;}
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = 1;
        for(int i = row - 2;i > -1 ;i--){
            if(obstacleGrid[i][col - 1] == 0){
                dp[i][col - 1] = dp[i + 1][col - 1];
            }else{
                dp[i][col - 1] = 0;
            }
        }
        for(int i = col - 2;i > -1 ;i--){
            if(obstacleGrid[row - 1][i] == 0){
                dp[row - 1][i] = dp[row - 1][i + 1];
            }else{
                dp[row - 1][i] = 0;
            }
        }
        if(row > 1 || col > 1){
            for(int i = row - 2;i > -1 ;i--){
                for(int j = col - 2;j > -1;j--){
                    if(obstacleGrid[i][j] == 0){
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1]; 
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[0][0];
    }
}
```

