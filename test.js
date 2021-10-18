var checkSubarraySum = function(nums, k) {
  let prefixSum = 0;
  let prefixArray = {};

  for (let i = 0; i < nums.length; i++) {
    prefixSum += nums[i];
    if (prefixArray.hasOwnProperty(prefixSum % k)) {
        if (i - prefixArray[prefixSum % k] > 1) {
            return true;
        }
    } else {
        prefixArray[prefixSum % k] = i;
    }
  }

  return false;
};