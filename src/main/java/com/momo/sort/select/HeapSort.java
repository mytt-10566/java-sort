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
        buildHeap(nums);

        // 升序排序，每趟确定1个最小值，即堆顶值
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            sift(nums, 0, i);
        }
    }

    private static void buildHeap(int nums[]) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sift(nums, i, nums.length);
        }
    }

    private static void sift(int[] nums, int parent, int length) {
        int child = 2 * parent + 1;
        int value = nums[parent];

        while (child < length) {
            // 最小的子节点
            if (child + 1 < length && nums[child] > nums[child + 1]) {
                child++;
            }

            // 如果父节点小于任何一个孩子的值，直接跳出
            if (nums[parent] <= nums[child]) {
                break;
            }
            // 子节点小于父节点，交换(无需真正交换)；同时parent、child下沉
            nums[parent] = nums[child];
            // 下沉
            parent = child;
            child = 2 * parent + 1;
        }
        nums[parent] = value;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
