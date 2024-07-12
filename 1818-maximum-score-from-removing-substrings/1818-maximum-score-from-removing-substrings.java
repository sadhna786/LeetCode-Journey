class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
         return  findScore1(s , 'a' , 'b' , x , 'b' , 'a' , y) ;
        }
        else{
           return findScore1(s , 'b' , 'a' , y , 'a' , 'b' , x) ;
        }
    }
     public static int findScore1(String s ,  char first1 ,  char second1 , int point1 , char first2 , char second2 , int point2){
         int score =0;
         StringBuilder sb = new StringBuilder(s);
         score += findScore2(sb , first1 , second1 , point1);
         score += findScore2(sb , first2 , second2 , point2);

         return score;
     }

     public static int findScore2(StringBuilder sb ,char first , char second , int point){
          int score =0;
        
          for(int i=0 ; i< sb.length() -1 ; ){
            if(sb.charAt(i) == first && sb.charAt(i+1) == second){
                sb.delete(i , i+2);
                score += point;
                if(i > 0){
                    i--;
                }
            }
                else{
                    i++;
                }
            }
          return score;
     }
}