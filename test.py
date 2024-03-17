from collections import defaultdict
def find_all_subarrays_with_equal_odd_even(nums):
    # 前缀和差值初始化
    count_diff = 0
    # 哈希表，存储差值及其所有出现的位置
    hash_map = defaultdict(list)
    # 初始差值0出现在索引-1，便于处理从数组开始的子数组
    hash_map[0].append(-1)
    # 存储结果的列表
    subarrays = []

    for i, num in enumerate(nums):
        # 更新差值
        if num % 2 == 0:
            count_diff -= 1
        else:
            count_diff += 1
        # 如果这个差值之前出现过，说明找到了一个符合条件的子数组的结束位置
        if count_diff in hash_map:
            for start_index in hash_map[count_diff]:
                subarrays.append(nums[start_index+1:i+1])
        # 更新哈希表中差值出现的位置
        hash_map[count_diff].append(i)

    return subarrays

# 测试给定的例子
test_array = [1, 2, 1, 2]
all_subarrays = find_all_subarrays_with_equal_odd_even(test_array)
print(all_subarrays)
