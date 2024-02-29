class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # num3存放合并之后的数组，i，j是读取两个数组的指针
        nums3 , i , j = [] , 0 , 0
        #合并数组
        while i < len(nums1) and j <len(nums2):
            if nums1[i]<nums2[j]:
                nums3.append(nums1[i])
                i+=1
            else:
                nums3.append(nums2[j])
                j+=1
        #一个数组读取结束后把另一个数组剩余的元素直接加到num3上
        nums3.extend(nums1[i:])
        nums3.extend(nums2[j:])
        length = len(nums3)
        if length % 2:
        # 如果数组长度为偶数，取中间两个数的平均值
            return nums3[length // 2 ]
        else:
        # 如果数组长度为奇数，直接取中间的数
            return (nums3[length // 2 - 1] + nums3[length // 2 ]) / 2
