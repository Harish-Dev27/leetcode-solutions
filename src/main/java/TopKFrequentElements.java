import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3, 2, 3, 4};
        int k = 2;
        System.out.println(Arrays.toString(topKFreqElements(input, k)));
    }

    private static int[] topKFreqElements(int[] nums, int k) {
        List<Integer>[] list = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        //capture the frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Now store it in another DS with frequency up top
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (list[frequency] == null) {
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(key);
        }

        //Finally return the result array by bucket sort strategy
        int[] result = new int[k];
        int counter = 0;
        for (int i = list.length - 1; i > 0 && counter < k; i--) {
            if (list[i] != null) {
                for (int number : list[i]) {
                    result[counter++] = number;
                }
            }
        }

        return result;
    }
}
