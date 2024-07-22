class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
      Map<Integer , String> map = new HashMap<>();
      int n = names.length;
      for(int i =0 ; i< n ; i++){
         map.put(heights[i] , names[i]);
      } 
       Integer[] sortedHeight = new Integer[n];
       for(int i =0 ; i< n  ;i++){
        sortedHeight[i] = heights[i];
       }
       Arrays.sort(sortedHeight , Collections.reverseOrder());
       
       String[] result = new String[n];
       for(int i=0 ; i< n ;i++){
          result[i] = map.get(sortedHeight[i]);
       }

        return result;
  }
}