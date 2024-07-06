class Solution {
    public int passThePillow(int n, int time) {
        int totalCycle = 2 * (n-1);
        int remTime = time % totalCycle;
        if(remTime < n){
            return remTime + 1;
        }
         else {
            return 2 * n - remTime -1;
         }
    }
}