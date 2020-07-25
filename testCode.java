import Math.Permutation_Sequence.Permutation_Sequence;

import java.util.*;

public class testCode {
    public void solution(int[] nums) {
        // nums = 1 4 5 6 -4 -3 2 -1
        // prefix sum array = 0 1 5 10 16 12 9 11 10

        //build prefixSum array
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // build two heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int minHeapSum = 0; // sum of the minHeap

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int maxHeapSum = 0;

        // ans
        int ans = Integer.MIN_VALUE;

        // in an array, the sequence of heap is    [ maxHeap,       minHeap ....]
        //                                       minPrefixSumIndex     i
        int minPrefixSum = Integer.MAX_VALUE, minPrefixSumIndex = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            //build minHeap
            minHeap.add(prefixSum[i]);
            minHeapSum = prefixSum[i];
            // for current index i, if prefixSum[i] less than minPrefixSum, current array is
            // maxHeap, so we need to add all element from 0 to i into maxHeap, and clear minHeap
            if (minPrefixSum > prefixSum[i]) {
                // update heap
                // current index is i, we need update maxheap to i
                while (minPrefixSumIndex <= i) {
                    // update maxHeap
                    maxHeap.add(prefixSum[minPrefixSumIndex]);
                    maxHeapSum = prefixSum[minPrefixSumIndex];
                    //update minHeap
                    minHeap.clear(); // update minhead
                    minHeapSum = 0;

                    minPrefixSumIndex++;
                }

                // Update minPrefixSum and minPrefixSumIndex
                minPrefixSum = prefixSum[i];
                minPrefixSumIndex = i; // because when jumping out from while loop, minPrefixSumIndex = i + 1.
            }

            // calculate ans
            int max1 = maxHeap.size() != 0? maxHeap.poll() : 0;
            int max2 = maxHeap.size() != 0? maxHeap.poll() : 0;
            int min1 = minHeap.size() != 0? minHeap.poll() : 0;
            int min2 = minHeap.size() != 0? minHeap.poll() : 0;


        }

    }
}
