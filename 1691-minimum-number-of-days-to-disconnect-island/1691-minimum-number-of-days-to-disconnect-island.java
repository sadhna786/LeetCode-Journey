class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(countIsland(grid) != 1){
            return 0;
        }
        for(int i=0 ; i< m ; i++){
            for(int j=0 ; j< n ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(countIsland(grid) != 1){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
             
        }
          for(int i=0 ; i< m ; i++){
            for(int j=0 ; j< n ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;

                    for(int x =0 ; x< m ; x++){
                        for(int y =0 ; y< n ; y++){
                            if(grid[x][y] == 1){
                                grid[x][y] = 0;

                                if(countIsland(grid) != 1){
                                    return 2;
                                }
                                grid[x][y] = 1;
                            }
                        }
                    }
                      grid[i][j] = 1;
                }
            }
          }
            return 2;
    }
      public int countIsland(int[][] grid){
         int m = grid.length;
         int n = grid[0].length;
         boolean[][] visited = new boolean[m][n];
         int count =0;

         for(int i =0 ; i< m ; i++){
            for(int j= 0 ; j< n ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid , visited , i , j);
                    count++;
                }
            }
         }
          return count;
      }

      public void dfs(int[][] grid , boolean[][] visited , int m , int n){
         int r = grid.length;
         int c = grid[0].length;
         if(m < 0 || m >= r || n < 0 || n >= c || grid[m][n] == 0 || visited[m][n]){
            return ;
         }
           visited[m][n] = true;
           dfs(grid , visited , m+1 , n);
           dfs(grid , visited , m - 1 , n);
           dfs(grid , visited , m , n + 1);
           dfs(grid , visited , m , n - 1);
      }
}