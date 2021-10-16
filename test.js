/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortArray = function(nums) {
  let temp = [...nums];
  divide(0, nums.length - 1, nums, temp);

  return temp;
};

var divide = function(start, end, nums, temp) {
  if (start >= end) return;

  let mid = Math.floor((start + end) / 2)
  divide(start, mid, nums, temp);
  divide(mid + 1, end, nums, temp);
  mergeSort(start, mid, end, nums, temp);
}

var mergeSort = function(start, mid, end, nums, temp) {
  let left = start;
  let right = mid + 1;
  let index = start;

  while (left <= mid && right <= end) {
      if (nums[left] < nums[right]) {
          temp[index] = nums[left];
          left += 1;
      } else {
          temp[index] = nums[right];
          right += 1;
      }
      index += 1;

      while (left <= mid) {
          temp[index] = nums[left];
          left += 1;
          index += 1;
      }

      while (right <= mid) {
          right += 1;
          index += 1;
      }

      for (index = start; index < end + 1; index++) {
          nums[index] = temp[index];
      }
  }
}