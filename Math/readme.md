# Formula

## 位操作

1. `a << b` = `a * 2^b` or it could say move `a` to the left `b` bit
for example: `1 << 3` -> 二进制:`1000` -> 十进制:`8`
2. 二进制下, `a << 1` 相当与 `a * 2`, `a << 1 << b` 相当与 `a * 2^b`
3. `a >> b` = `a / 2^b`
4. `aeb` = `a * 10^b`

## 异或XOR

1. js中, 异或运算符为 `^`
2. 异或操作原理是二进制数上,每位进行异或运算. 两个数相同, 则异或结果为0, 不同时候,异或结果为1 ![14](../Image/14.png)
3. 由上述, 可以得到, `0 ^ 0 = 0, 0 ^ 1 = 1`, 0和谁异或,得到就是谁
4. 同样的, 相同数异或, 结果是0 ![16](../Image/16.png)
5. 异或满足结合律和交换律 ![15](../Image/15.png)

## 模拟进位

代码模拟进位, 变量只需要一个进位变量`carry`即可

模板:

```python
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        p1 = len(num1) - 1
        p2 = len(num2) - 1

        carry = 0
        ans = ''

        while p1 >= 0 or p2 >= 0:
            if p1 >=0: carry += int(num1[p1])
            if p2 >=0: carry += int(num2[p2])
            ans = str(carry % 10) + ans
            carry = carry // 10
            p1 = p1 - 1
            p2 = p2 - 1
        if carry > 0: ans = '1' + ans

        return ans
```

[Add_Binary](./Add_Binary/readme.md)
[Add_String](./Add_String/README.md)