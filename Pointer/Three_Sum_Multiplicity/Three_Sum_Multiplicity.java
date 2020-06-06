package LeetCode_Java.Pointer.Three_Sum_Multiplicity;

import java.util.*;

public class Three_Sum_Multiplicity {
    public int threeSumMulti(int[] nums, int target) {
        long[] count = new long[101];
        // 对A中的元素进行计数，counter[a]表示值为a的数量
        for (int num : nums){
            count[num] += 1;
        }
        long ans = 0;
        // 遍历所有可能的组合情况，并计算当前组合的数量
        // 注意此循环内的 i, j, k 为值而非nums元素的下标
        for (int i = 0; i < count.length; i++){
            for (int j = i; j < count.length; j++){
                int k = target - i - j;
                if (k > 100 || k < 0) continue;

                //2 numbers are same
                if (i == j && k != i && count[i] > 1){
                    ans += count[i] * (count[i] - 1) * count[k] / 2;
                }else if (i != j  && j < k){//3 numbers are different
                    ans += count[i] * count[j] * count[k];
                }else if (i == k && j == k && count[i] >2 ){//3 nums are same
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                }
            }
        }

        return (int)(ans % (1e9 + 7));
    }

}
