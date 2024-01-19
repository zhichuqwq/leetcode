class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            suu = target - nums[i]
            if suu in nums[i+1:]:
                return [i,nums[i+1:].index(suu)+i+1]
