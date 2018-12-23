package com.momo.sort.exchange;

import java.util.Arrays;

public class BubbleDemo {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 6, 5, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 冒泡
    public static void sort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {// n-1趟
            for (int j = 0; j < nums.length - i; j++) {// 每趟比较
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
