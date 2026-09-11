class Solution {
    public int totalNumbers(int[] digits) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: digits){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int ans=0;
        for(int i = 100; i<1000; i+=2){
            int temp = i;
            Map<Integer, Integer> tempMap = new HashMap<>(map);
            boolean possible = true;
            while(temp!=0){
                if(tempMap.containsKey(temp%10)){
                    tempMap.put(temp%10, tempMap.get(temp%10)-1);
                    if(tempMap.get(temp%10) == 0)tempMap.remove(temp%10);
                }else{
                    possible = false;
                    break;
                }
                temp/=10;
            }
            if(possible)ans++;
        }
        return ans;
    }
}