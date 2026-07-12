class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // TreeSet<Integer> set = new TreeSet<>();
        // for(int i : arr){
        //     set.add(i);
        // }
        // for(int i = 0; i<arr.length; i++){
        //     arr[i] = set.headSet(arr[i]).size()+1;
        // }
        // return arr;
        int[] copy = java.util.Arrays.stream(arr).sorted().toArray();
        Map<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(copy[i]))continue;
            hm.put(copy[i],rank++);
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = hm.get(arr[i]);
        }
        return arr;

    }
}