class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();
        for(int i=0 ; i< matrix.length ; i++){
            int minValue = matrix[i][0];
            int minIndex =0;
            for(int j = 1 ; j< matrix[i].length ; j++){
                if(matrix[i][j] < minValue){
                    minValue = matrix[i][j];
                    minIndex = j;
                }
            }
              boolean isMax = true;
             for(int j = 0 ; j< matrix.length ; j++){
                 if(matrix[j][minIndex] > minValue){
                    isMax = false;
                    break;
                 }
             }
              if(isMax){
                lucky.add(minValue);
              }
        }
         return lucky;
    }
}