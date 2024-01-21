## 6. Z 字形变换

[Z 字形变换](https://leetcode.cn/problems/zigzag-conversion/)



## 题目描述

```
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例 ：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```



## 思路

1. 创建一个长度为 numRows 的 StringBuilder 数组，数组的每个元素都用于保存每一行的字符。
2. 使用一个循环遍历输入字符串 s 中的每个字符。在循环中，将字符逐个添加到对应行的 StringBuilder 中。
3. 使用变量 `flag` 记录当前字符的添加方向。初始值为 -1，当到达第一行或最后一行时，方向反转。
4. 将每行的 StringBuilder 拼接起来，得到最终的结果字符串。



#### java code：

```java
class Solution {
    public String convert(String s, int numRows) {
        //一行的情况直接返回
        if(numRows <= 1){return s;}
        //用StringBuilder缩短程序执行时间，该题目相当于来回扫描字符串数组，将输入字符串输入数组，然后将所有字符串数组拼接输出
        StringBuilder[] stringList =new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringList[i] = new StringBuilder();
        }
        //flag记录是否扫描到了第一个和最后一个字符串数组，实现转向
        int flag = -1;
        int n = 0;
        for(char c : s.toCharArray()){
            stringList[n].append(c);
            //到头转向
            if(n == 0||n == numRows - 1){
                flag = -flag;
            }
            n += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder str : stringList) {
            result.append(str);
        }
        return result.toString();
    }
}
```



#### 复杂度

- 时间复杂度：O(N)
- 空间复杂度：O(numRows)