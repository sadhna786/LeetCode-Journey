class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a' , 'e' , 'i' , 'o' ,'u'));
        int maxCount =0;
        for(int i=0 ; i< k ; i++){
            if(vowels.contains(s.charAt(i))){
                maxCount++;
            }
        }
          int currentCount = maxCount;
          for(int i= k ; i< s.length() ; i++){
             if(vowels.contains(s.charAt(i-k))){
                currentCount--;
             }
              if(vowels.contains(s.charAt(i))){
                currentCount++;
              }
                maxCount = Math.max(maxCount , currentCount);
          }
            return maxCount;
    }
}