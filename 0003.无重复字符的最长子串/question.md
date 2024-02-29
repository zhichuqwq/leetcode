## 3. 无重复字符的最长子串

[ 无重复字符的最长子串 - 力扣（LeetCode）](https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/)



## 题目描述



```
给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```



## 思路

1. 使用两个指针 `i` 和 `j` 维护一个滑动窗口，表示当前不包含重复字符的子串。
2. `dic` 是一个哈希表，用于存储字符及其最近出现的位置。`res` 记录最长不重复子串的长度，初始值为 0，`i` 初始值为 -1。
3. 遍历字符串 `s`，对于每个字符 `s[j]`：
   - 如果 `s[j]` 已经在哈希表 `dic` 中，表示出现重复字符。需要更新左指针 `i`，将其移动到重复字符的下一位置，即 `max(dic[s[j]], i)`。
   - 更新哈希表 `dic`，将字符 `s[j]` 及其位置 `j` 存入。
   - 更新最长不重复子串的长度 `res`，取当前长度和历史最大长度的较大值。
4. 最终返回最长不重复子串的长度 `res`。



#### python code：

```python
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
```



#### 复杂度：

- 时间复杂度：O(n)
- 空间复杂度： O(min(n, m))