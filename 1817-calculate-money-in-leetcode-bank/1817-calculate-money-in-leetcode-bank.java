class Solution {
    public int totalMoney(int n) {
        int arr[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i ++){
            if(i % 7 == 0){
                arr[i] = (i/7) + 1;
            }else{
                arr[i] = arr[i - 1] + 1;
            }
            sum += arr[i];
        }
        return sum;
    }
}