class Solution:
    def reverse(self, x: int) -> int:
        n = str(abs(x))[::-1]
        m = int(n)
        if -2**31 <= m <= 2**31-1:
            if x > 0:return m
            else: return -m
        else:return 0
