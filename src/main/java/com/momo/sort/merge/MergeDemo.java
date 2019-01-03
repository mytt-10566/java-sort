package com.momo.sort.merge;

import java.util.Arrays;

public class MergeDemo {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 6, 5, 4};
        nums = sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int nums[]) {
        int y[] = new int[nums.length];
        int range = 1;// 默认子序列长为1
        while (range < nums.length) {
            mergePass(nums, y, range);
            range *= 2;
            if (range < nums.length) {
                mergePass(y, nums, range);
                range *= 2;
            }
        }
        return nums.length % 2 == 0 ? y : nums;
    }


    /**
     * 一趟归并，主要用于确定相邻子序列开始的下标
     *
     * @param x
     * @param y
     * @param range
     */
    private static void mergePass(int x[], int y[], int range) {
        for (int i = 0; i < x.length; i += 2 * range) {
            merge(x, y, i, i + range, range);
        }
    }

    /***
     * 将x中以x、y开始的两个相邻子序列归并（升序）到y中，子序列长为range
     * 注：各个子序列已经排好序
     *
     * @param x
     * @param y
     * @param begin1
     * @param begin2
     * @param range
     */
    private static void merge(int x[], int y[], int begin1, int begin2, int range) {
        int i = begin1;
        int j = begin2;
        int k = begin1;

        while ((i < begin1 + range) && (j < begin2 + range) && (j < x.length)) {// 将x中两个相邻子序列归并到y中
            y[k++] = x[i] < x[j] ? x[i++] : x[j++];// 将较小值复制到y中
        }
        while (i < begin1 + range && i < x.length) {// 将前一个子序列剩余元素复制到y中
            y[k++] = x[i++];
        }
        while (j < begin2 + range && j < x.length) {// 将后一个子序列剩余元素复制到y中
            y[k++] = x[j++];
        }
    }

}
