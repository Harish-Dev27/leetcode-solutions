import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{0, 1}, {1, 3}, {4, 6}, {5, 9}, {11, 12}};
        System.out.println(Arrays.deepToString(mergeIntervalsSolution(intervals)));
    }


    public static int[][] mergeIntervalsSolution(int[][] intervals) {
        //edge-cases
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        //Sorting
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
