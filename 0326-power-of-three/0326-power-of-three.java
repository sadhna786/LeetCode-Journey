class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 0){
            return false;
        }
        double max = Math.pow(3 , 19);
         return max % n == 0;
    }
}