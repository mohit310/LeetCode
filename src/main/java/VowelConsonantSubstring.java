import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hackerrank
 * Given a string "abc", alphabetically ordered seq is a, ab, abc, b, bc, c. find only strings which start with a vowel and end with a consonant
 * consonant is any letter not in a,e,i,o,u. we choose ab, abc, and return that
 * <p>
 * Find alphabeticalls lowest and highest substring
 */
public class VowelConsonantSubstring {
    private static final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public List<String> findSubstring(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>();
        List<String> substrings = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            substrings.add(Character.valueOf(chars[i]).toString());
            for (int j = i + 1; j < chars.length; j++) {
                substrings.add(substrings.get(substrings.size() - 1) + Character.valueOf(chars[j]).toString());
            }
        }
        List<String> validSubList = new ArrayList<>();
        for (String s : substrings) {
            char[] charsSubstring = s.toCharArray();
            char startChar = charsSubstring[0];
            char endChar = charsSubstring[charsSubstring.length - 1];
            if (vowels.contains(Character.valueOf(startChar)) && !vowels.contains(endChar)) validSubList.add(s);
        }
        String min = null;
        String max = null;
        if (validSubList.size() == 0) return new ArrayList<>();
        for (String v : validSubList) {
            if (min == null) min = v;
            if (max == null) max = v;
            if (v.length() < min.length()) {
                min = v;
            }
            if (v.length() > max.length()) {
                max = v;
            }
        }
        return Arrays.asList(min, max);
    }

    public static void main(String[] args) {
        VowelConsonantSubstring v = new VowelConsonantSubstring();
        System.out.println(v.findSubstring("abc"));
    }
}
