public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalSubstring("madam"));
        System.out.println(longestPalSubstring("babass"));
    }

    private static String longestPalSubstring(String s) {
        //sanity check
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = returnLength(s, i, i);
            int evenLen = returnLength(s, i, i + 1);
            len = Math.max(oddLen, evenLen);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int returnLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - 1 - i;
    }
}
