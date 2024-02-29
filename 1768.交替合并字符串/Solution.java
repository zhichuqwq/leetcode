class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1array = word1.toCharArray();
        char[] word2array = word2.toCharArray();
        StringBuilder res = new StringBuilder();
        int m = word1array.length,n = word2array.length;
        int i = 0, j = 0;
        while(i < m || j < n){
            if(i < m){
                res.append(word1array[i]);
                i++;
            }
            if(j < n){
                res.append(word2array[j]);
                j++;
            }
        }
        return res.toString();
    }
}
