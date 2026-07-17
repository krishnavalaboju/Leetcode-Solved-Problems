import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }

        long[] exact = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            long multiples = 0;
            for (int m = g; m <= maxVal; m += g) {
                multiples += count[m];
            }

            long totalPairs = (multiples * (multiples - 1)) / 2;
            for (int m = 2 * g; m <= maxVal; m += g) {
                totalPairs -= exact[m];
            }
            exact[g] = totalPairs;
        }

        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefixSum, queries[i]);
        }

        return ans;
    }

    private int binarySearch(long[] prefixSum, long target) {
        int low = 1;
        int high = prefixSum.length - 1;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
