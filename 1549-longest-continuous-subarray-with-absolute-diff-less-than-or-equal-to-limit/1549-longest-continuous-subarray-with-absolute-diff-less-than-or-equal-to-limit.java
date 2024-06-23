class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left =0;
        int maxlen =0;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for(int right = 0 ; right < n ; right++){
            while(!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()){
                maxDeque.pollLast();
            }
              maxDeque.addLast(nums[right]);

              while(!minDeque.isEmpty() && nums[right] < minDeque.peekLast()){
                minDeque.pollLast();
              }
               minDeque.addLast(nums[right]);

               while(maxDeque.peekFirst() - minDeque.peekFirst() > limit){
                 if(nums[left] == maxDeque.peekFirst()){
                    maxDeque.pollFirst();
                 }
                   if(nums[left] == minDeque.peekFirst()){
                    minDeque.pollFirst();
                   }
                   left++;
               }
               maxlen = Math.max(maxlen , right - left +1);
        }
          return maxlen;
    }
}