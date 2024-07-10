class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int mod = 1000000007;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] == 1){
                list.add(i);
            }
        }
          if(list.size() < 1 ){
            return 0;
          }
           long result = 1;
           for(int i = 1 ; i< list.size() ; i++){
            int gap = list.get(i) - list.get(i - 1);
            result = (result * gap) % mod;
           }

           return (int)result;
    }
}