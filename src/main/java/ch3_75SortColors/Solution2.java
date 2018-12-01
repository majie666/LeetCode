package ch3_75SortColors;

// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/description/
//
// 三路快速排序的思想
// 对整个数组只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {

    public void sortColors(int[] nums) {

        // [0...zero] == 0 设为-1区间无效，若设置为0，则要求第一个元素必须为0
        int zero = -1;
        // [two...n-1] == 2 同上
        int two = nums.length;

        for(int i = 0 ; i < two ; ){
            if(nums[i] == 1)
                i ++;
            else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            }
            else{ // nums[i] == 0
                assert nums[i] == 0;
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new Solution2()).sortColors(nums);
        printArr(nums);
    }
}
