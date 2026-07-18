class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        // List<List<String>> ans = new ArrayList<>();
        for(String s : strs){
            int[] count= new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26; i++){
                if(count[i]>0){
                    sb.append(count[i]);
                    sb.append((char)('a' + i));
                }
            }
            if(hm.containsKey(sb.toString())){
                hm.get(sb.toString()).add(s);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                hm.put(sb.toString(), temp);
            }
        }
        return new ArrayList<>(hm.values());
    }
}