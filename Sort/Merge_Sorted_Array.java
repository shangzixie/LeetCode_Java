package LeetCode_Java.Sort;

import java.util.Arrays;

import static java.util.Arrays.sort;
/*
from end to start
3 pointer
 */
public class Merge_Sorted_Array {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int pointer1 = m -1 , pointer2 = n -1, pointer3 = m + n -1;

        while (pointer1 >= 0 && pointer2 >= 0){
            if (A[pointer1] >= B[pointer2]) A[pointer3--] = A[pointer1--];
            else A[pointer3--] = B[pointer2--];
        }
        while (pointer1 >= 0){
            A[pointer3--] = A[pointer1--];
        }
        while (pointer2 >= 0){
            A[pointer3--] = B[pointer2--];
        }
    }
}
