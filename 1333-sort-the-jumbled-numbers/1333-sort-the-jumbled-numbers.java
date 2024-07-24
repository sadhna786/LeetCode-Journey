class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
        .boxed()
        .sorted((a , b) ->{
        long mappedA = getMapping(a , mapping);
        long mappedB = getMapping(b , mapping);
          return Long.compare(mappedA , mappedB);
        })
        .mapToInt(i -> i)
        .toArray();
    }
      public static Long getMapping(int num , int[] mapping){
         StringBuilder result = new StringBuilder();
         String str = String.valueOf(num);
         for(char c : str.toCharArray()){
            int digit = c - '0';
            result.append(mapping[digit]);
         }
         return Long.parseLong(result.toString());
          
      }
}