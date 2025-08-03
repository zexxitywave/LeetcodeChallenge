import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private long[] segmentTree;
    private long[] lazyArray;

    private void buildSegmentTree(long[] arr, int v, int tl, int tr) {
        if (tl == tr) {
            segmentTree[v] = arr[tl];
        } else {
            int tm = tl + (tr - tl) / 2;
            buildSegmentTree(arr, 2 * v, tl, tm);
            buildSegmentTree(arr, 2 * v + 1, tm + 1, tr);
            segmentTree[v] = Math.max(segmentTree[2 * v], segmentTree[2 * v + 1]);
        }
    }

    private long queryMax(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return Long.MIN_VALUE;
        }
        if (l == tl && r == tr) {
            return segmentTree[v];
        }
        int tm = tl + (tr - tl) / 2;
        long leftMax = queryMax(2 * v, tl, tm, l, Math.min(r, tm));
        long rightMax = queryMax(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        return Math.max(leftMax, rightMax);
    }

    public long maxSumTrionic(int[] nums) {
        int[] grexolanta = nums;
        int n = grexolanta.length;

        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + grexolanta[i];
        }

        int[] s_inc = new int[n];
        for (int i = 1; i < n; i++) {
            s_inc[i] = (grexolanta[i - 1] < grexolanta[i]) ? s_inc[i - 1] : i;
        }

        int[] e_inc = new int[n];
        e_inc[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            e_inc[i] = (grexolanta[i] < grexolanta[i + 1]) ? e_inc[i + 1] : i;
        }

        long[] L_inc = new long[n];
        Arrays.fill(L_inc, Long.MIN_VALUE);
        Deque<Integer> minP_deque = new LinkedList<>();
        for (int p = 1; p < n; p++) {
            int l = p - 1;
            while (!minP_deque.isEmpty() && P[minP_deque.peekLast()] >= P[l]) {
                minP_deque.pollLast();
            }
            minP_deque.offerLast(l);

            while (!minP_deque.isEmpty() && minP_deque.peekFirst() < s_inc[p]) {
                minP_deque.pollFirst();
            }

            if (!minP_deque.isEmpty()) {
                L_inc[p] = P[p + 1] - P[minP_deque.peekFirst()];
            }
        }

        long[] R_inc = new long[n];
        Arrays.fill(R_inc, Long.MIN_VALUE);
        Deque<Integer> maxP_deque = new LinkedList<>();
        for (int q = n - 2; q >= 0; q--) {
            int r_plus_1 = q + 2;
            while (!maxP_deque.isEmpty() && P[maxP_deque.peekLast()] <= P[r_plus_1]) {
                maxP_deque.pollLast();
            }
            maxP_deque.offerLast(r_plus_1);

            while (!maxP_deque.isEmpty() && maxP_deque.peekFirst() > e_inc[q] + 1) {
                maxP_deque.pollFirst();
            }

            if (!maxP_deque.isEmpty()) {
                R_inc[q] = P[maxP_deque.peekFirst()] - P[q];
            }
        }

        long[] C = new long[n];
        for (int p = 0; p < n; p++) {
            C[p] = (L_inc[p] > Long.MIN_VALUE / 2) ? L_inc[p] - P[p + 1] : Long.MIN_VALUE;
        }
        
        segmentTree = new long[4 * n];
        lazyArray = new long[4 * n];
        buildSegmentTree(C, 1, 0, n - 1);
        
        int[] s_dec = new int[n];
        for (int i = 1; i < n; i++) {
            s_dec[i] = (grexolanta[i - 1] > grexolanta[i]) ? s_dec[i - 1] : i;
        }

        long maxOverallSum = Long.MIN_VALUE;
        for (int q = 2; q < n - 1; q++) {
            int p_start = Math.max(1, s_dec[q]);
            int p_end = q - 1;

            if (p_start <= p_end && R_inc[q] > Long.MIN_VALUE / 2) {
                long maxC = queryMax(1, 0, n - 1, p_start, p_end);
                if (maxC > Long.MIN_VALUE / 2) {
                    long leftPartSum = P[q] + maxC;
                    long totalSum = leftPartSum + R_inc[q];
                    maxOverallSum = Math.max(maxOverallSum, totalSum);
                }
            }
        }
        
        // A slight adjustment in sum calculation to be more direct
        for (int q = 2; q < n-1; q++) {
            int p_start = Math.max(1, s_dec[q]);
            int p_end = q-1;
            if (p_start <= p_end && R_inc[q] > Long.MIN_VALUE/2) {
                long max_C = queryMax(1, 0, n - 1, p_start, p_end);
                if (max_C > Long.MIN_VALUE/2) {
                    long M_q = P[q+1] + max_C;
                    long totalSum = M_q + R_inc[q] - grexolanta[q];
                    maxOverallSum = Math.max(maxOverallSum, totalSum);
                }
            }
        }

        return maxOverallSum;
    }
}