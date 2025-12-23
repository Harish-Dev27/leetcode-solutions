import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "boo";
        System.out.println(isomorphicStringsSolution(s, t));
    }

    private static boolean isomorphicStringsSolution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char actual = s.charAt(i);
            char mapping = t.charAt(i);

            if (!map.containsKey(actual)) {
                if (!map.containsValue(mapping)) {
                    map.put(actual, mapping);
                } else {
                    return false;
                }
            } else {
                char storedMappingChar = map.get(actual);
                if (storedMappingChar != mapping) {
                    return false;
                }
            }
        }

        return true;
    }
}
