class Solution {
    public boolean isPalindrome(int x) {
        Stack<Integer> s = new Stack<>();

        if(x < 0){
            return false;
        }
        
        if(0<=x && x<10){
            return true;
        }
        int original = x;

        while(x != 0){
            s.push(x%10);
            x/=10;
        }

        int fact = 1;
        int reversed = 0;

        while(!s.isEmpty()){
            reversed += s.pop() * fact;
            fact *= 10;
        }

        return reversed == original;
        
    }
}