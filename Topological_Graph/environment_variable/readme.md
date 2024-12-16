# Environment Variable

It's not LeetCode problem. It's a Google interview question.

![170](/Image/170.png)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![171](/Image/171.png)

### Code1

* `Code Design`:

```python
from collections import defaultdict, deque

def parse_environment(env_list):
    # 解析输入数组为变量和表达式
    variables = {}
    for entry in env_list:
        # 根据 '=' 拆分变量名和值
        parts = entry.split('=')
        if len(parts) != 2:
            raise ValueError(f"Invalid environment variable format: {entry}")
        var_name = parts[0].strip()
        value = parts[1].strip()
        variables[var_name] = value

    # 构建依赖图
    graph = defaultdict(list) # {node: [neighbors]}
    indegree = defaultdict(int) # {node: indegree}
    values = {}
    dependencies = defaultdict(set)

    # 遍历所有变量，构建依赖关系图
    for var, expr in variables.items():
        dependencies[var] = set()
        # 查找变量中是否有引用其他变量
        while '$' in expr:
            start_index = expr.find('$') + 1  # 发现$的位置
            end_index = expr.find('/', start_index)  # 查找引用结束位置（如果有斜杠）
            if end_index == -1:
                end_index = len(expr)  # 如果没有斜杠，说明变量名到结尾为止
            dep_var = expr[start_index:end_index]

            if dep_var in variables:
                graph[dep_var].append(var)
                indegree[var] += 1
                dependencies[var].add(dep_var)
            expr = expr[:start_index-1] + expr[end_index:]  # 移除引用的部分
        values[var] = expr  # 存储最终值（可能是变量引用的表达式）

    # 拓扑排序解析变量
    queue = deque([var for var in variables if indegree[var] == 0])
    resolved = {}

    while queue:
        current = queue.popleft()
        if current not in resolved:
            resolved[current] = resolve_value(values[current], resolved)
        for neighbor in graph[current]:
            indegree[neighbor] -= 1
            if indegree[neighbor] == 0:
                queue.append(neighbor)

    # 检测未解析的变量
    for var in variables:
        if var not in resolved:
            raise ValueError(f"Circular dependency detected or undefined variable: {var}")

    return resolved

def resolve_value(expr, resolved):
    # 替换变量引用为实际值
    while '$' in expr:
        start_index = expr.find('$') + 1
        end_index = expr.find('/', start_index)
        if end_index == -1:
            end_index = len(expr)
        var = expr[start_index:end_index]
        if var in resolved:
            expr = expr[:start_index-1] + resolved[var] + expr[end_index:]
        else:
            raise ValueError(f"Undefined variable: {var}")
    return expr

# 示例输入
env_list = [
    'VAR1 = value',
    'VAR2 = $VAR1/suffix',
    'VAR3 = $VAR2/another',
    'VAR4 = $VAR3/$VAR1'
]

# 调用解析函数
try:
    resolved_env = parse_environment(env_list)
    print(resolved_env)
except ValueError as e:
    print(f"Error: {e}")


```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
