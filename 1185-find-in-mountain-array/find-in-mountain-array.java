/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int n = m.length()-1;
        int low = 0;
        int high = n;
        int peak = 0;
        while(low<=high){
            int mid= low + (high-low)/2;
            int midNum = m.get(mid);
            if(mid-1>=0 && midNum>m.get(mid-1)){
                peak = mid;
                low = mid + 1;
            }else high = mid-1;
        }
        low = 0; high = peak;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midNum = m.get(mid);
            if(midNum==target){
                return mid;
            }else if(midNum<target){
                low=mid+1;
            }else high = mid-1;
        }
        low = peak+1; high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midNum = m.get(mid);
            if(midNum==target){
                return mid;
            }else if(midNum<target){
                high=mid-1;
            }else low = mid+1;
        }
        return -1;
    }
}