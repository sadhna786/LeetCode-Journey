class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1){
            set1.add(num);
        }
         for(int num : nums2){
            set2.add(num);
         }
           Set<Integer> copySet1 = new HashSet<>(set1);
           Set<Integer> copySet2 = new HashSet<>(set2);

           copySet1.removeAll(set2);
           copySet2.removeAll(set1);

           List<Integer> list1 = new ArrayList<>(copySet1);
           List<Integer> list2 = new ArrayList<>(copySet2);

           List<List<Integer>> answer = new ArrayList<>();
           answer.add(list1);
           answer.add(list2);

           return answer;
     }
}