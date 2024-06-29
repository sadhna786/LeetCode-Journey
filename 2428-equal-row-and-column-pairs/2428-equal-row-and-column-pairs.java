class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String , Integer> map = new HashMap<>();
        for(int i=0 ; i< n ; i++){
            String rowString = Arrays.toString(grid[i]);
            map.put(rowString , map.getOrDefault(rowString , 0) + 1);
        }
         int count =0;
         for(int j =0; j < n ; j++){
             int[] column = new int[n];
            for(int i=0 ; i< n ; i++){
               column[i] = grid[i][j];
            }
            String columnString = Arrays.toString(column);
            if(map.containsKey(columnString)){
                count += map.get(columnString);
            }
         }
            return count;
    }
}