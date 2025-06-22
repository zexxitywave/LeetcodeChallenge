class Solution {
    private static int countBit(int n){
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            boxedArr[i] = arr[i];
        }

        Arrays.sort(boxedArr, (a, b) ->{
            int bitA = countBit(a);
            int bitB = countBit(b);

            if(bitA == bitB){
                return a-b;
            }else{
                return bitA - bitB;
            }
        });

        int[] result = new int[boxedArr.length];
        for(int i = 0; i < boxedArr.length; i++){
            result[i] = boxedArr[i];
        }
        return result;
    }
}