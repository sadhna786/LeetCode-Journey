class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
         Map<Character , Integer> freq1 = new HashMap<>();
         Map<Character , Integer> freq2 = new HashMap<>();

         for(char c : word1.toCharArray()){
            freq1.put(c , freq1.getOrDefault(c ,0) + 1);
         } 
          
         for(char c : word2.toCharArray()){
            freq2.put(c , freq2.getOrDefault(c ,0) + 1);
         } 

          if(!freq1.keySet().equals(freq2.keySet())){
            return false;
          }
           
          Map<Integer , Integer> count1 = new HashMap<>();
          Map<Integer , Integer> count2 = new HashMap<>();

          for(int c : freq1.values()){
             count1.put(c , count1.getOrDefault(c ,0) + 1);

          }
           for(int c : freq2.values()){
             count2.put(c , count2.getOrDefault(c ,0) + 1);

          }
           return count1.equals(count2);
    }
}