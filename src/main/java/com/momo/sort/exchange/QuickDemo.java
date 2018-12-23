package com.momo.sort.exchange;

import java.util.Arrays;

public class QuickDemo {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 6, 5, 4};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // 快排
    public static void sort(int nums[], int begin, int end) {
        if (!(begin >= 0 && begin < nums.length && end >= 0 && end < nums.length && begin < end)) {
            return;
        }

        int i = begin;
        int j = end;
        int vot = nums[begin];

        while (i != j) {
            // 从后往前寻找小于vot的index
            for (; i < j && nums[j] >= vot; j--) ;
            if (i < j) {
                nums[i++] = nums[j];
            }
            // 从前往后寻找大于vot的index
            for (; i < j && nums[i] <= vot; i++) ;
            if (i < j) {
                nums[j--] = nums[i];
            }
            // 无法找到比基准值小的或大的时候，i==j
        }
        nums[i] = vot;
        sort(nums, begin, i - 1);
        sort(nums, i + 1, end);
    }
}
