class Solution {
    public int countSegments(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        else{
        String[] segment = s.split("\\s+");
        int count =0;
        for(String seg : segment){
            if(!seg.isEmpty()){
                count++;
            }
        }
          return count;
    }
    }
}