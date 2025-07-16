public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;           // Shift result left to make space
            result = result | (n & 1);      // Take the rightmost bit of n and set it in result
            n = n >> 1;                     // Shift n right to process the next bit
        }
        return result;
    }
}