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
