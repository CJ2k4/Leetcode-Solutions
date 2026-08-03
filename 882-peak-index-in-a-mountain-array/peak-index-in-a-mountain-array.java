class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = 0;
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>arr[max]){
                max = mid;
            }
            if(mid+1<n && arr[mid+1]>arr[mid])low= mid+1;
            else high = mid-1;
        }
        return max;
    }
}