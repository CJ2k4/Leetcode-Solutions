class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;

        int maxVal = nums[0];
        for(int i : nums)maxVal = Math.max(maxVal, i);

        int[] divisorFreq = new int[maxVal+1];
        
        for(int i = 0; i<n; i++){
            int num = nums[i];

            for(int j = 1; j*j<=num; j++){
                if(num%j==0){
                    divisorFreq[j]++;
                    if(num/j != j)
                        divisorFreq[num/j]++;
                }
            }
        }

        long[] pairsWithGcd = new long[maxVal+1];
        for(int g = maxVal; g>0; g--){
            long count = divisorFreq[g];
            pairsWithGcd[g] = count*(count-1)/2;

            for(int mul = 2*g; mul<=maxVal; mul+=g){
                pairsWithGcd[g]-= pairsWithGcd[mul];
            }
        }

        long[] prefixSum = new long[maxVal + 1];
        for(int g = 1; g<=maxVal; g++){
            prefixSum[g] = prefixSum[g-1] + pairsWithGcd[g];
        }

        int[] res = new int[queries.length];
        for(int i = 0 ; i<queries.length; i++){
            int l = 1;
            int r = maxVal; 
            int temp = 1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(prefixSum[mid]>queries[i]){
                    temp = mid;
                    r = mid-1;
                }else l=mid+1;
            }
            res[i] = temp;
        }

        return res;
    }
}