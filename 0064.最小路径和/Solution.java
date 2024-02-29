class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int min = 0;
        if(row == 1){
            for(int i = 0;i < col;i++){
                min += grid[0][i];
            }
            return min;
        }
        if(col == 1){
            for(int i = 0;i < row;i++){
                min += grid[i][0];
            }
            return min;
        }
        for(int i = row - 2;i > -1;i--){grid[i][col - 1] = grid[i + 1][col - 1] + grid[i][col - 1];}
        for(int i = col - 2;i > -1;i--){grid[row - 1][i] = grid[row - 1][i + 1] + grid[row - 1][i];}
        for(int i = row - 2;i > -1;i--){
            for(int j = col - 2;j > -1;j--){
                grid[i][j] = Math.min(grid[i + 1][j],grid[i][j + 1]) + grid[i][j];
            }
        }
        return grid[0][0];
    }
}
