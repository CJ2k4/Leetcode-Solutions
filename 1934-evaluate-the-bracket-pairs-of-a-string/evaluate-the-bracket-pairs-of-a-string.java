class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> ls: knowledge){
            map.put(ls.get(0), ls.get(1));
            System.out.println(ls.get(0));
            System.out.println(ls.get(1));
        }
        int i = 0;
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        while(i<n){
            if(s.charAt(i) == '('){
                StringBuilder temp = new StringBuilder();
                i++;
                while(i<n && s.charAt(i)!= ')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                System.out.print(temp);
                if(map.containsKey(temp.toString())){
                    ans.append(map.get(temp.toString()));
                }
                else ans.append('?');
            }else ans.append(s.charAt(i));
            i++;
        }
        return ans.toString();
    }
}