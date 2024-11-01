class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
       int index =0;
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] != index){
                return index;
            }
            else{
                index++;
            }
        }
         return index++;
    }
}