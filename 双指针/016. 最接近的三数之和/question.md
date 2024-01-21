## 16. 最接近的三数之和

[最接近的三数之和](https://leetcode.cn/problems/3sum-closest/)



## 题目描述

```
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。

示例 1：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

示例 2：

输入：nums = [0,0,0], target = 1
输出：0
```



## 思路

- 先对数组进行排序，然后先固定一个数，然后双指针左右向中间查找和最接近目标值的数。
- 遇到相同的值需要跳过节约资源



#### java code：

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 999999;

        for(int i = 0; i < len; i++){
            if(i > 0  && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, z = len -1;
            while(j < z){
                int sum = nums[i] + nums[j] + nums[z];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target)< Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    z--;
                    while(nums[z] == nums[z+1] && j < z){
                        z--;
                    }
                }else{
                    j++;
                    while(nums[j] == nums[j-1] && j < z){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
```



#### 复杂度

- 时间复杂度： O(N log N) + O(N^2) = O(N^2)
- 空间复杂度： O(log N)