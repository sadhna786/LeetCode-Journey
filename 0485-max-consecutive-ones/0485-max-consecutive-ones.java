class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int maxCount = Integer.MIN_VALUE;
        for(int i=0 ; i< nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else if(nums[i] == 0){
             maxCount = Math.max(maxCount , count);
                count =0;
            }
        }
          maxCount = Math.max(maxCount , count);
          return maxCount;
    }
}