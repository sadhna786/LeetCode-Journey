class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] newGrid = new int[n * 3][n * 3];
        
        for(int r=0 ; r < n ; r++){
            for(int c =0 ; c < n ; c++){
                char ch = grid[r].charAt(c);
                if(ch == '/'){
                    newGrid[r * 3][c * 3 + 2] = 1;
                    newGrid[r * 3 + 1][c * 3 + 1] = 1;
                    newGrid[r * 3 + 2][c * 3] = 1;
                }
                else if(ch == '\\'){
                     newGrid[r * 3][c * 3] = 1;
                    newGrid[r * 3 + 1][c * 3 + 1] = 1;
                    newGrid[r * 3 + 2][c * 3 + 2] = 1;
                }
            }
        }
          int res =0;
          for(int r =0; r < n*3 ; r++){
            for(int c =0 ; c < n * 3 ; c++){
                if(newGrid[r][c] == 0){
                    res++;
                    dfs(newGrid , r ,c , n*3);
                }
            }
          }
            return res;
    }
           public void dfs(int[][] grid , int r , int c , int n){
             if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 1){
                return;
             }
             grid[r][c] =1;
             dfs(grid , r + 1 , c , n);
             dfs(grid , r -1 , c , n);
             dfs(grid , r , c+1 , n);
             dfs(grid , r , c -1 , n);
          }
    
}