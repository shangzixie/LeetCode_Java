const result = [];

var substes = function(nums) {
  nums = nums.sort();

  dfs(nums, 0, []);

  return result;
}

var dfs = function(nums, index, subset) {
  result.push([...subset]);

  for (let i = index; i < nums.length; i++) {
    subset.push(nums[i]);
    dfs(nums, i + 1, subset);
    subset.pop();
  }
}
