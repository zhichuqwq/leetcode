class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0;i < strs[0].length();i++){
            for(int j = 1;j < strs.length;j++){
                if(i >= strs[j].length() || i >= strs[j-1].length() || strs[j].charAt(i) != strs[j-1].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
