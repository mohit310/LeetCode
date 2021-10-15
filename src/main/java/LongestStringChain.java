import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. Longest String Chain
 * Medium
 * <p>
 * You are given an array of words where each word consists of lowercase English letters.
 * <p>
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 * <p>
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * <p>
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * <p>
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * <p>
 * Example 3:
 * <p>
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            dp.put(word, 1);
        }

        int max = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {   // delete one char from current word to find the previous string
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            max = Math.max(max, dp.get(word));
        }
        return max;
    }

    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        System.out.println(l.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}
