public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindowSubstring("ADOBECODEBANC", "ABC"));
    }

    private static String minWindowSubstring(String s, String t) {
        //s = "ADOBECODEBANC", t = "ABC"
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, startIndex = -1, count = 0;
        int[] freq = new int[256];

        for (char c : t.toCharArray()) freq[c]++;

        //traverse till right pointer reaches last char
        while (right < s.length()) {
            if (freq[s.charAt(right)] > 0) {
                count++;
            }
            freq[s.charAt(right)]--;

            //shrink when something valid is found
            while (count == t.length()) {
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
