package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public class LC56 {
    //官方解法
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - 1 - i; j++) {
                if(intervals[j][0] > intervals[j + 1][0]){
                    int [] temp = intervals[j];
                    intervals[j] = intervals[j +1];
                    intervals[j +1] = temp;
                }
            }
        }
        int start = -1;
        int end = -1;
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int nowStart = interval[0];
            int nowEnd = interval[1];

            if (res.size() == 0 || res.get(res.size() - 1)[1] < nowStart) {
                res.add(new int[]{nowStart, nowEnd});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], nowEnd);
            }
        }

        return  res.toArray(new int[res.size()][2]);
    }
    //我的解法,速度比官方还快一点
//    public int[][] merge(int[][] intervals) {
//        if(intervals.length == 1)
//            return intervals;
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
//
//        int start = -1;
//        int end = -1;
//        ArrayList<int[]> res = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int nowStart = intervals[i][0];
//            int nowEnd = intervals[i][1];
//
//            //当 nowStart > end 时，代表无法把当前的区间再合并到前一个区间了，所以就需要将前一个区间提交了
//            if(i != 0 && (nowStart > end)){
//                res.add(new int[]{start, end});
//                start = -1;
//                end = -1;
//            }else {
//                end = Math.max(end,nowEnd);
//            }
//
//            if(i == intervals.length - 1){
//                if(start == -1)
//                    start = nowStart;
//                end = Math.max(end,nowEnd);
//                res.add(new int[]{start, end});
//            }
//
//            if(start == -1){
//                start = nowStart;
//            }
//            if(end == -1)
//                end = nowEnd;
//        }
//        int [][] resArr = new int[res.size()][2];
//
//        return  res.toArray(resArr);
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LC56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

}
