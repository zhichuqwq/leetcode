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
