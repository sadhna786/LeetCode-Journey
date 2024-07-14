class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String , Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        for(int i =0 ; i< n ;){
            char ch = formula.charAt(i);
            if(ch == '('){
                stack.push(new HashMap<>());
                i++;
            }
            else if(ch == ')'){
                int j = i + 1;
                int count =0;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    count = count * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                count = count == 0 ? 1 : count;
                Map<String , Integer> top = stack.pop();
                Map<String , Integer> curr = stack.peek();
                for(String key : top.keySet()){
                    curr.put(key , curr.getOrDefault(key , 0) + top.get(key) * count);
                }
                i = j;
            }
            else{
                int j = i + 1;
                while(j < n && Character.isLowerCase(formula.charAt(j))){
                    j++;
                }
                String atom = formula.substring(i , j);
                i = j;
              int  count =0;
                while(j < n && Character.isDigit(formula.charAt(j))){
                    count = count * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                  count = count == 0 ? 1 : count;
                 Map<String , Integer> curr = stack.peek();
                curr.put(atom, curr.getOrDefault(atom, 0) + count);
                i = j;
            }
        }
           Map<String , Integer> result = stack.pop();
           TreeMap<String , Integer> finalResult = new TreeMap<>(result);
           StringBuilder sb = new StringBuilder();
           for(String key : finalResult.keySet()){
            sb.append(key);
            int count = finalResult.get(key);
            if(count > 1){
                sb.append(count);
            }
           }

           return sb.toString();
    }

}