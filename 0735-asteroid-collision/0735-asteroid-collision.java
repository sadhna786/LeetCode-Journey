class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
   
        for( int num : asteroids){
            boolean flag = false;
            while(!stack.isEmpty() && num < 0 && stack.peek() > 0){
                if(Math.abs(num) > stack.peek()){
                    stack.pop();
                    continue;
                }
             else if(Math.abs(num) == stack.peek()){
                 stack.pop();
                
             }
               flag = true;
               break;
            }
             if(!flag){
                stack.push(num);
            
             }
            
        }
          int[] result = new int[stack.size()];
          for(int i = result.length -1 ; i >= 0 ; i--){
             result[i] = stack.pop();
          }
           return result;
    }
}