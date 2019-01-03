package com.momo.sort.select;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int nums[] = new int[]{81, 49, 19, 38, 97, 76, 13, 19};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int nums[]) {
        // 构造最小堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sift(nums, i, nums.length - 1);
        }
        // 升序排序，每趟确定1个最小值，即堆顶值
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            sift(nums, 0, i - 1);
        }
    }

    private static void sift(int[] nums, int parent, int end) {
        int child = 2 * parent + 1;

        while (child <= end) {
            // 最小的子节点
            if (child < end && nums[child] > nums[child + 1]) {
                child++;
            }
            // 子节点小于父节点，交换；同时parent、child下沉
            if (nums[parent] > nums[child]) {
                // 交换
                int temp = nums[parent];
                nums[parent] = nums[child];
                nums[child] = temp;
                // 下沉
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
