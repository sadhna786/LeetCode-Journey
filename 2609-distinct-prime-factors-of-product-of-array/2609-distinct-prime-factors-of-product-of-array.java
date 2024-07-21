class Solution {
    public int distinctPrimeFactors(int[] nums) {
       Set<Integer> distinctPrime = new HashSet<>();
       for(int num : nums){
         Set<Integer> prime = getPrime(num);
         distinctPrime.addAll(prime);
       } 
        return distinctPrime.size();
    }
    public static Set<Integer> getPrime(int num){
        Set<Integer> primes = new HashSet<>();
         while(num % 2 == 0){
            primes.add(2);
            num /= 2;
         }

         for(int i= 3 ; i* i <= num ; i+= 2){
            while(num % i == 0){
                primes.add(i);
                num /= i;
            }
         }
          if(num > 2){
            primes.add(num);
          }

          return primes;
    }
}