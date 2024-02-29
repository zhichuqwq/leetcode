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
