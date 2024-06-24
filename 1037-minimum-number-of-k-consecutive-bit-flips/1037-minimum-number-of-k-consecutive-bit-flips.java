class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips =0;
        int result = 0;

        for(int i = 0 ; i< n ; ++i){
            if(i >= k && nums[i-k] == 2){
                --flips;
            }
             if(nums[i] == flips % 2){
                if(i + k > n) return -1;
                ++result;
                ++flips;
                nums[i] =2;
             }
        }
          return result;
    }
}