class Solution {
    public int findDuplicate(int[] nums) {
       Set<Integer> duplicate = new HashSet<>();
       for(int num : nums){
         if(duplicate.contains(num)){
            return num;
         }
          duplicate.add(num);
       }
        return -1;
    }
}
    
