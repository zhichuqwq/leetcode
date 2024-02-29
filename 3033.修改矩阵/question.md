## 3033. 修改矩阵

[修改矩阵](https://leetcode.cn/problems/modify-the-matrix/)



## 题目描述

```
给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。

返回矩阵 answer 。
```



#### java code

```java
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length,col = matrix[0].length;
        int[] colmax = new int[col];
        int[][] res = new int[row][col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                colmax[j] = Math.max(matrix[i][j] , colmax[j]);
                res[i][j] = matrix[i][j];
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(res[i][j] == -1){
                    res[i][j] = colmax[j];
                }
            }
        }
        return res;
    }
}
```

