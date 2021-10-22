const results = [];

var permuteUnique = function(nums) {
  nums = nums.sort();
  const visited = new Array(nums.length);
  for (let i = 0; i < nums.length; i++) {
    visited[i] = false;
  }

  dfs(nums, visited, []);
  return results;
}

var dfs = function(nums, visited, subset) {
  if (subset.length === nums.length) {
    results.push([...subset]);
    return;
  }

  for (let i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i - 1] === nums[i] && visited[i - 1]) continue;
    if (visited[i]) continue;

    visited[i] = true;
    subset.push(nums[i]);
    dfs(nums, visited, subset)
    visited[i] = false;
    subset.pop();
  }
}
