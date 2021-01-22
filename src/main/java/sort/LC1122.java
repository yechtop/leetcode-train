package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Stream;

public class LC1122 {
    //    给你两个数组，arr1 和 arr2，
//
//    arr2 中的元素各不相同
//    arr2 中的每个元素都出现在 arr1 中
//    对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];


        //先遍历一遍 arr1，全部转为 map

        for (int val : arr1) {
            map[val]++;
        }
        int n = 0;
        LinkedList<Integer> res = new LinkedList<>();
        for (int val : arr2) {
            for (int i = 0; i < map[val]; i++) {
                arr1[n++] = val;
            }
            map[val] = 0;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                for (int j = 0; j < map[i]; j++) {
                    arr1[n++] = i;
                }
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }

}
