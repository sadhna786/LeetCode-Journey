class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int i=0 ; i< nums.length ; i++){
            unique.add(nums[i]);
        }
         if(unique.size() == nums.length){
            return false;
         }
          return true;
    }
}