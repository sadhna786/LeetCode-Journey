class Solution {
    public double averageWaitingTime(int[][] customers) {
        int current = 0;
        double result =0;
        for(int[] num : customers){
            int arrival = num[0];
            int prep = num[1];

            if(current < arrival){
                current = arrival;
            }
            current += prep;
          result += current - arrival; 
        }
         return result / customers.length;
    }
}