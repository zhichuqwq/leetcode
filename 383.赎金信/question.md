## [383. 赎金信](https://leetcode.cn/problems/ransom-note/)

[383. 赎金信](https://leetcode.cn/problems/ransom-note/)



## 题目描述

```
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。
```



#### python code

```python
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        dict1 = Counter(magazine)
        for i in ransomNote:
            dict1[i] -= 1
            if dict1[i] < 0:
                return False
        return True
```

