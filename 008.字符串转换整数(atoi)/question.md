## 8. 字符串转换整数 (atoi)

[8. 字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/)



## 题目描述

请你来实现一个 `myAtoi(string s)` 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 `atoi` 函数）。

函数 `myAtoi(string s)` 的算法如下：

1. 读入字符串并丢弃无用的前导空格
2. 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
3. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
4. 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 `0` 。必要时更改符号（从步骤 2 开始）。
5. 如果整数数超过 32 位有符号整数范围 `[−231, 231 − 1]` ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 `−231` 的整数应该被固定为 `−231` ，大于 `231 − 1` 的整数应该被固定为 `231 − 1` 。
6. 返回整数作为最终结果。

**注意：**

- 本题中的空白字符只包括空格字符 `' '` 。
- 除前导空格或数字后的其余字符串外，**请勿忽略** 任何其他字符。



## 思路

- 这题最简单的办法就是跟着C/C++里的myAtoi(string s)函数实现思路来做，自己作出来的其他办法很容易遇到各种没料想过的输入，最开始的想法是记录第一个‘+’‘-’的位置和第一个为1-9整数的位置和第一个不为0-9的位置，但是遇到各种问题直接变成面对测试用例编程了，代码越改越长，改不下去了还是换了他的思路
- 出的测试样例真挺离谱，我猜到会有int的边界值，没想到还测了long的边界值，然后提前了溢出检测



#### java code：

```java
class Solution {
    public int myAtoi(String s) {
        //去除前面的空格
        s = s.trim();
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int p = 1;
        //查找第一个'+''-'并且改变符号位
        int start = 0;
        if(s.charAt(0) == '-'){
            start = 1;
            p = -1;
        }else if(s.charAt(0) == '+'){
            start = 1;
        }
        long res = 0;
        char[] Digit = {'0','1','2','3','4','5','6','7','8','9'};
        //读取数字部分
        for(int i = start;i <= s.length()-1; i++){
            char c = s.charAt(i);
            if(!isDigit(Digit,s.charAt(i))){
                break;
            }
            res = res * 10 + (c - '0');
            //数字超过了int的保存范围就及时终止计入，避免超过Long的保存范围，如果超过了int的保存范围，强制转换的结果和原值会不同
            if((int)res != res){break;}
        }
        if ((int)res != res){return p == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;}
        return (int) res*p;
    }

    public boolean isDigit(char[] digit,char c){
        for(char z : digit){
            if(c == z){return true;}
        }
        return false;
    }
}
```



#### 复杂度

- 时间复杂度：O(N)
- 空间复杂度：O(1)