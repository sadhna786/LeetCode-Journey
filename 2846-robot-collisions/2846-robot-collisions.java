class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
       int n = positions.length;
       Integer[] indices = new Integer[n];
       for(int i =0 ; i< n ; i++){
        indices[i] = i;
       }
     
        Arrays.sort(indices , Comparator.comparingInt(i -> positions[i]));
       
    
        Stack<Integer> stack = new Stack<>();
        boolean[] isAlive = new boolean[n];
      
        Arrays.fill(isAlive , true);
      
       for(int i : indices){
        char dir = directions.charAt(i);
        if(dir == 'R'){
            stack.push(i);
        }
        else{
          while(!stack.isEmpty() && isAlive[stack.peek()]){
             int j = stack.peek();
              if(healths[j] > healths[i]){
                healths[j]--;
                isAlive[i] = false;
                break;
              }
               else if(healths[j] < healths[i]){
                healths[i]--;
                isAlive[stack.pop()] = false;
               }
               else{
                  isAlive[stack.pop()] = false;
                  isAlive[i] = false;
                  break;
               }
          }
        }
       }
         List<Integer> result = new ArrayList<>();
         for(int i = 0 ; i< n ; i++){
            if(isAlive[i]){
                result.add(healths[i]);
            }
         }
          return result;
    }
}