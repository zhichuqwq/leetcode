class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0;i <= s.length()-1 ;i++){
            String s1 = searchre(s,i,i);
            String s2 = searchre(s,i,i+1);
            //分别查找最长回文串是单数和双数的情况
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
            }
        return ans;
        } 
    
    //双指针两边扩散寻找最长的回文串
    //修改这个函数让返回值为回文串起始位置下标和长度应该可以缩短函数的执行时间
    public String searchre(String s,int left,int right){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        //脱离循环后需要回退一步到满足条件的回文串，让left+1，right-1
        return s.substring(left+1 , right);
    }
}
