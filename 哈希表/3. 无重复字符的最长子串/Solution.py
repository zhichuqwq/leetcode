class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # dic 存储字符及其最近出现的位置，res 记录最长不重复子串的长度，i 记录当前不重复子串的左边界位置
        dic , res , i = {} , 0 , -1
        for j in range(len(s)):
            if s[j] in dic:
                i = max(dic[s[j]], i)  #更新左指针位置
            dic[s[j]] = j  #元素出现的下标记入哈希表
            res = max(res , j-i)# 更新最长不重复子串的长度
        return res

#哈希表和滑动窗口混合
