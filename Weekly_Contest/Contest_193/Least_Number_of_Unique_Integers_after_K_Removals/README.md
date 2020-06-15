# 1481. Least Number of Unique Integers after K Removals

[LeetCode ](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/)


## Methods

### Method 1
use `hashmap` and `treemap`

get HashMap: { num : occurrences}  ->
get TreeMap -> { occurrences : {num}}

then count the answer  

### Key Points


### Code
time: O(nlogn). If optimize it to O(n). Could use array instead of TreeMap. 
```java
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        TreeMap<Integer, Set<Integer>> map2 = new TreeMap<>();// List<Integer>[] map2 = new 
        
        for (int i = 0; i < arr.length; i++){
            map1.put(arr[i] , map1.getOrDefault(arr[i], 0) + 1); 
        }
        
        for (Integer num : arr){
            int times = map1.get(num); 
            if (!map2.containsKey(times)){
                map2.put(times, new HashSet());
            }
            map2.get(times).add(num);     
        }
        
        int left = map1.size(); // remians of map2 after deleting
        for (Integer times : map2.keySet()){
            if (k -  map2.get(times).size() * times >= 0){
                k -= map2.get(times).size() * times;
                left -= map2.get(times).size(); 
            }else{
                left -= k / times;  //this is hard to understand
                break;
            }
        }

        return left;
        
    }
}

```
### Method 2
use `hashmap` and `array`

### Code
time: O(nlogn). If optimize it to O(n). Could use array instead of TreeMap. 

```java

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        Set<Integer>[] map2 = new Set[arr.length + 1]; 
        
        for (int i = 0; i < arr.length; i++){
            map1.put(arr[i] , map1.getOrDefault(arr[i], 0) + 1); 
        }
        
        for (Integer num : arr){
            int times = map1.get(num); 
            if (map2[times] == null){
                map2[times] = new HashSet();
            }
            map2[times].add(num);     
        }
        
        int left = map1.size(); // remains of map2 after deleting
        for (int i = 0; i < map2.length; i++){
            if (map2[i] == null) continue; 
            
            if (k -  map2[i].size() * i >= 0){
                k -= map2[i].size() * i;
                left -= map2[i].size(); 
            }else{
                left -= k / i;              // this is the hardest point in this problem
                break;
            }
        }

        return left;
        
    }
}

```

## Reference