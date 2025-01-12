def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

print(gcd(10, 5))  # 5
print(gcd(14, 21))  # 7