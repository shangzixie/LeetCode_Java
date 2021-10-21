# 79. Word Search

[LeetCode 79](https://leetcode.com/problems/word-search/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

This problem does not give start position, or direction restriction, so

1.Scan board, find starting position with matching word first letter
2.From starting position, DFS (4 (up, down, left, right 4 directions) match word's rest letters
3.For each visited letter, mark it as visited, here use board[i][j] = '*' to represent visited.
4.If one direction cannot continue, backtracking, mark start position unvisited, mark board[i][j] = word[start]
5.If found any matching, terminate
6.Otherwise, no matching found, return false.

### Code

* `Code Design`:

```javascript
/*
 * @lc app=leetcode id=79 lang=javascript
 *
 * [79] Word Search
 */
function DFS(board, row, col, rows, cols, word, cur) {
  // 边界检查
  if (row >= rows || row < 0) return false;
  if (col >= cols || col < 0) return false;

  const item = board[row][col];

  if (item !== word[cur]) return false;

  if (cur + 1 === word.length) return true;

  // If use HashMap keep track visited letters, then need manual clear HashMap for each backtrack which needs extra space.
  // here we use a little trick
  board[row][col] = null;

  // UP, DOWN, LEFT, RIGHT
  const res =
    DFS(board, row + 1, col, rows, cols, word, cur + 1) ||
    DFS(board, row - 1, col, rows, cols, word, cur + 1) ||
    DFS(board, row, col - 1, rows, cols, word, cur + 1) ||
    DFS(board, row, col + 1, rows, cols, word, cur + 1);

  board[row][col] = item;

  return res;
}
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
  if (word.length === 0) return true;
  if (board.length === 0) return false;

  const rows = board.length;
  const cols = board[0].length;

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      const hit = DFS(board, i, j, rows, cols, word, 0);
      if (hit) return true;
    }
  }
  return false;
};


```

## Reference

[1](https://github.com/azl397985856/leetcode/blob/master/problems/79.word-search-en.md)