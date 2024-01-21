class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int plen = haystack.length();
        int[] next = new int[len];
        next[0] = 0;
        // 构建next数组，i = 1 j = 0开始
        for (int i = 1, j = 0; i < len; i++) {
            // 匹配失败的时候j=next[j-1]
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i] = j + 1;
                j++;
            }
        }
        // 匹配过程
        for (int i = 0, j = 0; i < plen; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == len) {
                return i - len + 1;
            }
        }
        return -1;
    }
}
