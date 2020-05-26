该题最主要是解决重复问题。 

第一是通过`if (i > 0 && numbers[i] == numbers[i-1]) continue;`去重

第二是通过`if (results.size() != 0 && results.get(results.size()-1).get(1) == nums[start] && results.get(results.size()-1).get(2) == nums[end])`