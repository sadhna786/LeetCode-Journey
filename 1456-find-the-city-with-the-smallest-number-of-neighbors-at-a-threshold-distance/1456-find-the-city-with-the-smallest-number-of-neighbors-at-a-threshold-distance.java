class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] num : dist){
            Arrays.fill(num , Integer.MAX_VALUE);
        }
         for(int i =0 ; i< n ; i++){
            dist[i][i] = 0;
         }
         for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
         }
         for(int k=0 ; k< n ; k++){
            for(int i=0 ; i< n ; i++){
                for(int j =0; j< n ; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
         }
              int minValue = Integer.MAX_VALUE;
              int result = -1;
              for(int i=0 ; i< n ;i++){
                 int count = 0;
                 for(int j=0 ; j< n; j++){
                    if(i != j && dist[i][j] <= distanceThreshold){
                        count++;
                    }
                 }
                  if(count <= minValue){
                    minValue = count;
                    result =i;
                  }
              }
              return result;
         
    }
}