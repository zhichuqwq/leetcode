class Solution:
    def maxArea(self, height: List[int]) -> int:
        left , right, res = 0 , len(height)-1, 0
        while left < right:
            if height[right] > height[left]:
                res = max(res,(right - left)* height[left])
                left += 1
            else:
                res = max(res,(right - left)* height[right],)
                right -=1
        return res
