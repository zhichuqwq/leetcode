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
