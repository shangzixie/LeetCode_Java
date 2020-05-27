# 18. 4Sum

[LeetCode 18](https://leetcode.com/problems/4sum/)


## Methods

### Method 1:  
use `permutaions` recursive method  



### Key Points
need to consider repeating elements and to remove duplicates

### Code

```java
public class Four_Sum {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        boolean[] visited = new boolean[numbers.length];

        helper(numbers, target, new LinkedList<Integer>(), 0, visited);
        return results;
    }

    private void helper(int[] numbers, int target, LinkedList<Integer> path, int startIndex, boolean[] visited){
        if (startIndex >= numbers.length && target != 0) return; //reduce time complexity
        if (path.size()== 4 && target != 0) return;              //reduce time complexity
        if (path.size() == 4 && target == 0){
            results.add(new LinkedList(path));
            return;
        }

        for (int i = startIndex; i < numbers.length; i++){
            if (i > 0 && numbers[i] == numbers[i-1] && visited[i-1] == false) continue; //use visited to remove duplications

            path.add(numbers[i]);
            visited[i] = true;

            helper(numbers, target - numbers[i], path, i + 1, visited);

            visited[i] = false;
            path.removeLast();
        }
    }
}
```
### Method 2
just like 3sum: fix 2numbers and use two pointers 

### Key Points
just let `a + b + c + d = target`, so assume `a <= b <= c <= d`. Then we need to consider how to avoid repeating ans:


### Code 

```java
public class Four_Sum {
    public List<List<Integer>> fourSum1(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        // a + b + c + d = target
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) { // remove duplicates of a
                continue;
            }

            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])  //remove duplicates of b
                    continue;

                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        // a, b have been fixed, to find out the different c and d
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return rst;
    }
}
```

## Reference