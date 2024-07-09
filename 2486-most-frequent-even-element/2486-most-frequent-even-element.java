class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            if(num % 2 == 0){
                map.put(num , map.getOrDefault(num , 0) + 1);
            }
        }
         int evenKey = -1;
         int freq =0;

         for(Map.Entry<Integer , Integer> entry : map.entrySet() ){
             int key = entry.getKey();
             int value = entry.getValue();

             if(value > freq || (value == freq && key < evenKey)){
                 evenKey = key;
                 freq = value;
             }
         }
           return evenKey;
    }
}