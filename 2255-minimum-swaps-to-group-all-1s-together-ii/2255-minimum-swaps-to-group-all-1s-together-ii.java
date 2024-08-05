class Solution {
    public int minSwaps(int[] nums) {
        int totalOne = 0;
        for(int num : nums){
            if(num == 1){
                totalOne++;
            }
        }
         if(totalOne == 0 || totalOne == nums.length){
            return 0;
         }
         int n = nums.length;
         int[] extended = new int[2 * n];
         for(int i =0 ; i< n ; i++){
            extended[i] = nums[i];
            extended[n + i] = nums[i];
         }
          int minZeros = Integer.MAX_VALUE;
          int zeros =0;
         for(int i=0 ; i< totalOne ; i++){
            if(extended[i] == 0){
                zeros++;
            }
         }
          minZeros = zeros;
         for(int i=1 ; i< n ; i++){
            if(extended[i -1] == 0) zeros--;
            if(extended[i + totalOne - 1] == 0) zeros++;
            minZeros = Math.min(minZeros , zeros);
         }

         return minZeros;
    }
}