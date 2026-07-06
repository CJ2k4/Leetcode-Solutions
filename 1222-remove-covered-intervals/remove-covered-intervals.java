class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Deque<int[]> st = new ArrayDeque<>();

        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for(int[] i : intervals){
            boolean flag = false;
            while(!st.isEmpty() && st.peek()[0] <= i[0] && st.peek()[1]>=i[1]){
                flag = true;
                break;
            }
            if(flag)continue;
            st.push(i);
        }
        return st.size();
    }
}