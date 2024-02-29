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
