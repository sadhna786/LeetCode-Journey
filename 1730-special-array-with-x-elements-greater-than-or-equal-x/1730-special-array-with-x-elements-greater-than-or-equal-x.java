class Solution {
    public int specialArray(int[] nums) {
        for(int x =1 ; x <= nums.length ; x++){
            int count =0;
            for(int num : nums){
                if(num >= x){
                    count++;
                }
            }
             if(count == x){
                return count;
             }
        }
             return -1;
        
    }
}