/*
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length(),llen = s.length();
        char[] comp = code(p);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < llen - len + 1;i++){
            String ss = s.substring(i , i + len);
            char[] sss = code(ss);
            if(Arrays.equals(sss,comp)){
                res.add(i);
            }
        }
        return res;
    }

    public char[] code(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int i = c - 'a';
            count[i]++;
        }
        return count;
    }
}
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
