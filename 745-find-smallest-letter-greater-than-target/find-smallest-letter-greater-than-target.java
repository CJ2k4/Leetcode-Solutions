class Solution {
    public char nextGreatestLetter(char[] l, char target) {
        int low= 0, high = l.length-1;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(l[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return l[ans];
    }
}