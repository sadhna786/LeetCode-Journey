class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] num : roads){
             degree[num[0]]++;
             degree[num[1]]++;
        }
         List<int[]> list = new ArrayList<>();
         for(int i=0 ; i< n ; i++){
            list.add(new int[] {i , degree[i]});
         }
          list.sort((a ,b) -> b[1] - a[1]);

          int[] values = new int[n];
          int value = n;
          for(int[] num : list){
             values[num[0]] = value--;
          }

           long total =0;
           for(int[] num : roads){
             total += values[num[0]] + values[num[1]];
           }

           return total;
    }
}