class Solution {
        public static String[] less_than_20 = {"Zero","One" , "Two" , "Three" , "Four" , "Five" , "Six" , "Seven",
         "Eight" , "Nine" , "Ten" , "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen",
         "Seventeen" , "Eighteen" , "Nineteen"};

         public static String[] tens = {"","","Twenty" , "Thirty","Forty", "Fifty" , "Sixty" , "Seventy" ,
         "Eighty" , "Ninety"};

        // public static String[] thousand = {"Thousand" , "Million" , "Billion"};
         
         public String numberToWords(int num) {
            if(num == 0){
                return "Zero";
            }
            return convert(num).trim();
         
    }
      public static String convert(int num){
         if(num == 0)return "";
         else if(num < 20)return less_than_20[num];

         else if(num < 100)return tens[num / 10] + (num% 10 != 0 ? " " + less_than_20[num % 10] : "" );

         else if(num < 1000)return less_than_20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + convert(num % 100) : "");
        
         else if(num < 1000000)return convert(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convert(num % 1000) : "");

         else if(num < 1000000000)return convert(num / 1000000)+ " Million" + (num % 1000000 != 0 ? " " + convert(num % 1000000) : "");

         else{
            return convert(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convert(num % 1000000000) : "");
         }

      }
}