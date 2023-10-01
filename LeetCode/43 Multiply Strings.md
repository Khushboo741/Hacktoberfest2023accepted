# 43. Multiply Strings

Given two non-negative integers `num1` and `num2` represented as `strings`, return the product of `num1` and `num2`, also represented as a `string`.

**Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.**

 

Example 1:

| Input: num1 = "2", num2 = "3"
| Output: "6"

Example 2:

| Input: num1 = "123", num2 = "456"
| Output: "56088"
 

Constraints:

 - `1 <= num1.length, num2.length <= 200`
 - `num1` and `num2` consist of digits only.
 - Both `num1` and `num2` do not contain any leading zero, except the number `0` itself.

``` Python
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1, n2, p = 0, 0, 0
        for a in num1[::-1]:
            n1 += 10**p * int(a)
            p+=1
        p = 0
        for b in num2[::-1]:
            n2 += 10**p * int(b)
            p+=1
        return str(n2*n1)
```