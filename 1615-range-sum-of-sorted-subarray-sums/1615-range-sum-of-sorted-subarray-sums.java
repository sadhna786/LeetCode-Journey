class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i< n ; i++){
            int currSum =0;
            for(int j= i ; j< n ; j++){
                currSum += nums[j];
                result.add(currSum);
            }
        }
         Collections.sort(result);

         long sum =0;
         for(int i=left -1 ; i< right ; i++){
             sum = (sum +result.get(i)) % MOD;
         }
          return (int) sum;

    }
}