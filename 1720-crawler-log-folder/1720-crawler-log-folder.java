class Solution {
    public int minOperations(String[] logs) {
        int depth =0;
        for(String num : logs){
            if(num.equals("../")){
                if(depth > 0){
                    depth--;
                }
            }
             else if(!(num.equals("./"))){
                depth++;
             }
        }
         return depth;
    }
}