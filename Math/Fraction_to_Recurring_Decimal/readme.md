# 166. Fraction to Recurring Decimal

[LeetCode 166](https://leetcode.com/problems/fraction-to-recurring-decimal/)

## Methods

### Method 1

* `Time Complexity`: o(n). n is the repeating part
* `Intuition`: Two integers divided by each other, is ans is must be repeating decimal or finite decimal.
* `Algorithm`:
use string to store the decimal part and use `map` to store `remainder` and its `position`.  if there is a repeat, we could use map to confirm.

### Key Points

### Code

```java
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator ==0 ) return "0";
        StringBuffer sb = new StringBuffer();
        if (numerator < 0 ^ denominator < 0) sb.append("-");
        // convert input from `int` to `long`
        long dividend = Math.abs((long)numerator); // (long)Math.abs(numerator) is wrong, because MIN_VALUE change to MAX_VALUE will overflow
        long divisor  = Math.abs((long)denominator);

        //  7 / 6  = 1..1
        sb.append(dividend / divisor); // put int part
        long remainders = dividend % divisor;
        if (remainders == 0) return sb.toString(); // if no decimal part

        // if exists decimal part :  sb = "1.""
        sb.append(".");// we couldn't add ".)", because when 7/6, the ans is 7.1(6); or 1/2 the ans is 0.5
        HashMap<Long, Integer> map = new HashMap<>(); // key is remainders, value is remainders' position in sb
        while (remainders != 0) { // remainders as 商
            if (map.containsKey(remainders)) { // appear loop
                int index = map.get(remainders);
                sb.insert(map.get(remainders), "(");
                sb.append(")");
                break;
            }
            map.put(remainders, sb.length());
            remainders *= 10; // convert remainders to quotients
            sb.append(remainders / divisor);
            remainders %= divisor;
        }
        return sb.toString();
    }
}

```

## Reference