## 18. 四数之和

[ 四数之和](https://leetcode.cn/problems/4sum/)



## 题目描述

```
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target

你可以按任意顺序返回答案 。

示例：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```



## 思路

- 还是双指针思路，先确定一个数，剩下的就是三个数和的问题，主要需要考虑剪枝。
- 外层循环 `for(int s = 0; s < len; s++)` 遍历数组中的每一个数，作为第一个数。在循环中，进行如下操作：
  - 如果当前数大于 0 且大于目标值，说明后续的数只会更大，直接返回结果。
  - 如果当前数及其后面的三个数的和已经大于目标值，可以跳过当前循环，因为后续的和只会更大，无需再进行计算。
  - 如果当前数及其后面的三个数的和已经小于目标值，也可以跳过当前循环，因为后续的和只会更小，无需再进行计算。
  - 在内层循环中，使用双指针 `j` 和 `z` 遍历数组中的剩余部分，寻找和为目标值的四元组。
  - 如果找到和为目标值的四元组，则将其加入结果集合中。
  - 根据当前四数之和与目标值的大小关系，移动指针 `j` 或 `z`。



#### java code：

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //最外层循环，确定第一个数的位置
        for(int s = 0; s < len ; s++){
            //如果第一个数已经大于目标值，没有继续循环的必要，直接返回
            if(nums[s]>0&&nums[s]>target){
                Set<List<Integer>> uniqueTuples = new HashSet<>(res);
                res = new ArrayList<>(uniqueTuples);
                return res;
            }
            //如果第一个数和后三个数的和(升序数组，这四个数的和就是以s为第一个数和的最小值)大于目标值，直接返回
            if(s+3<len&&(long)nums[s]+nums[s+1]+nums[s+2]+nums[s+3]>target){
                continue;
            }
            //如果第一个数和最后三个数的和小于目标值，直接返回
            if(len-3>=0&&(long)nums[s]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }
            //循环确定第二个数的位置
            for(int i = s + 1; i < len; i++){
                int j = i + 1, z = len -1;
                while(j < z){
                    long sum = (long)nums[s] + nums[i] + nums[j] + nums[z];
                    if(sum == target){
                        List<Integer> tuple1 = new ArrayList<>(List.of(nums[s],nums[i],nums[j],nums[z]));
                        res.add(tuple1);
                    }
                    //根据和与目标值大小比较确定更新那个指针
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
        }
        Set<List<Integer>> uniqueTuples = new HashSet<>(res);
        res = new ArrayList<>(uniqueTuples);
        return res;
    }
}
```



#### 复杂度

- 时间复杂度：O(N^2 log N)
- 空间复杂度：O(N)