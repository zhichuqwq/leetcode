## 12. 整数转罗马数字

[ 整数转罗马数字](https://leetcode.cn/problems/integer-to-roman/)



## 题目描述

```
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。

示例：

输入: num = 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```



## 思路

- 哈希表记录罗马数字和整数，然后贪心算法每次从哈希表中取最大的数字
- 思路不变但是用两个数组模拟一下哈希表比单纯用哈希表操作好多了



#### java code：

```java
class Solution {
    public String intToRoman(int num) {
        //弱智了，用什么哈希表，直接两个数组对应不比这好
        /*HashMap<Integer,String> table = new LinkedHashMap<>();
        table.put(1000, "M");
        table.put(900, "CM");
        table.put(500, "D");
        table.put(400, "CD");
        table.put(100, "C");
        table.put(90, "XC");
        table.put(50, "L");
        table.put(40, "XL");
        table.put(10, "X");
        table.put(9, "IX");
        table.put(5, "V");
        table.put(4, "IV");
        table.put(1, "I");
        */
        StringBuilder res = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] keys = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i = 0;i < 13; i++){
            while(num >= values[i]){
                num -= values[i];
                res.append(keys[i]);
                if(num == 0){return res.toString();}
            }
        }
        return res.toString();
    }
}
```



#### 复杂度

- 时间复杂度：O(1)
- 空间复杂度：O(1)