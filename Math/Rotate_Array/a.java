class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length,n = len;
        int i = 0,index = 0, pre = nums[pos], nextMovedNum = nums[pos];

        if(k%n == 0) return;

        while (n-- != 0) {
            nextMovedNumIndex =  (index + k) % len;
            nextMovedNum = nums[pos];
            nums[pos] = pre;
            pre = nextMovedNum;
            if (pos == i) {
                pos = ++i;
                pre = nums[pos];
                nextMovedNum = nums[pos];
            }
        }
    }
}
