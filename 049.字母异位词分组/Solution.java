class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res = new HashMap<>();
        for(String s : strs){
            String code = codeP(s);
            res.putIfAbsent(code, new LinkedList<>());
            res.get(code).add(s);
        }
        List<List<String>> rres = new LinkedList<>();
        for(List<String> group : res.values()){
            rres.add(group);
        }
        return rres;
    }

    public String codeP(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int num = c - 'a';
            count[num]++;
        }
        return new String(count);
    }
}
