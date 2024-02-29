## 15. 三数之和

[三数之和](https://leetcode.cn/problems/3sum/)



## 题目描述

```
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
```



#### java code：

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){return res;}
        for(int mark = 0;mark < nums.length - 2 ;mark++){
            if(nums[mark] > 0){
                break;
            }
            if (mark > 0 && nums[mark] == nums[mark - 1]) {
                continue; // 跳过重复元素
            }
            int left = mark + 1,right = nums.length - 1;
            int sum = 0,target = -nums[mark];
            while(left < right){
                sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[mark], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
```

