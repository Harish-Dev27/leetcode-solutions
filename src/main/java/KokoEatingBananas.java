public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 7, 8, 11};
        int[] piles2 = {30,11,23,4,20};
        System.out.println(kokoEatingBananas(piles, 8));
        System.out.println(kokoEatingBananas(piles2, 6));
    }

    private static int kokoEatingBananas(int[] piles, int h) {
        //[3, 7, 8, 11] h=8 ans=> 4 (1+2+2+3)
        //[1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10 ,11]

        int left = 1, right = findMax(piles), ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) max = Math.max(max, i);

        return max;
    }

    private static int calculateTotalHours(int[] piles, int mid) {
        int total = 0;
        for (int i : piles) total += (int) Math.ceil((double) i / (double) mid);
        return total;
    }
}
