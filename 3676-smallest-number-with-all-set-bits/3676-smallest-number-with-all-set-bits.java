class Solution {
    public int smallestNumber(int n) {
        int msb = Integer.highestOneBit(n);
        // 5(101) --> 4(100)

        return (msb << 1) - 1;
    }
}